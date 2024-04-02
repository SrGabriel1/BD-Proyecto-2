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

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "Estado", nullable = false)
    private String Estado;

    @ManyToOne
    @JoinColumn(name = "licencia_id", nullable = false)
    private Licencia licencia_id;

    @OneToMany(mappedBy = "auto_id", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Placas> placas;

    public Automovil() {
    }

    public Automovil(String Numero_Serie, String Modelo, String tipo, String Estado, Licencia licencia_id) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.tipo = tipo;
        this.Estado = Estado;
        this.licencia_id = licencia_id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Placas> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placas> placas) {
        this.placas = placas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Licencia getLicencia_id() {
        return licencia_id;
    }

    public void setLicencia_id(Licencia licencia_id) {
        this.licencia_id = licencia_id;
    }

    @Override
    public String toString() {
        return "Automovil{" + "id=" + id + ", Numero_Serie=" + Numero_Serie + ", Modelo=" + Modelo + ", tipo=" + tipo + ", Estado=" + Estado + ", licencia_id=" + licencia_id + ", placas=" + placas + '}';
    }

}
