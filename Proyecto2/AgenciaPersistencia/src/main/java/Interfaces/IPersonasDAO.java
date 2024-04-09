/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOs.PersonasDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import java.util.List;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public interface IPersonasDAO {

    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona La persona que se desea agregar.
     * @return true si la persona se agrega correctamente, false en caso
     * contrario.
     */
    public boolean agregarPersona(Persona persona);

    /**
     * Verifica si una persona con el RFC especificado existe en la base de
     * datos.
     *
     * @param rfc El RFC de la persona que se desea verificar.
     * @return La persona correspondiente al RFC especificado, si existe; null
     * en caso contrario.
     * @throws persistenciaException Si ocurre un error durante la verificación
     * de la persona.
     */
    public Persona VerificarPersona(String rfc) throws persistenciaException;

    /**
     * Busca la persona asociada a una licencia en la base de datos y la
     * retorna.
     *
     * @param licencia La licencia de la persona que se desea buscar.
     * @return La persona asociada a la licencia especificada.
     * @throws persistenciaException Si ocurre un error durante la búsqueda de
     * la persona.
     */
    public Persona regresarPersona(Licencia licencia) throws persistenciaException;

    /**
     * Retorna una lista de personas que tienen un nombre, CURP y año de
     * nacimiento similares a los especificados.
     *
     * @param nombre El nombre de la persona o parte de él.
     * @param curp La CURP de la persona o parte de ella.
     * @param anioNacimiento El año de nacimiento de la persona.
     * @return La lista de personas que cumplen con los criterios de búsqueda.
     * @throws persistenciaException Si ocurre un error durante la búsqueda de
     * personas similares.
     */
    public List<Persona> regresarPersonasSimilares(String nombre, String curp, Integer anioNacimiento) throws persistenciaException;
}
