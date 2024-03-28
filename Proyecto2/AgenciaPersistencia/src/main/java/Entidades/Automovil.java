/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yohan
 */
@Entity
public class Automovil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name = "Numero_Serie", nullable = false)
    private String Numero_Serie;
    
    @Column(name = "Modelo", nullable = false)
    private String Modelo;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;
            
    @Column(name = "Estado", nullable = false)
    private String Estado;

    @Column(name = "placas")
    private Float placas;

    public Automovil() {
    }

    public Automovil(String Numero_Serie, String Modelo, String tipo, String Estado) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.tipo = tipo;
        this.Estado = Estado;
    }

    public Automovil(String Numero_Serie, String Modelo, String tipo, String Estado, Float placas) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.tipo = tipo;
        this.Estado = Estado;
        this.placas = placas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_Serie() {
        return Numero_Serie;
    }

    public void setNumero_Serie(String Numero_Serie) {
        this.Numero_Serie = Numero_Serie;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPlacas() {
        return placas;
    }

    public void setPlacas(Float placas) {
        this.placas = placas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", Numero_Serie=" + Numero_Serie + ", Modelo=" + Modelo + ", tipo=" + tipo + ", Estado=" + Estado + ", placas=" + placas + '}';
    }

   
}
