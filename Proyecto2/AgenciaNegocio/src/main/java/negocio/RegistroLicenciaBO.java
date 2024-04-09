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
import javax.persistence.PersistenceException;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    /**
     * Registra una nueva licencia basada en la información proporcionada en el
     * objeto LicenciaDTO.
     *
     * @param licenciadto El objeto LicenciaDTO que contiene la información de
     * la licencia a registrar.
     * @return El número de licencia generado.
     * @throws persistenciaException Si ocurre un error durante el registro de
     * la licencia.
     */
    @Override
    public String RegistrarLicencia(LicenciaDTO licenciadto) throws persistenciaException {

        Validador validador = new Validador();
        Licencia licencia = new Licencia(licenciadto.getVigencia(), licenciadto.getTipoLicencia(), licenciadto.getPrecio(), licenciadto.getEstado(), licenciadto.getPersona());
        ILicenciasDAO ilicencia = new LicenciasDAO();
        try {
            validador.ValidarLicencia(licencia);
            ilicencia.agregarLicencia(licencia);
            return licencia.getNumeroLicencia();
        } catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    /**
     * Verifica la existencia de una persona en la base de datos a partir de su
     * RFC.
     *
     * @param rfc El RFC de la persona a verificar.
     * @return La persona encontrada en la base de datos, si existe.
     * @throws persistenciaException Si ocurre un error durante la verificación
     * de la persona.
     */
    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        IPersonasDAO persona = new PersonasDAO();

        return persona.VerificarPersona(rfc);
    }

}
