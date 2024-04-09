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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class LicenciaDTO {

    //Atributos de la clase
    private ILicenciasDAO licenciasDAO;
    private String tipoLicencia;
    private String vigencia;
    private String numeroLicencia;
    private Float precio;
    private String estado;
    private Persona persona;

    /**
     * Constructor de LicenciaDTO que inicializa el objeto LicenciasDAO.
     */
    public LicenciaDTO() {
        this.licenciasDAO = new LicenciasDAO();
    }

    /**
     * Establece el objeto LicenciasDAO.
     *
     * @param licenciasDAO El objeto LicenciasDAO a establecer.
     */
    public void setLicenciasDAO(ILicenciasDAO licenciasDAO) {
        this.licenciasDAO = licenciasDAO;
    }

    /**
     * Retorna el tipo de licencia.
     *
     * @return El tipo de licencia.
     */
    public String getTipoLicencia() {
        return tipoLicencia;
    }

    /**
     * Establece el tipo de licencia.
     *
     * @param tipoLicencia El tipo de licencia a establecer.
     */
    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * Retorna la vigencia de la licencia.
     *
     * @return La vigencia de la licencia.
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia.
     *
     * @param vigencia La vigencia de la licencia a establecer.
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Retorna el número de licencia.
     *
     * @return El número de licencia.
     */
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    /**
     * Establece el número de licencia.
     *
     * @param numeroLicencia El número de licencia a establecer.
     */
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    /**
     * Retorna el precio de la licencia.
     *
     * @return El precio de la licencia.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la licencia.
     *
     * @param precio El precio de la licencia a establecer.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Retorna el estado de la licencia.
     *
     * @return El estado de la licencia.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la licencia.
     *
     * @param estado El estado de la licencia a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna la persona asociada a la licencia.
     *
     * @return La persona asociada a la licencia.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada a la licencia.
     *
     * @param persona La persona asociada a la licencia a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
