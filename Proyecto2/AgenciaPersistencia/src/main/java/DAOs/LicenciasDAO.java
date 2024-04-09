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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class LicenciasDAO implements ILicenciasDAO {

    /**
     * Agrega una nueva licencia a la base de datos.
     *
     * @param licencia Objeto de tipo Licencia que representa la licencia a
     * agregar.
     * @return true si la licencia se agregó correctamente, de lo contrario
     * false.
     * @throws persistenciaException Si hay algún problema al persistir los
     * datos en la base de datos.
     */
    @Override
    public boolean agregarLicencia(Licencia licencia) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;

    }

    /**
     * Asocia una licencia existente a una persona en la base de datos.
     *
     * @param licencia Objeto de tipo Licencia que se asociará a la persona.
     * @param persona Objeto de tipo Persona a la que se asociará la licencia.
     * @return true si la licencia se asoció correctamente a la persona, de lo
     * contrario false.
     * @throws persistenciaException Si hay algún problema al persistir los
     * datos en la base de datos.
     */
    @Override
    public boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        persona.agregarLicencia(licencia);
        em.merge(persona);

        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }

    /**
     * Retorna una licencia de la base de datos dado su número.
     *
     * @param numLicencia Número de la licencia a buscar.
     * @return Objeto de tipo Licencia encontrado.
     * @throws persistenciaException Si la licencia no existe o está vencida.
     */
    @Override
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String jpql = "SELECT l FROM Licencia l WHERE l.numeroLicencia = :numero";
        TypedQuery<Licencia> query = em.createQuery(jpql, Licencia.class);
        query.setParameter("numero", numLicencia);
        try {
            Licencia licenciaTemp = (Licencia) query.getSingleResult();
            if (licenciaTemp.getEstado().equals("Vencida")) {
                throw new persistenciaException("Su licencia está vencida");
            }
            return licenciaTemp;
        } catch (NoResultException e) {
            throw new persistenciaException("Esa licencia no existe");

        }
    }

}
