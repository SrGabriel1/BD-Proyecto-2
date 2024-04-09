/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import DAOs.PlacasDAO;
import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IPlacasDAO;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class PlacaDTO {

    //Atrubutos de la clase
    private IPlacasDAO placas;
    private String numero, tipo, estado;
    private Calendar fecha_emision, fecha_recepcion;
    private Float costo;
    private Automovil auto_id;

    /**
     * Constructor de PlacaDTO que inicializa el objeto PlacasDAO.
     */
    public PlacaDTO() {
        this.placas = new PlacasDAO();
    }

    /**
     * Constructor de PlacaDTO con parámetros.
     *
     * @param tipo El tipo de placa.
     * @param estado El estado de la placa.
     * @param fecha_emision La fecha de emisión de la placa.
     * @param fecha_recepcion La fecha de recepción de la placa.
     * @param costo El costo de la placa.
     * @param auto_id El automóvil asociado a la placa.
     */
    public PlacaDTO(String tipo, String estado, Calendar fecha_emision, Calendar fecha_recepcion, Float costo, Automovil auto_id) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
        this.fecha_recepcion = fecha_recepcion;
        this.costo = costo;
        this.auto_id = auto_id;
    }

    /**
     * Constructor de PlacaDTO con parámetros.
     *
     * @param tipo El tipo de placa.
     * @param estado El estado de la placa.
     * @param fecha_emision La fecha de emisión de la placa.
     * @param fecha_recepcion La fecha de recepción de la placa.
     * @param costo El costo de la placa.
     */
    public PlacaDTO(String tipo, String estado, Calendar fecha_emision, Calendar fecha_recepcion, Float costo) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
        this.fecha_recepcion = fecha_recepcion;
        this.costo = costo;
    }

    /**
     * Constructor de PlacaDTO con parámetros.
     *
     * @param tipo El tipo de placa.
     * @param estado El estado de la placa.
     * @param costo El costo de la placa.
     */
    public PlacaDTO(String tipo, String estado, float costo) {
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
    }

    /**
     * Obtiene el objeto para acceder a la capa de acceso a datos de placas.
     *
     * @return El objeto para acceder a la capa de acceso a datos de placas.
     */
    public IPlacasDAO getPlacas() {
        return placas;
    }

    /**
     * Obtiene el estado de la placa.
     *
     * @return El estado de la placa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     *
     * @param estado El estado de la placa.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece el objeto que proporciona acceso a la capa de persistencia para
     * las placas.
     *
     * @param placas El objeto que implementa la interfaz IPlacasDAO.
     */
    public void setPlacas(IPlacasDAO placas) {
        this.placas = placas;
    }

    /**
     * Obtiene el número de la placa.
     *
     * @return El número de la placa.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la placa.
     *
     * @param numero El número de la placa.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el tipo de la placa.
     *
     * @return El tipo de la placa.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la placa.
     *
     * @param tipo El tipo de la placa.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fecha de emisión de la placa.
     *
     * @return La fecha de emisión de la placa.
     */
    public Calendar getFecha_emision() {
        return fecha_emision;
    }

    /**
     * Establece la fecha de emisión de la placa.
     *
     * @param fecha_emision La fecha de emisión de la placa.
     */
    public void setFecha_emision(Calendar fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     *
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     *
     * @param fecha_recepcion La fecha de recepción de la placa.
     */
    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    /**
     * Obtiene el costo de la placa.
     *
     * @return El costo de la placa.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la placa.
     *
     * @param costo El costo de la placa.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene el automóvil asociado a la placa.
     *
     * @return El automóvil asociado a la placa.
     */
    public Automovil getAuto_id() {
        return auto_id;
    }

    /**
     * Establece el automóvil asociado a la placa.
     *
     * @param auto_id El automóvil asociado a la placa.
     */
    public void setAuto_id(Automovil auto_id) {
        this.auto_id = auto_id;
    }

}
