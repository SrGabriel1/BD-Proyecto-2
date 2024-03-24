/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


import DTOs.LicenciaDTO;
import DTOs.PersonaDTO;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Inegocio.IRegistroLicenciaBO;

import Validadores.Validador;


/**
 *
 * @author USER
 */
public class RegistroLicenciaBO implements IRegistroLicenciaBO {

    private PersonaDTO personaDTO;
    private LicenciaDTO licenciaDTO;

    public RegistroLicenciaBO(PersonaDTO personaDTO, LicenciaDTO licenciaDTO) {
        this.personaDTO = personaDTO;
        this.licenciaDTO = licenciaDTO;
    }

    @Override
    public void RegistrarLicencia(Licencia licencia) throws persistenciaException {
        Validador validador = new Validador();

        if (validador.ValidarLicencia(licencia)) {
            throw new persistenciaException("Hay una licencia con esos datos");
        }
        if (licenciaDTO.agregarLicencia(licencia)) {
            Persona persona = licencia.getPersona();
            if (persona != null) {
                persona.agregarLicencia(licencia);
            } else {
                throw new persistenciaException("Error: la licencia no está asociada a una persona.");
            }

            System.out.println("Licencia agregada correctamente a la persona.");
        } else {
            throw new persistenciaException("Error al agregar la licencia.");
        }
    }

    @Override
    public Persona VerificarPersona(String rfc) throws persistenciaException {
        return personaDTO.VerificarPersona(rfc);
    }
}
