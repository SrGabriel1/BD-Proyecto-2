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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public interface ILicenciasDAO {

    /**
     * Agrega una nueva licencia a la base de datos.
     *
     * @param licencia La licencia que se desea agregar.
     * @return true si la licencia se agrega correctamente, false en caso
     * contrario.
     * @throws persistenciaException Si ocurre un error durante la persistencia
     * de los datos.
     */
    public boolean agregarLicencia(Licencia licencia) throws persistenciaException;

    /**
     * Asocia una licencia existente a una persona en la base de datos.
     *
     * @param licencia La licencia que se desea asociar a la persona.
     * @param persona La persona a la que se asociará la licencia.
     * @return true si la asociación se realiza correctamente, false en caso
     * contrario.
     * @throws persistenciaException Si ocurre un error durante la asociación de
     * la licencia.
     */
    public boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException;

    /**
     * Busca una licencia por su número en la base de datos y la retorna.
     *
     * @param numLicencia El número de licencia que se desea buscar.
     * @return La licencia correspondiente al número especificado.
     * @throws persistenciaException Si ocurre un error durante la búsqueda de
     * la licencia.
     */
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException;

}
