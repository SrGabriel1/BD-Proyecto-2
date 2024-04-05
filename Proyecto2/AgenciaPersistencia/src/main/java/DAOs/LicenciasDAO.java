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
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author USER
 */
public class LicenciasDAO implements ILicenciasDAO {

    Licencia licencia;

    @Override
    public boolean agregarLicencia(Licencia licencia) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(licencia);
        em.getTransaction().commit();
        this.licencia = licencia;
        em.close();
        emf.close();
        return true;

    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(String vigencia, String tipo, Float precio, String estado, Persona persona) {
        this.licencia = new Licencia(vigencia, tipo, precio, estado, persona);
    }

    @Override
    public boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        persona.agregarLicencia(licencia); // Asociar la licencia a la persona
        em.merge(persona); // Actualizar la persona en la base de datos
        this.licencia = licencia;

        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }
    @Override
    public Licencia regresarLicencia(String numLicencia)throws persistenciaException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        String jpql = "SELECT l FROM Licencia l WHERE l.Numero_Licencia = :numero";
        TypedQuery<Licencia> query = em.createQuery(jpql, Licencia.class);
        query.setParameter("numero", numLicencia);
        Licencia licenciaTemp=query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return licenciaTemp;
        
        
        
    }

    
}
