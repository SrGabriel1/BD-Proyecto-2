/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import DAOs.PersonasDAO;
import DTOs.AutomovilDTO;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IPersonasDAO;
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

    public Boolean ValidarLicencia(Licencia licencia) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Licencia> cq = cb.createQuery(Licencia.class);
        Root<Licencia> rootLicencia = cq.from(Licencia.class);
        cq.select(rootLicencia);

        cq.where(cb.equal(rootLicencia.get("persona"), licencia.getPersona()));
        
        List<Licencia> licencias = em.createQuery(cq).getResultList();
        if(licencias.isEmpty()){
            if(!licencia.getTipo().equals(licencia.getPersona().getCondicion())){
                throw new Exception("Usted solo puede seleccionar licencias de tipo "+licencia.getPersona().getCondicion());
            }
        }
        for(Licencia l:licencias){
            if(l.getEstado().equals("Activa")){
                throw new Exception("Ya cuentas con una licencia activa");
            }else if(licencia.getTipo().equals(l.getPersona().getCondicion())){
                throw new Exception("Usted solo puede seleccionar licencias de tipo "+l.getPersona().getCondicion());
            }
        }
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
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        IPersonasDAO persona=new PersonasDAO();
        return persona.VerificarPersona(rfc);
    }
    public void validarAuto(AutomovilDTO auto) throws Exception{
        
        if(auto.getColor().equals("") || auto.getLínea().equals("") || auto.getMarca().equals("") || auto.getModelo().equals("") || auto.getNumero_Serie().equals("")){
            throw new Exception("Rellena todos los datos del automovil");
        }
        
    }
}
