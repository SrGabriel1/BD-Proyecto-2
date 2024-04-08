/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yohan
 */
@Entity
@Table(name = "Tramites")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Column(name = "tipo_tramite", nullable = false)
    private String tipoTramite;

    @Column(name = "fecha_realizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRealizacion;
    @Column(name = "costo", nullable = false)
    private Float costo;

    public Tramite() {
        this.fechaRealizacion = Calendar.getInstance();
    }

    public Tramite(Persona persona, String tipoTramite,Float costo) {
        this.persona = persona;
        this.tipoTramite = tipoTramite;
        this.costo= costo;
        this.fechaRealizacion = Calendar.getInstance();
    }

    public Tramite(Persona persona, String tipoTramite, Calendar fechaRealizacion) {
        this.persona = persona;
        this.tipoTramite = tipoTramite;
        this.fechaRealizacion = fechaRealizacion;
    }
    
    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Calendar getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Calendar fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", persona=" + persona + ", tipoTramite=" + tipoTramite + ", fechaRealizacion=" + fechaRealizacion + '}';
    }
}
