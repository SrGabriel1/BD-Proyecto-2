/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IAutomovilDAO;
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
 * @author yohan
 */
public class AutomovilDAO implements IAutomovilDAO {
    
    @Override
    public void registrarAutoYPlaca(Placas placa,Automovil auto) throws persistenciaException {
        auto.agregarPlaca(placa);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(auto);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public Placas buscarPlacaActiva(Automovil auto) throws persistenciaException {
        return auto.buscarPlacaActiva();
    }

    @Override
    public void actualizarPlaca(Placas placa, Automovil auto) throws persistenciaException {
        auto.agregarPlaca(placa);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        auto.agregarPlaca(placa);

        em.merge(auto);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public Automovil buscarAutomovilPorPlaca(String numPlaca) throws persistenciaException {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteriaQuery = criteriaBuilder.createQuery(Automovil.class);

            Root<Automovil> automovilRoot = criteriaQuery.from(Automovil.class);
            Join<Automovil, Placas> placasJoin = automovilRoot.join("placas");

            Predicate predicate = criteriaBuilder.equal(placasJoin.get("Numero"), numPlaca);

            criteriaQuery.select(automovilRoot).where(predicate);

            TypedQuery<Automovil> typedQuery = em.createQuery(criteriaQuery);
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }

    }

}
