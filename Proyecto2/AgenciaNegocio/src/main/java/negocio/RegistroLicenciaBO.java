/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.LicenciasDAO;
import DAOs.PlacasDAO;
import DTOs.LicenciaDTO;
import DTOs.PersonaDTO;
import DTOs.PlacasDTO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;
import Interfaces.ILicenciasDAO;
import Interfaces.IPlacasDAO;

import Validadores.Validador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    private PersonaDTO personaDTO;
    private LicenciaDTO licenciaDTO;

    public RegistroLicenciaBO() {
        this.personaDTO = new PersonaDTO();
        this.licenciaDTO = new LicenciaDTO();
    }

    public RegistroLicenciaBO(PersonaDTO personaDTO, LicenciaDTO licenciaDTO) {
        this.personaDTO = personaDTO;
        this.licenciaDTO = licenciaDTO;
    }

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
                licenciaDTO.setNumeroLicencia(licencia.getNumero_Licencia());
            } else {
                throw new persistenciaException("Error: la licencia no está asociada a una persona.");
            }

            System.out.println("Licencia agregada correctamente a la persona.");
        } else {
            throw new persistenciaException("Error al agregar la licencia.");
        }
        return licenciaDTO.getNumeroLicencia();

    }

    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        return personaDTO.VerificarPersona(rfc);
    }

    @Override
    public Licencia regresarLicencias(String numLicencia) {
        ILicenciasDAO ilicencia = new LicenciasDAO();
        try {
            return ilicencia.regresarLicencia(numLicencia);
        } catch (persistenciaException ex) {
            Logger.getLogger(RegistroLicenciaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
