/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Tramite;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public interface ITramiteDAO {

    /**
     * Consulta los trámites asociados a una persona mediante su RFC.
     *
     * @param RFC El RFC de la persona.
     * @return Una lista de trámites asociados a la persona con el RFC
     * especificado.
     * @throws Exception Si ocurre un error durante la consulta de los trámites.
     */
    public List<Tramite> Consulta(String RFC) throws Exception;

    /**
     * Consulta trámites con un tipo específico realizados por una persona en un
     * rango de fechas.
     *
     * @param nombre El nombre de la persona.
     * @param tipoTramite El tipo de trámite a consultar.
     * @param desde La fecha de inicio del rango de búsqueda.
     * @param hasta La fecha de fin del rango de búsqueda.
     * @return Una lista de trámites realizados por la persona con el nombre
     * especificado, del tipo especificado y realizados en el rango de fechas
     * especificado.
     * @throws Exception Si ocurre un error durante la consulta de los trámites.
     */
    public List<Tramite> ConsultaConTipo(String nombre, String tipoTramite, Calendar desde, Calendar hasta) throws Exception;
}
