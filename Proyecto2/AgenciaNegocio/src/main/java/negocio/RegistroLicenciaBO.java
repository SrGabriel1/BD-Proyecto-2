/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.LicenciasDAO;
import DAOs.PersonasDAO;
import DAOs.PlacasDAO;
import DTOs.LicenciaDTO;
import DTOs.PersonaDTO;
import DTOs.PlacaDTO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;
import Interfaces.ILicenciasDAO;
import Interfaces.IPersonasDAO;
import Interfaces.IPlacasDAO;

import Validadores.Validador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    

    @Override
    public String RegistrarLicencia(LicenciaDTO licenciadto) throws persistenciaException {
        Validador validador = new Validador();
        Licencia licencia = new Licencia(licenciadto.getVigencia(), licenciadto.getTipoLicencia(), licenciadto.getPrecio(), licenciadto.getEstado(), licenciadto.getPersona());
        ILicenciasDAO ilicencia = new LicenciasDAO();
        if (validador.ValidarLicencia(licencia)) {
            throw new persistenciaException("Ya cuentas con una licencia!!!!!");
        }
        if (ilicencia.agregarLicencia(licencia)) {
            Persona persona = licencia.getPersona();
            if (persona != null) {
                persona.agregarLicencia(licencia);
            } else {
                throw new persistenciaException("Error: la licencia no está asociada a una persona.");
            }
        } else {
            throw new persistenciaException("Error al agregar la licencia.");
        }
        return licencia.getNumeroLicencia();

    }

    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        IPersonasDAO persona=new PersonasDAO();
        
        return persona.VerificarPersona(rfc);
    }

    

}
