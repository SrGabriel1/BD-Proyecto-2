/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inegocio;

import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import Excepciones.persistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public interface IConsultasBO {

    /**
     * Retorna la persona asociada a la licencia especificada.
     *
     * @param licencia La licencia de la cual se desea obtener la persona
     * asociada.
     * @return La persona asociada a la licencia especificada.
     * @throws persistenciaException Si ocurre algún error durante la
     * persistencia de datos.
     */
    public Persona regresarPersona(Licencia licencia) throws persistenciaException;

    /**
     * Retorna la licencia asociada al número de licencia especificado.
     *
     * @param numLicencia El número de licencia de la cual se desea obtener la
     * información.
     * @return La licencia asociada al número de licencia especificado.
     * @throws persistenciaException Si ocurre algún error durante la
     * persistencia de datos.
     */
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException;

    /**
     * Retorna el automóvil asociado al número de placa especificado.
     *
     * @param numPlaca El número de placa del automóvil que se desea obtener.
     * @return El automóvil asociado al número de placa especificado.
     * @throws persistenciaException Si ocurre algún error durante la
     * persistencia de datos.
     */
    public Automovil regresarAutomovil(String numPlaca) throws persistenciaException;

    /**
     * Comprueba si el automóvil y la licencia pertenecen al mismo propietario.
     *
     * @param auto El automóvil que se va a verificar.
     * @param licencia La licencia que se va a verificar.
     * @throws persistenciaException Si el automóvil y la licencia no pertenecen
     * al mismo propietario.
     */
    public void comprobarMismoDueno(Automovil auto, Licencia licencia) throws persistenciaException;

    /**
     * Realiza una consulta de trámites asociados a una persona identificada por
     * su RFC.
     *
     * @param RFC El RFC de la persona para la cual se realizará la consulta de
     * trámites.
     * @return Una lista de trámites asociados a la persona identificada por el
     * RFC.
     * @throws persistenciaException Si ocurre un error durante la consulta de
     * trámites.
     */
    public List<Tramite> ConsultaTramite(String RFC) throws persistenciaException;

    /**
     * Realiza una consulta de personas que tienen información similar al
     * nombre, CURP y año de nacimiento especificados.
     *
     * @param nombre El nombre que se utilizará como criterio de búsqueda.
     * @param curp La CURP que se utilizará como criterio de búsqueda.
     * @param anioNacimiento El año de nacimiento que se utilizará como criterio
     * de búsqueda.
     * @return Una lista de personas que tienen información similar al nombre,
     * CURP y año de nacimiento especificados.
     * @throws persistenciaException Si ocurre un error durante la consulta de
     * personas similares.
     */
    public List<Persona> regresarPersonasSimilares(String nombre, String curp, Integer anioNacimiento) throws persistenciaException;

    /**
     * Realiza una consulta de trámites realizados por una persona con un tipo
     * de trámite específico en un rango de fechas.
     *
     * @param nombre El nombre de la persona cuyos trámites se desean consultar.
     * @param tipoTramite El tipo de trámite que se desea consultar.
     * @param desde La fecha de inicio del rango de fechas para la consulta.
     * @param hasta La fecha de fin del rango de fechas para la consulta.
     * @return Una lista de trámites realizados por la persona con el tipo de
     * trámite especificado en el rango de fechas.
     * @throws persistenciaException Si ocurre un error durante la consulta de
     * trámites.
     */
    public List<Tramite> ConsultaConTipo(String nombre, String tipoTramite, Calendar desde, Calendar hasta) throws persistenciaException;
}
