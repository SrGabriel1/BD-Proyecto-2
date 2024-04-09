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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class PersonaDTO {

    //Atributos de la clase
    private IPersonasDAO personasDAO;

    /**
     * Constructor de PersonaDTO que inicializa el objeto PersonasDAO.
     */
    public PersonaDTO() {
        this.personasDAO = new PersonasDAO();
    }

    /**
     * Agrega una persona.
     *
     * @param persona La persona a agregar.
     * @return true si la operación de agregar fue exitosa, false en caso
     * contrario.
     */
    public boolean agregarPersona(Persona persona) {
        return personasDAO.agregarPersona(persona);
    }

}
