/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.LicenciasDAO;
import DAOs.PersonasDAO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Inegocio.IConsultasBO;
import Interfaces.ILicenciasDAO;
import Interfaces.IPersonasDAO;

/**
 *
 * @author USER
 */
public class ConsultasBO implements IConsultasBO{

    @Override
    public Persona regresarPersona(Licencia licencia) throws persistenciaException {
        IPersonasDAO ipersona=new PersonasDAO();
        try{
            return ipersona.regresarPersona(licencia);
        }catch(Exception e){
            throw new persistenciaException(e.getMessage()); 
        }
    }

    @Override
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException{
        ILicenciasDAO ilicencia = new LicenciasDAO();
       
        try {
            return ilicencia.regresarLicencia(numLicencia);
        } catch (persistenciaException ex) {
            throw new persistenciaException(ex.getMessage()); 
            
        }
    }

    @Override
    public Automovil regresarAutomovil() throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
