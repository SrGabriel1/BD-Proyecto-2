/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lifty, nanis y jefra popipopipopi
 */
@Entity
@Table(name = "Automoviles")
public class Automovil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Numero_Serie", nullable = false)
    private String Numero_Serie;

    @Column(name = "Modelo", nullable = false)
    private String Modelo;

    @Column(name = "línea", nullable = false)
    private String línea;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "color ", nullable = false)
    private String color;
    
    @ManyToOne
    @JoinColumn(name = "persona", nullable = false)
    private Persona persona;

    @OneToMany(mappedBy = "auto_id", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Placas> placas;

    public Automovil() {
    }

    public Automovil(String Numero_Serie, String Modelo, String línea, String marca, String color, Persona persona) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.línea = línea;
        this.marca = marca;
        this.color = color;
        this.persona= persona;
        this.placas = new ArrayList<>();
    }



    public void agregarPlaca(Placas placa) {
        placa.setAuto_id(this);
        placas.add(placa);
    }

    public Placas buscarPlacaActiva() {
        for (Placas placa : placas) {
            if ("Activa".equals(placa.getEstado())) {
                return placa;
            }
        }
        return null;
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

    public String getLínea() {
        return línea;
    }

    public void setLínea(String línea) {
        this.línea = línea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona= persona ;
        
    }

    public List<Placas> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placas> placas) {
        this.placas = placas;
    }

    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", Numero_Serie=" + Numero_Serie + ", Modelo=" + Modelo + ", l\u00ednea=" + línea + ", marca=" + marca + ", color=" + color + ", persona=" + persona + ", placas=" + placas + '}';
    }

}
     

