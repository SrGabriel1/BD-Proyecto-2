/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Persona;
import Excepciones.persistenciaException;
import Interfaces.IPersonasDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author USER
 */
public class PersonasDAO implements IPersonasDAO {

   Persona Persona;
   
    @Override
    public boolean agregarPersona(Persona persona) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    

    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> rootPersona = cq.from(Persona.class);
        Predicate predicadoColonia = cb.equal(rootPersona.get("RFC"), rfc);

        cq.select(rootPersona).where(predicadoColonia);

        Persona persona = em.createQuery(cq).getSingleResult();
        this.Persona = persona;
        return persona;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
    
}


