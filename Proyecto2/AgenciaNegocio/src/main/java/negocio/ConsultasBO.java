/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.AutomovilDAO;
import DAOs.LicenciasDAO;
import DAOs.PersonasDAO;
import DAOs.TramiteDAO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import Excepciones.persistenciaException;
import Inegocio.IConsultasBO;
import Interfaces.IAutomovilDAO;
import Interfaces.ILicenciasDAO;
import Interfaces.IPersonasDAO;
import Interfaces.ITramiteDAO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class ConsultasBO implements IConsultasBO {

    /**
     * Regresa la persona asociada a la licencia.
     *
     * @param licencia La licencia de la persona a buscar.
     * @return La persona asociada a la licencia.
     * @throws persistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Persona regresarPersona(Licencia licencia) throws persistenciaException {
        IPersonasDAO ipersona = new PersonasDAO();
        try {
            return ipersona.regresarPersona(licencia);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }

    /**
     * Regresa la licencia asociada al número de licencia proporcionado.
     *
     * @param numLicencia El número de licencia.
     * @return La licencia asociada al número proporcionado.
     * @throws persistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException {
        if (numLicencia.equals("")) {
            throw new persistenciaException("Escribe el número de licencia");
        }
        ILicenciasDAO ilicencia = new LicenciasDAO();

        try {
            return ilicencia.regresarLicencia(numLicencia);
        } catch (persistenciaException ex) {
            throw new persistenciaException(ex.getMessage());

        }
    }

    /**
     * Regresa el automóvil asociado al número de placa proporcionado.
     *
     * @param numPlaca El número de placa.
     * @return El automóvil asociado al número de placa.
     * @throws persistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Automovil regresarAutomovil(String numPlaca) throws persistenciaException {
        if (numPlaca.equals("")) {
            throw new persistenciaException("Escribe el número de placa");
        }
        IAutomovilDAO iAutomovilDAO = new AutomovilDAO();
        return iAutomovilDAO.buscarAutomovilPorPlaca(numPlaca);

    }

    /**
     * Comprueba si el automóvil y la licencia pertenecen a la misma persona.
     *
     * @param auto El automóvil.
     * @param licencia La licencia.
     * @throws persistenciaException Si el automóvil y la licencia no pertenecen
     * a la misma persona.
     */
    @Override
    public void comprobarMismoDueno(Automovil auto, Licencia licencia) throws persistenciaException {
        if (auto.getPersona().getId() != licencia.getPersona().getId()) {
            throw new persistenciaException("La licencia y el automovil no pertenecen a la misma persona");
        }

    }

    /**
     * Realiza una consulta de trámites realizados por una persona con RFC dado.
     *
     * @param RFC El RFC de la persona.
     * @return Lista de trámites realizados por la persona.
     * @throws persistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Tramite> ConsultaTramite(String RFC) throws persistenciaException {
        ITramiteDAO tramite = new TramiteDAO();
        try {
            if (tramite.Consulta(RFC).isEmpty()) {
                throw new persistenciaException();
            }
            return tramite.Consulta(RFC);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }

    /**
     * Regresa una lista de personas que tienen similitudes en el nombre, CURP y
     * año de nacimiento.
     *
     * @param nombre El nombre para buscar similitudes.
     * @param curp La CURP para buscar similitudes.
     * @param anioNacimiento El año de nacimiento para buscar similitudes.
     * @return Lista de personas que cumplen con los criterios de búsqueda.
     * @throws persistenciaException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<Persona> regresarPersonasSimilares(String nombre, String curp, Integer anioNacimiento) throws persistenciaException {
        IPersonasDAO ipersona = new PersonasDAO();
        try {
            return ipersona.regresarPersonasSimilares(nombre, curp, anioNacimiento);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }

   
//    public static void main(String[] args) throws Exception {
//        ConsultasBO t = new ConsultasBO();
//        List<Tramite> tramites = t.ConsultaTramite("MECJ940205123");
//
//        if (!tramites.isEmpty()) {
//            System.out.println("Trámites realizados por la persona:");
//            for (Tramite tramite : tramites) {
//                System.out.println(tramite);
//            }
//        } else {
//            System.out.println("No se encontraron trámites para la persona con el nombre proporcionado.");
//        }
//    }

    /**
     * Realiza una consulta de trámites con un tipo específico realizados por
     * una persona entre dos fechas.
     *
     * @param nombre El nombre de la persona.
     * @param tipoTramite El tipo de trámite.
     * @param desde Fecha de inicio para la consulta.
     * @param hasta Fecha de fin para la consulta.
     * @return Lista de trámites que cumplen con los criterios de búsqueda.
     * @throws persistenciaException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Tramite> ConsultaConTipo(String nombre, String tipoTramite, Calendar desde, Calendar hasta) throws persistenciaException {
        ITramiteDAO tramite = new TramiteDAO();
        try {
            if (tramite.ConsultaConTipo(nombre, tipoTramite, desde, hasta).isEmpty()) {
                throw new persistenciaException();
            }
            return tramite.ConsultaConTipo(nombre, tipoTramite, desde, hasta);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }
}
