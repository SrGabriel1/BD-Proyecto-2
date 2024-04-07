/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Interfaces.ILicenciasDAO;
import com.mysql.cj.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author USER
 */
public class LicenciasDAO implements ILicenciasDAO {

    @Override
    public boolean agregarLicencia(Licencia licencia) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;

    }


    @Override
    public boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        persona.agregarLicencia(licencia); 
        em.merge(persona); 

        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }
    @Override
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT l FROM Licencia l WHERE l.numeroLicencia = :numero";
        TypedQuery<Licencia> query = em.createQuery(jpql, Licencia.class);
        query.setParameter("numero", numLicencia);
        try {
            Licencia licenciaTemp = (Licencia) query.getSingleResult();
            if(licenciaTemp.getEstado().equals("Vencida")){
                throw new persistenciaException("Su licencia está vencida");
            }
            return licenciaTemp;
        } catch (NoResultException e) {
            throw new persistenciaException("Esa licencia no existe");
            
        }
    }

    
}
