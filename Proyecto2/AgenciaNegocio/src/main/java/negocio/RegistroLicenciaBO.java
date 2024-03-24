/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.LicenciasDAO;
import DAOs.PersonasDAO;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;
import Validadores.Validador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author USER
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    @Override
    public void RegistrarLicencia(LicenciasDAO licencia) throws persistenciaException {
        Validador v = new Validador();
        if (v.ValidarLicencia(licencia) == true) {
            throw new persistenciaException("Hay una licencia una licencia con esos datos");
        }

    }

    @Override
    public PersonasDAO VerificarPersona(String rfc) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PersonasDAO> cq = cb.createQuery(PersonasDAO.class);
        Root<PersonasDAO> rootPersona = cq.from(PersonasDAO.class);
        Predicate predicadoColonia = cb.equal(rootPersona.get("RFC"), rfc);

        cq.select(rootPersona).where(predicadoColonia);

        List<PersonasDAO> Personas = em.createQuery(cq).getResultList();
        PersonasDAO persona = null;
        for (PersonasDAO Persona : Personas) {
            persona = Persona;
        }
        return persona;
    }

}
