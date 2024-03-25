/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inegocio;

import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface IRegistroLicenciaBO {

    public void RegistrarLicencia(Licencia licencia) throws persistenciaException;

    public Persona VerificarPersona(String rfc) throws persistenciaException;

    public Licencia MostrarLicencia() throws persistenciaException;

}
