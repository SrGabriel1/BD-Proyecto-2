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
        
    }
