/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOs.PersonasDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface IPersonasDAO {

    public boolean agregarPersona(Persona persona);

    public Persona VerificarPersona(String rfc) throws persistenciaException;
    
    public Persona regresarPersona(Licencia licencia) throws persistenciaException;

}
