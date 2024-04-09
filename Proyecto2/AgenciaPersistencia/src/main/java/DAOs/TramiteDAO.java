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
 * @author yohan
 */
public class TramiteDAO implements ITramiteDAO {

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

    @Override
    public List<Tramite> ConsultaConTipo(String nombre, String tipoTramite, Calendar desde, Calendar hasta) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String jpql = "SELECT * FROM Persona  ";
        TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);

        try {
            List<Persona> personas = query.getResultList();
            List<Tramite> tramitesTemp = new ArrayList<>();
            List<Tramite> tramites= new ArrayList<>();
            for (Persona p : personas) {
                for (Tramite t : p.getTramites()) {
                    t.setPersona(p);
                    tramitesTemp.add(t);
                }
            }
            if(nombre.equals("") && tipoTramite.equals("")&& desde == null && hasta == null){
                return tramitesTemp;
            }else{
                for (Tramite t : tramitesTemp) {
                    if (!nombre.equals("") && !tipoTramite.equals("") && desde != null && hasta != null) {
                        if(t.getTipoTramite().equals(tipoTramite) && t.getPersona().getNombre().equals(nombre)&&t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0){
                           tramites.add(t);
                        }
                    }else if(!nombre.equals("") && !tipoTramite.equals("")){
                        if(t.getTipoTramite().equals(tipoTramite) && t.getPersona().getNombre().equals(nombre)){
                           tramites.add(t);
                        }
                    }else if(!nombre.equals("") && desde != null && hasta != null){
                        if(t.getPersona().getNombre().equals(nombre)&&t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0){
                           tramites.add(t);
                        }
                    }else if(!tipoTramite.equals("") && desde != null && hasta != null){
                        if(t.getTipoTramite().equals(tipoTramite) &&t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0){
                           tramites.add(t);
                        }
                    }else if(!nombre.equals("")){
                        if(t.getPersona().getNombre().equals(nombre)){
                           tramites.add(t);
                        }
                    }else if(!tipoTramite.equals("")){
                        if(t.getTipoTramite().equals(tipoTramite)){
                           tramites.add(t);
                        }
                    }else if(desde != null && hasta != null){
                        if(t.getFechaRealizacion().compareTo(desde) > 0 && t.getFechaRealizacion().compareTo(hasta) < 0){
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

    public static void main(String[] args) throws Exception {
        TramiteDAO t = new TramiteDAO();
        List<Tramite> tramites = t.Consulta("MECJ940205123");

        if (!tramites.isEmpty()) {
            System.out.println("Trámites realizados por la persona:");
            for (Tramite tramite : tramites) {
                System.out.println(tramite.getPersona());
            }
        } else {
            System.out.println("No se encontraron trámites para la persona con el nombre proporcionado.");
        }
    }

}
