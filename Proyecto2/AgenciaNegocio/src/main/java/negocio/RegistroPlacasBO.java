/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.AutomovilDAO;
import DAOs.PlacasDAO;
import DTOs.AutomovilDTO;
import DTOs.PlacaDTO;
import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Inegocio.IRegistroPlacasBO;
import Interfaces.IAutomovilDAO;
import Interfaces.IPlacasDAO;
import Validadores.Validador;

/**
 *
 * @author USER
 */
public class RegistroPlacasBO implements IRegistroPlacasBO {

    @Override
    public String RegistrarPlacasNuevas(PlacaDTO placadto, AutomovilDTO auto) throws persistenciaException {
        Validador validador = new Validador();
        String numeroPlaca = Placas.generarPlaca();
        placadto.setEstado("Activa");
        Automovil autoTemp=new Automovil(auto.getNumero_Serie(),auto.getModelo(),auto.getLínea(),auto.getMarca(),auto.getColor(),auto.getPersona());
        Placas placa = new Placas(numeroPlaca, placadto.getFecha_emision(), placadto.getFecha_recepcion(), placadto.getCosto(), autoTemp, placadto.getTipo(), placadto.getEstado());
        
        IAutomovilDAO Iautomovil=new AutomovilDAO();
        if (validador.ValidarPlaca(placa)) {
            throw new persistenciaException("Hay una placa con esos datos");
        }else{
            try{
               Iautomovil.registrarAutoYPlaca(placa, autoTemp); 
               return numeroPlaca;
            }catch(Exception e){
                throw new persistenciaException(e.getMessage());
            }
            
        }
    }

    
    @Override
    public String RegistrarPlacasViejas(PlacaDTO placa) throws persistenciaException {
        /**
        Validador validador = new Validador();
        Placas Placa = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), placa.getAuto_id(), placa.getTipo(), placa.getEstado());
        IPlacasDAO Iplacas = new PlacasDAO();
        IAutomovilDAO Iautomovil=new AutomovilDAO();
        

        // Validar que la placa no este ya registrada
        if (validador.ValidarPlaca(Placa)) {
            throw new persistenciaException("La placa ya esta registrada.");
        }

        // Verificar que el automóvil esté registrado y asociado a una placa activa
        Automovil automovil = Placa.getAuto_id();
        AutomovilDTO auto = new AutomovilDTO();
        if (automovil == null) {
            throw new persistenciaException("Error: la placa no está asociada a un automóvil registrado.");
        }

        // Buscar una placa activa asociada al automóvil
        Placas placaActiva = Iautomovil.buscarPlacaActiva(automovil);
        if (placaActiva != null) {
            // Asociar las placas al automóvil y agregarlas
            if (Iplacas.asociarPlacas(Placa, automovil)) {
                Iautomovil.agregarPlaca(Placa,automovil);
                // Desactivar la placa activa anterior
                placaActiva.setEstado("Desactivada");
                // Actualizar la placa activa en la base de datos
                Iplacas.actualizarPlaca(placaActiva);

                // Generar nuevas placas y asociarlas al automóvil
                String numeroPlacaNueva = Placas.generarPlaca();
                placa.setNumero(numeroPlacaNueva);
                placa.setEstado("Activa");
                
                Placas nuevaPlaca = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), automovil, placa.getTipo(), placa.getEstado());
                if (!validador.ValidarPlaca(nuevaPlaca) && Iplacas.agregarPlacas(nuevaPlaca)) {
                    Iautomovil.agregarPlaca(nuevaPlaca,automovil);
                    return numeroPlacaNueva;
                } else {
                    throw new persistenciaException("Error al generar y asociar las nuevas placas al automóvil.");
                }
            } else {
                throw new persistenciaException("Error al asociar las placas al automóvil registrado.");
            }
        } else {
            throw new persistenciaException("No se encontró una placa activa asociada al automóvil.");
        }**/
        return "wasap danger";
    }
}
