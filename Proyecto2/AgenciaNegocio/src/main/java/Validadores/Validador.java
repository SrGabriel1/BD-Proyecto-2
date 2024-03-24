/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import DAOs.LicenciasDAO;
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

    public Boolean ValidarLicencia(LicenciasDAO licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LicenciasDAO> cq = cb.createQuery(LicenciasDAO.class);
        Root<LicenciasDAO> rootLicencia = cq.from(LicenciasDAO.class);
        cq.select(rootLicencia);

        List<LicenciasDAO> Licencias = em.createQuery(cq).getResultList();
        boolean validar = false;
        for (LicenciasDAO Licencia : Licencias) {
            if (Licencia == licencia) {
                validar = true;
            }
        }
        return validar;
    }
}
