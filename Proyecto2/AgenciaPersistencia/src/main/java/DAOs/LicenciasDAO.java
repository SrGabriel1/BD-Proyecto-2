/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Licencia;
import Interfaces.ILicenciasDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class LicenciasDAO implements ILicenciasDAO {

    Licencia licencia;
        
        @Override
    public boolean agregarLicencia(Licencia licencia) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(licencia);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(String vigencia,String tipo,Float precio,String estado) {
        this.licencia = new  Licencia(vigencia, tipo, precio, estado);
    }

}
