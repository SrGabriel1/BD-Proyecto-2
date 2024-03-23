/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Persona;
import Interfaces.IPersonasDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class PersonasDAO implements IPersonasDAO{

    @Override
    public boolean agregarPersona(Persona persona) {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(persona); 
            em.getTransaction().commit();
            em.close();
        emf.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
