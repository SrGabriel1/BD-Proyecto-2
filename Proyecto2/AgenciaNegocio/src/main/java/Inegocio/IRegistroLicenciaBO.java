/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inegocio;

import DTOs.LicenciaDTO;
import DTOs.PlacaDTO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 *
 */
public interface IRegistroLicenciaBO {

    /**
     * Registra una nueva licencia en el sistema.
     * @param licencia El objeto LicenciaDTO que contiene los detalles de la
     * licencia a registrar.
     * @return El número de licencia generado para la nueva licencia registrada.
     * @throws persistenciaException Si ocurre un error durante el proceso de
     * registro de la licencia.
     */
    public String RegistrarLicencia(LicenciaDTO licencia) throws persistenciaException;

    /**
     * Verifica la existencia de una persona en el sistema mediante su RFC.
     *
     * @param rfc El RFC de la persona que se desea verificar.
     * @return La información de la persona si existe en el sistema, de lo
     * contrario, null.
     * @throws persistenciaException Si ocurre un error durante el proceso de
     * verificación de la persona.
     */
    public Persona VerificarPersona(String rfc) throws persistenciaException;

}
