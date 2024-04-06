/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import Entidades.Licencia;
import Entidades.Placas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yohan, ximena, jesus
 */
public class Validador {

    public Boolean ValidarLicencia(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Licencia> cq = cb.createQuery(Licencia.class);
        Root<Licencia> rootLicencia = cq.from(Licencia.class);
        cq.select(rootLicencia);

        cq.where(
                cb.equal(rootLicencia.get("tipo"), licencia.getTipo()) // Comparar por tipo de licencia
        );

        List<Licencia> licencias = em.createQuery(cq).getResultList();
        em.close();
        emf.close();
        return !licencias.isEmpty();

    }
    
    public Boolean ValidarPlaca(Placas placa){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Placas> cq = cb.createQuery(Placas.class);
        Root<Placas> rootPlacas = cq.from(Placas.class);
        cq.select(rootPlacas);

        cq.where(
                cb.equal(rootPlacas.get("Numero"), placa.getNumero()) 
        );

        List<Placas> placa1 = em.createQuery(cq).getResultList();
        em.close();
        emf.close();
        return !placa1.isEmpty();
    }

}
