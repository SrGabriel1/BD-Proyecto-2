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
    private String tipoLicencia;
    private String vigencia;
    private String numeroLicencia;
    private Float precio;
    private String estado;
    private Persona persona;

    public LicenciaDTO() {
        this.licenciasDAO = new LicenciasDAO(); // Conexión con el DAO real
    }

    @Override
    public boolean agregarLicencia(Licencia licencia) throws persistenciaException {
        return licenciasDAO.agregarLicencia(licencia);
    }

    @Override
    public boolean asociarLicenciaAPersona(Licencia licencia, Persona persona) throws persistenciaException {
        return licenciasDAO.asociarLicenciaAPersona(licencia, persona);
    }

    @Override
    public Licencia MostrarLicenciaGenerada() throws persistenciaException {
        return licenciasDAO.MostrarLicenciaGenerada();
    }

    public ILicenciasDAO getLicenciasDAO() {
        return licenciasDAO;
    }

    public void setLicenciasDAO(ILicenciasDAO licenciasDAO) {
        this.licenciasDAO = licenciasDAO;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
