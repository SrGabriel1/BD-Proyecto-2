/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import DAOs.LicenciasDAO;
import DAOs.PersonasDAO;
import DTOs.LicenciaDTO;
import DTOs.PersonaDTO;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;
import negocio.RegistroLicenciaBO;

/**
 *
 * @author yohan
 */
public class Prueba {

    public static void main(String[] args) throws persistenciaException {
        PersonaDTO personaDTO = new PersonaDTO();
        LicenciaDTO licenciaDTO = new LicenciaDTO();
        
        IRegistroLicenciaBO registroLicenciaBO = new RegistroLicenciaBO(personaDTO, licenciaDTO);

        String rfc = "FOLC920713345";
        Persona persona = registroLicenciaBO.VerificarPersona(rfc);
        System.out.println(persona.toString());

        Licencia licencia = new Licencia("2 año", "normal", 600F, "activa",persona);
        registroLicenciaBO.RegistrarLicencia(licencia);
    }
}
