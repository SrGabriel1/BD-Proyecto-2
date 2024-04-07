/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import DAOs.PersonasDAO;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Interfaces.IPersonasDAO;

/**
 *
 * @author yohan
 */
public class PersonaDTO{
  
    private IPersonasDAO personasDAO;

    public PersonaDTO() {
        this.personasDAO = new PersonasDAO(); 
    }

    
    public boolean agregarPersona(Persona persona) {
        return personasDAO.agregarPersona(persona);
    }

    
    
    
}

