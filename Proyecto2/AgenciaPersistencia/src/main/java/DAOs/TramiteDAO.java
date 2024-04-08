/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Tramite;
import Excepciones.persistenciaException;
import Interfaces.ITramiteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * @author yohan
 */
public class TramiteDAO implements ITramiteDAO {

    @Override
    public List<Tramite> Consulta(String nombre) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();

            TypedQuery<Tramite> query = em.createQuery("SELECT t FROM Tramite t WHERE t.persona.nombre LIKE :nombre", Tramite.class);
            query.setParameter("nombre", nombre);

            List<Tramite> tramites = query.getResultList();

            em.close();
            emf.close();

            return tramites;

        } catch (Exception e) {
            throw new persistenciaException("No se encontro ningun tramite de una persona con los datos brindados");
        }
    }

    public static void main(String[] args) throws Exception {
        TramiteDAO t = new TramiteDAO();
        List<Tramite> tramites = t.Consulta("Miguel");

        if (!tramites.isEmpty()) {
            System.out.println("Trámites realizados por la persona:");
            for (Tramite tramite : tramites) {
                System.out.println(tramite); // Suponiendo que has implementado el método toString en la clase Tramite
            }
        } else {
            System.out.println("No se encontraron trámites para la persona con el nombre proporcionado.");
        }
    }
}
