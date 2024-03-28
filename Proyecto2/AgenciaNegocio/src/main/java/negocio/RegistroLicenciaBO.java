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
        Placas placa = new Placas(placadto.getNumero(), placadto.getFecha_emision(), placadto.getFecha_recepcion(), placadto.getCosto(), placadto.getAuto_id(), placadto.getTipo());
        IPlacasDAO Iplacas = new PlacasDAO();
        if(validador.ValidarPlaca(placa)){
              throw new persistenciaException("Hay una placa con esos datos");
        }
         if(Iplacas.agregarPlacas(placa)){
             Automovil auto2 = placa.getAuto_id();
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
       
    }

}
