/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Interfaces.IPersonasDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
public class PersonasDAO implements IPersonasDAO {
//Entidades de la clase
    private EntityManager em;
    private Persona persona;

    /**
     * Constructor de la clase PersonasDAO. Inicializa el EntityManager para
     * interactuar con la base de datos.
     */
    public PersonasDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        em = emf.createEntityManager();
    }

    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona Objeto de tipo Persona que representa la persona a
     * agregar.
     * @return true si la persona se agregó correctamente, de lo contrario
     * false.
     */
    @Override
    public boolean agregarPersona(Persona persona) {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Verifica y devuelve una persona por su RFC.
     *
     * @param rfc RFC de la persona a buscar.
     * @return Objeto de tipo Persona encontrado.
     * @throws persistenciaException Si la persona no existe.
     */
    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> rootPersona = cq.from(Persona.class);
        Predicate predicadoColonia = cb.equal(rootPersona.get("RFC"), rfc);

        cq.select(rootPersona).where(predicadoColonia);

        Persona Persona = em.createQuery(cq).getSingleResult();
        this.persona = Persona;
        return Persona;
    }

    /**
     * Devuelve la persona asociada actualmente a la instancia de PersonasDAO.
     *
     * @return Objeto de tipo Persona asociado.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada a la instancia de PersonasDAO.
     *
     * @param persona Objeto de tipo Persona a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve el EntityManager utilizado por la instancia de PersonasDAO.
     *
     * @return EntityManager asociado.
     */
    public EntityManager getEntityManager() {
        return em;
    }

    /**
     * Retorna la persona asociada a una licencia específica.
     *
     * @param licencia Objeto de tipo Licencia a través de la cual se busca la
     * persona asociada.
     * @return Objeto de tipo Persona encontrado.
     * @throws persistenciaException Si la persona no existe.
     */
    @Override
    public Persona regresarPersona(Licencia licencia) throws persistenciaException {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);

        Root<Licencia> licenciaRoot = criteriaQuery.from(Licencia.class);
        Join<Licencia, Persona> personaJoin = licenciaRoot.join("persona");

        Predicate predicate = criteriaBuilder.equal(licenciaRoot, licencia);

        criteriaQuery.select(personaJoin).where(predicate);
        TypedQuery<Persona> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();

    }

    /**
     * Retorna una lista de personas que coinciden con ciertos criterios de
     * búsqueda.
     *
     * @param nombre Nombre de la persona a buscar (puede ser vacío).
     * @param curp CURP de la persona a buscar (puede ser vacío).
     * @param anioNacimiento Año de nacimiento de la persona a buscar (puede ser
     * null).
     * @return Lista de personas encontradas.
     * @throws persistenciaException Si no se encuentran personas que coincidan
     * con los criterios de búsqueda.
     */
    @Override
    public List<Persona> regresarPersonasSimilares(String nombre, String curp, Integer anioNacimiento) throws persistenciaException {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        if (!nombre.equals("")) {
            predicates.add(criteriaBuilder.like(personaRoot.get("nombre"), nombre));
        }

        if (!curp.equals("")) {
            predicates.add(criteriaBuilder.like(personaRoot.get("curp"), curp));
        }
        if (anioNacimiento != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.function("year", Integer.class, personaRoot.get("fechaNacimiento")), anioNacimiento));
        }

        criteriaQuery.select(personaRoot).where(predicates.toArray(new Predicate[0]));
        TypedQuery<Persona> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }
}
