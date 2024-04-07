/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author yohan
 */
@Entity
@PrimaryKeyJoinColumn(name = "tramite_id")
public class Licencia extends Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vigencia", nullable = false)
    private String vigencia;

    @Column(name = "Numero_Licencia", nullable = false)
    private String numeroLicencia;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    public Licencia() {
        super();
    }

    public Licencia(String vigencia, String tipo, Float precio, String estado, Persona persona) {
        super(persona, "Licencia",precio);
        this.vigencia = vigencia;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
        this.persona = persona;
        this.numeroLicencia = generarNumeroAleatorio();
    }

    private String generarNumeroAleatorio() {
        // Crear un objeto Random
        Random random = new Random();

        // Generar un número aleatorio de 8 cifras
        int numero = random.nextInt(90000000) + 10000000;

        // Convertir el número a String y devolverlo
        return String.valueOf(numero);
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", vigencia=" + vigencia + ", tipo=" + tipo + ", precio=" + precio + ", estado=" + estado + '}';
    }
}
