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
 * @author Ximena
 */
public class PlacaDTO{

    private IPlacasDAO placas;
    private String numero, tipo,estado;
    private Calendar fecha_emision, fecha_recepcion; 
    private Float costo;
    private Automovil auto_id;

    public PlacaDTO() {
        this.placas = new PlacasDAO();
    }

    public PlacaDTO( String tipo, String estado, Calendar fecha_emision, Calendar fecha_recepcion, Float costo, Automovil auto_id) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
        this.fecha_recepcion = fecha_recepcion;
        this.costo = costo;
        this.auto_id = auto_id;
    }
    public PlacaDTO( String tipo, String estado, Calendar fecha_emision, Calendar fecha_recepcion, Float costo) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha_emision = fecha_emision;
        this.fecha_recepcion = fecha_recepcion;
        this.costo = costo;
    }

    public PlacaDTO(String tipo, String estado, float costo) {
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
    }

    public IPlacasDAO getPlacas() {
        return placas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPlacas(IPlacasDAO placas) {
        this.placas = placas;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Calendar getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Calendar fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Automovil getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(Automovil auto_id) {
        this.auto_id = auto_id;
    }
 
    
    
    
 
    
}
