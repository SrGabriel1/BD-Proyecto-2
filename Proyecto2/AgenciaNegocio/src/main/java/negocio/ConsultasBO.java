/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.AutomovilDAO;
import DAOs.LicenciasDAO;
import DAOs.PersonasDAO;
import DAOs.TramiteDAO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import Excepciones.persistenciaException;
import Inegocio.IConsultasBO;
import Interfaces.IAutomovilDAO;
import Interfaces.ILicenciasDAO;
import Interfaces.IPersonasDAO;
import Interfaces.ITramiteDAO;
import java.util.List;

/**
 *
 * @author USER
 */
public class ConsultasBO implements IConsultasBO {

    @Override
    public Persona regresarPersona(Licencia licencia) throws persistenciaException {
        IPersonasDAO ipersona = new PersonasDAO();
        try {
            return ipersona.regresarPersona(licencia);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }

    @Override
    public Licencia regresarLicencia(String numLicencia) throws persistenciaException {
        if (numLicencia.equals("")) {
            throw new persistenciaException("Escribe el número de licencia");
        }
        ILicenciasDAO ilicencia = new LicenciasDAO();

        try {
            return ilicencia.regresarLicencia(numLicencia);
        } catch (persistenciaException ex) {
            throw new persistenciaException(ex.getMessage());

        }
    }

    @Override
    public Automovil regresarAutomovil(String numPlaca) throws persistenciaException {
        if (numPlaca.equals("")) {
            throw new persistenciaException("Escribe el número de placa");
        }
        IAutomovilDAO iAutomovilDAO = new AutomovilDAO();
        return iAutomovilDAO.buscarAutomovilPorPlaca(numPlaca);

    }

    @Override
    public void comprobarMismoDueno(Automovil auto, Licencia licencia) throws persistenciaException {
        if (auto.getPersona().getId() != licencia.getPersona().getId()) {
            throw new persistenciaException("La licencia y el automovil no pertenecen a la misma persona");
        }

    }

    @Override
    public List<Tramite> ConsultaTramite(String RFC) throws persistenciaException {
        ITramiteDAO tramite = new TramiteDAO();
        try {
            return tramite.Consulta(RFC);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Persona> regresarPersonasSimilares(String nombre, String curp, Integer anioNacimiento) throws persistenciaException {
        IPersonasDAO ipersona = new PersonasDAO();
        try {
            return ipersona.regresarPersonasSimilares(nombre, curp, anioNacimiento);
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }
}
