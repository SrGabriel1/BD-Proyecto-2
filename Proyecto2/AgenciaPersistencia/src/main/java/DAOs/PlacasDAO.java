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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class PlacasDAO implements IPlacasDAO {
//Entidades de la clase
    private EntityManager em;

    /**
     * Constructor de la clase PlacasDAO. Inicializa el EntityManager para
     * interactuar con la base de datos.
     */
    public PlacasDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        em = emf.createEntityManager();
    }

    /**
     * Genera un número de placas nuevo.
     *
     * @return Número de placas generado.
     * @throws persistenciaException Si hay un problema al generar el número de
     * placas.
     */
    @Override
    public String GenerarNumero() throws persistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Agrega un nuevo registro de placas a la base de datos.
     *
     * @param placas Objeto de tipo Placas que representa las placas a agregar.
     * @return true si las placas se agregaron correctamente, de lo contrario
     * false.
     * @throws persistenciaException Si hay algún problema al persistir los
     * datos en la base de datos.
     */
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

    /**
     * Asocia unas placas existentes a un automóvil en la base de datos.
     *
     * @param placas Objeto de tipo Placas que se asociará al automóvil.
     * @param auto Objeto de tipo Automovil al que se asociarán las placas.
     * @return true si las placas se asociaron correctamente al automóvil, de lo
     * contrario false.
     * @throws persistenciaException Si hay algún problema al persistir los
     * datos en la base de datos.
     */
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

    /**
     * Actualiza el estado de unas placas en la base de datos.
     *
     * @param placa Objeto de tipo Placas que representa las placas a
     * actualizar.
     * @return true si las placas se actualizaron correctamente, de lo contrario
     * false.
     * @throws persistenciaException Si hay algún problema al actualizar las
     * placas en la base de datos.
     */
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
            throw new persistenciaException("Error al actualizar la placa en la base de datos: " + e.getMessage());
        }
        em.close();

        return resultado;
    }

}
