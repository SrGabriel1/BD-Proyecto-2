/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import Excepciones.persistenciaException;
import Interfaces.ITramiteDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class TramiteDAO implements ITramiteDAO {

    /**
     * Realiza una consulta de trámites asociados a una persona por su RFC.
     *
     * @param RFC RFC de la persona a la que se le realizará la consulta.
     * @return Lista de trámites asociados a la persona con el RFC dado.
     * @throws Exception Si hay algún problema durante la consulta.
     */
    @Override
    public List<Tramite> Consulta(String RFC) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT t FROM Tramite t JOIN t.persona p WHERE p.RFC = :rfc";
        TypedQuery<Tramite> query = em.createQuery(jpql, Tramite.class);
        query.setParameter("rfc", RFC);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> rootPersona = cq.from(Persona.class);
        Predicate predicadoColonia = cb.equal(rootPersona.get("RFC"), RFC);

        cq.select(rootPersona).where(predicadoColonia);

        Persona Persona = em.createQuery(cq).getSingleResult();
        try {

            List<Tramite> tramites = query.getResultList();
            for (int i = 0; i < tramites.size(); i++) {
                tramites.get(i).setPersona(Persona);
            }
            if (tramites.isEmpty()) {
                throw new persistenciaException("No hay tramites de esa persona");
            }
            return tramites;
        } catch (NoResultException e) {
            throw new persistenciaException(e.getMessage());

        }
    }

    /**
     * Realiza una consulta de trámites con filtros opcionales.
     *
     * @param nombre Nombre de la persona asociada a los trámites a consultar
     * (puede ser vacío).
     * @param tipoTramite Tipo de trámite a consultar (puede ser vacío).
     * @param desde Fecha mínima de realización del trámite (puede ser null).
     * @param hasta Fecha máxima de realización del trámite (puede ser null).
     * @return Lista de trámites que coinciden con los filtros proporcionados.
     * @throws Exception Si hay algún problema durante la consulta.
     */
    @Override
    public List<Tramite> ConsultaConTipo(String nombre, String tipoTramite, Calendar desde, Calendar hasta) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String jpql = "SELECT p FROM Persona p ";
        TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);

        try {
            List<Persona> personas = query.getResultList();
            List<Tramite> tramitesTemp = new ArrayList<>();
            List<Tramite> tramites = new ArrayList<>();
            for (Persona p : personas) {
                for (Tramite t : p.getTramites()) {
                    t.setPersona(p);
                    tramitesTemp.add(t);
                }
            }
            if (nombre.equals("") && tipoTramite.equals("") && desde == null && hasta == null) {
                return tramitesTemp;
            } else {
                for (Tramite t : tramitesTemp) {
                    if (!nombre.equals("") && !tipoTramite.equals("") && desde != null && hasta != null) {
                        if (t.getTipoTramite().equals(tipoTramite) && t.getPersona().getNombre().equals(nombre) && t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0) {
                            tramites.add(t);
                        }
                    } else if (!nombre.equals("") && !tipoTramite.equals("")) {
                        if (t.getTipoTramite().equals(tipoTramite) && t.getPersona().getNombre().equals(nombre)) {
                            tramites.add(t);
                        }
                    } else if (!nombre.equals("") && desde != null && hasta != null) {
                        if (t.getPersona().getNombre().equals(nombre) && t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0) {
                            tramites.add(t);
                        }
                    } else if (!tipoTramite.equals("") && desde != null && hasta != null) {
                        if (t.getTipoTramite().equals(tipoTramite) && t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0) {
                            tramites.add(t);
                        }
                    } else if (!nombre.equals("")) {
                        if (t.getPersona().getNombre().equals(nombre)) {
                            tramites.add(t);
                        }
                    } else if (!tipoTramite.equals("")) {
                        if (t.getTipoTramite().equals(tipoTramite)) {
                            tramites.add(t);
                        }
                    } else if (desde != null && hasta != null) {
                        if (t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0) {
                            tramites.add(t);
                        }
                    }
                }
                return tramites;
            }
        } catch (NoResultException e) {
            throw new persistenciaException("No se encontraron trámites para la persona con el tipo proporcionado");
        } finally {
            em.close();
            emf.close();
        }
    }

    /**
     * Este método main se utiliza para realizar una consulta de trámites
     * utilizando el método ConsultaConTipo de la clase TramiteDAO. Se
     * proporciona el nombre de la persona y el tipo de trámite como parámetros
     * de consulta. Si se encuentran trámites asociados a la persona con el
     * nombre proporcionado, se muestran por consola. Si no se encuentran
     * trámites asociados a la persona con el nombre proporcionado, se muestra
     * un mensaje indicando que no se encontraron trámites.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este
     * método).
     * @throws Exception Si hay algún problema durante la consulta.
     */
    public static void main(String[] args) throws Exception {
        TramiteDAO t = new TramiteDAO();
        List<Tramite> tramites = t.ConsultaConTipo("Elena", "Licencia", null, null);

        if (!tramites.isEmpty()) {
            System.out.println("Trámites realizados por la persona:");
            for (Tramite tramite : tramites) {
                System.out.println(tramite);
            }
        } else {
            System.out.println("No se encontraron trámites para la persona con el nombre proporcionado.");
        }
    }

}
