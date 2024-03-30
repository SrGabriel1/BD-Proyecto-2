/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.LicenciasDAO;
import DAOs.PlacasDAO;
import DTOs.LicenciaDTO;
import DTOs.PersonaDTO;
import DTOs.PlacasDTO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;
import Interfaces.ILicenciasDAO;
import Interfaces.IPlacasDAO;

import Validadores.Validador;

/**
 *
 * @author USER
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    private PersonaDTO personaDTO;
    private LicenciaDTO licenciaDTO;

    public RegistroLicenciaBO() {
        this.personaDTO = new  PersonaDTO();
        this.licenciaDTO = new LicenciaDTO();
    }

    public RegistroLicenciaBO(PersonaDTO personaDTO, LicenciaDTO licenciaDTO) {
        this.personaDTO = personaDTO;
        this.licenciaDTO = licenciaDTO;
    }

    @Override
    public void RegistrarLicencia(LicenciaDTO licenciadto) throws persistenciaException {
        Validador validador = new Validador();
        Licencia licencia=new Licencia(licenciadto.getVigencia(), licenciadto.getTipoLicencia(), licenciadto.getPrecio(), licenciadto.getEstado(),licenciadto.getPersona());
        ILicenciasDAO ilicencia=new LicenciasDAO();
        if (validador.ValidarLicencia(licencia)) {
            throw new persistenciaException("Hay una licencia con esos datos");
        }
        if (ilicencia.agregarLicencia(licencia)) {
            Persona persona = licencia.getPersona();
            if (persona != null) {
                persona.agregarLicencia(licencia);
            } else {
                throw new persistenciaException("Error: la licencia no está asociada a una persona.");
            }

            System.out.println("Licencia agregada correctamente a la persona.");
        } else {
            throw new persistenciaException("Error al agregar la licencia.");
        }
    }

    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        return personaDTO.VerificarPersona(rfc);
    }

    @Override
    public void RegistrarPlacasNuevas(PlacasDTO placadto, Automovil auto) throws persistenciaException {
        Validador validador = new Validador();
        String numeroPlaca = Placas.generarPlaca();
        placadto.setEstado("Activa");
        Placas placa = new Placas(numeroPlaca, placadto.getFecha_emision(), placadto.getFecha_recepcion(), placadto.getCosto(), placadto.getAuto_id(), placadto.getTipo(),placadto.getEstado());
        IPlacasDAO Iplacas = new PlacasDAO();
        if(validador.ValidarPlaca(placa)){
              throw new persistenciaException("Hay una placa con esos datos");
        }
         if(Iplacas.agregarPlacas(placa)){
             if(auto != null){
                 auto.agregarPlaca(placa);
             } else{
                  throw new persistenciaException("Error: la placa no está asociada a un automóvil.");
             }
         } else{
             throw new persistenciaException("Error al agregar la placa");
         }
        
    }

    //popipopopipo


    @Override
    public void RegistrarPlacasViejas(PlacasDTO placa) throws persistenciaException {
         Validador validador = new Validador();
    Placas nuevaPlaca = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), placa.getAuto_id(), placa.getTipo(),placa.getEstado());
    IPlacasDAO Iplacas = new PlacasDAO();

    // Validar que la placa no esté ya registrada
    if (validador.ValidarPlaca(nuevaPlaca)) {
        throw new persistenciaException("La placa ya está registrada.");
    }

    // Verificar que el automóvil esté registrado y asociado a una placa activa
    Automovil automovil = nuevaPlaca.getAuto_id();
    if (automovil == null) {
        throw new persistenciaException("Error: la placa no está asociada a un automóvil registrado.");
    }

    // Buscar una placa activa asociada al automóvil
    Placas placaActiva = automovil.buscarPlacaActiva(); // Supongamos que tienes un método en Automovil para buscar la placa activa
    if (placaActiva != null) {
        // Asociar las placas al automóvil y agregarlas
        if (Iplacas.asociarPlacas(nuevaPlaca, automovil)) {
            automovil.agregarPlaca(nuevaPlaca);
            // Desactivar la placa activa anterior
            placaActiva.setEstado("Desactivada");
            // Actualizar la placa activa en la base de datos
            Iplacas.actualizarPlaca(placaActiva);
            
            // Generar nuevas placas y asociarlas al automóvil
            String numeroPlacaNueva = Placas.generarPlaca();
            placa.setNumero(numeroPlacaNueva);
            placa.setEstado("Activa");
            Placas nuevaPlacaNueva = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), automovil, placa.getTipo(), placa.getEstado());
            if (!validador.ValidarPlaca(nuevaPlacaNueva) && Iplacas.agregarPlacas(nuevaPlacaNueva)) {
                automovil.agregarPlaca(nuevaPlacaNueva);
            } else {
                throw new persistenciaException("Error al generar y asociar las nuevas placas al automóvil.");
            }
        } else {
            throw new persistenciaException("Error al asociar las placas al automóvil registrado.");
        }
    } else {
        throw new persistenciaException("No se encontró una placa activa asociada al automóvil.");
    }
    }

}
