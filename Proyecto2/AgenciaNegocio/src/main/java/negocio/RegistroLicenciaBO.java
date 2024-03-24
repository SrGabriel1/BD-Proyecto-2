/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.LicenciasDAO;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;
import Validadores.Validador;

/**
 *
 * @author USER
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO{

    @Override
    public void RegistrarLicencia(LicenciasDAO licencia) throws persistenciaException {
        Validador v = new Validador();
        if (v.ValidarLicencia(licencia)==true) {
             throw new persistenciaException("Hay una licencia una licencia con esos datos");
        }
        
    }

    @Override
    public boolean VerificarPersona(String rfc) throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
