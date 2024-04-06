/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inegocio;

import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface IConsultasBO {

    /**
     *
     * @return
     * @throws persistenciaException
     */
    public Persona regresarPersona(Licencia licencia)throws persistenciaException;
    public Licencia regresarLicencia(String numLicencia)throws persistenciaException;
    public Automovil regresarAutomovil(String numPlaca)throws persistenciaException;
}
