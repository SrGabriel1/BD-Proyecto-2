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
import Inegocio.IConsultasBO;
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
    public String RegistrarPlacasViejas(String numeroPlaca,PlacaDTO placa) throws persistenciaException {
        
        Validador validador = new Validador();
        Placas Placa = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), placa.getAuto_id(), placa.getTipo(), placa.getEstado());
        IPlacasDAO Iplacas = new PlacasDAO();
        IAutomovilDAO Iautomovil=new AutomovilDAO();
        IConsultasBO consultas=new ConsultasBO();
        try{
            Automovil autoTemp=consultas.regresarAutomovil(numeroPlaca);
            Iautomovil.actualizarPlaca(Placa, autoTemp);
            return placa.getNumero();
        }catch(Exception e){
            throw new persistenciaException(e.getMessage());
        }
        
    }
}
