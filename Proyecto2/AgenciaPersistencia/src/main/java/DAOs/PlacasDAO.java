/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Automovil;
import Entidades.Persona;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IPlacasDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author yohan
 */
public class PlacasDAO implements IPlacasDAO {

    private EntityManager em;

    public PlacasDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        em = emf.createEntityManager();
    }

    @Override
    public String GenerarNumero() throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarPlacas(Placas placas) throws persistenciaException {
        try {
            em.getTransaction().begin();
            em.persist(placas);
            em.getTransaction().commit();
            em.close();

            return true;
        } catch (Exception e) {
            throw new persistenciaException("Error al agregar las placas: " + e.getMessage());
        }
    }

    @Override
    public boolean asociarPlacas(Placas placas, Automovil auto) throws persistenciaException {
        try {
            Automovil automovil = em.find(Automovil.class, auto.getId());
            automovil.agregarPlaca(placas);
            
            em.getTransaction().begin();
            em.merge(automovil);
            em.getTransaction().commit();
            em.close();
            
            return true;
        } catch (Exception e) {
            throw new persistenciaException("Error al asociar las placas al automóvil: " + e.getMessage());
        }
    }

    @Override
    public boolean actualizarPlaca(Placas placa) throws persistenciaException {
        boolean resultado = false;

        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Placas> cq = cb.createQuery(Placas.class);
            Root<Placas> rootPlacas = cq.from(Placas.class);
            Predicate predicadoID = cb.equal(rootPlacas.get("id"), placa.getId());
            
            cq.select(rootPlacas).where(predicadoID);

            Placas placaActualizada = em.createQuery(cq).getSingleResult();
            
            if (placaActualizada != null) {
                placaActualizada.setEstado(placa.getEstado()); 
                em.merge(placaActualizada); 
                
                em.getTransaction().commit();
                
                resultado = true;
            } else {
                throw new persistenciaException("No se encontró la placa en la base de datos.");
            }
            
        } catch (persistenciaException e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new persistenciaException("Error al actualizar la placa en la base de datos: " + e.getMessage());
        }
        em.close();

        return resultado;
    }

}