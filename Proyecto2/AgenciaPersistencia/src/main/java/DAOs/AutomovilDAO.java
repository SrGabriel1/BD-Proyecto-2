/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IAutomovilDAO;
import java.util.ArrayList;
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
public class AutomovilDAO implements IAutomovilDAO {
    
    /**
 * Registra un automóvil junto con una placa asociada en la base de datos.
 * 
 * @param placa Objeto de tipo Placas que representa la placa a registrar.
 * @param auto Objeto de tipo Automovil que representa el automóvil al que se asociará la placa.
 * @throws persistenciaException Si hay algún problema al persistir los datos en la base de datos.
 */
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

    /**
 * Busca y devuelve la placa activa asociada a un automóvil.
 * 
 * @param auto Objeto de tipo Automovil del cual se buscará la placa activa.
 * @return Objeto de tipo Placas que representa la placa activa.
 * @throws persistenciaException Si hay algún problema durante la búsqueda.
 */
    @Override
    public Placas buscarPlacaActiva(Automovil auto) throws persistenciaException {
        return auto.buscarPlacaActiva();
    }

    /**
 * Actualiza la placa de un automóvil y desactiva cualquier placa activa asociada previamente.
 * 
 * @param placa Objeto de tipo Placas que representa la nueva placa a asociar.
 * @param auto Objeto de tipo Automovil al que se actualizará la placa.
 * @throws persistenciaException Si hay algún problema durante la actualización.
 */
    @Override
    public void actualizarPlaca(Placas placa, Automovil auto) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for(int i =0; i<auto.getPlacas().size();i++){
            if(auto.getPlacas().get(i).getEstado().equals("Activa")){
                auto.getPlacas().get(i).setEstado("Desactivada");
            }
        }
        auto.agregarPlaca(placa);

        em.merge(auto);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    /**
 * Busca un automóvil por su número de placa.
 * 
 * @param numPlaca Número de placa del automóvil a buscar.
 * @return Objeto de tipo Automovil encontrado.
 * @throws persistenciaException Si no existen placas coincidentes.
 */
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
        } catch (NoResultException e) {
            throw new persistenciaException("No existen esas placas");
        }

    }
}
