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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
@Entity
@Table(name = "Tramites")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_tramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    //Columnas dentro de la base de datos
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

    /**
     * Constructor sin argumentos de la clase Tramite. Inicializa la fecha de
     * realización del trámite con la fecha y hora actuales.
     */
    public Tramite() {
        this.fechaRealizacion = Calendar.getInstance();
    }

    /**
     * Constructor de la clase Tramite.
     *
     * @param persona La persona asociada al trámite.
     * @param tipoTramite El tipo de trámite.
     * @param costo El costo del trámite.
     */
    public Tramite(Persona persona, String tipoTramite, Float costo) {
        this.persona = persona;
        this.tipoTramite = tipoTramite;
        this.costo = costo;
        this.fechaRealizacion = Calendar.getInstance();
    }

    /**
     * Constructor de la clase Tramite.
     *
     * @param persona La persona asociada al trámite.
     * @param tipoTramite El tipo de trámite.
     * @param fechaRealizacion La fecha de realización del trámite.
     */
    public Tramite(Persona persona, String tipoTramite, Calendar fechaRealizacion) {
        this.persona = persona;
        this.tipoTramite = tipoTramite;
        this.fechaRealizacion = fechaRealizacion;
    }

    /**
     * Retorna el costo del trámite.
     *
     * @return El costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo del trámite.
     *
     * @param costo El costo del trámite a establecer.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Retorna el identificador único del trámite.
     *
     * @return El identificador único del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del trámite.
     *
     * @param id El identificador único del trámite a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la persona asociada al trámite.
     *
     * @return La persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     *
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Retorna el tipo de trámite.
     *
     * @return El tipo de trámite.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite.
     *
     * @param tipoTramite El tipo de trámite a establecer.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Retorna la fecha de realización del trámite.
     *
     * @return La fecha de realización del trámite.
     */
    public Calendar getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * Establece la fecha de realización del trámite.
     *
     * @param fechaRealizacion La fecha de realización del trámite a establecer.
     */
    public void setFechaRealizacion(Calendar fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    /**
     * Método toString que devuelve una representación en cadena del trámite.
     *
     * @return Representación en cadena del trámite.
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", persona=" + persona + ", tipoTramite=" + tipoTramite + ", fechaRealizacion=" + fechaRealizacion + '}';
    }
}
