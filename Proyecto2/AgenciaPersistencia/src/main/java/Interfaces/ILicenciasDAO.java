/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface ILicenciasDAO {
    public boolean agregarLicencia(Licencia licencia ) throws persistenciaException;    
   public  boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException;

}
