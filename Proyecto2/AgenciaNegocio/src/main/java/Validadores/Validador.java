/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import Entidades.Licencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author yohan
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

}
