/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import DAOs.LicenciasDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;
import Interfaces.ILicenciasDAO;

/**
 *
 * @author yohan
 */
public class LicenciaDTO implements ILicenciasDAO {

    private ILicenciasDAO licenciasDAO;

    public LicenciaDTO() {
        this.licenciasDAO = new LicenciasDAO(); // Conexión con el DAO real
    }

    @Override
    public boolean agregarLicencia(Licencia licencia) throws persistenciaException {
        return licenciasDAO.agregarLicencia(licencia);
    }

    @Override
    public boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException {
        return licenciasDAO.asociarLicenciaAPersona(licencia,persona);
    }
}
