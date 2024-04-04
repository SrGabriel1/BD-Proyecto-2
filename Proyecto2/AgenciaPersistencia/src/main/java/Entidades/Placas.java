/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yohan
 */
@Entity
@Table(name = "Placas")
public class Placas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Numero", nullable = false)
    private String Numero;

    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_emision;

    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_recepcion;

    @Column(name = "Costo", nullable = false)
    private Float costo;

    @ManyToOne
    @JoinColumn(name = "auto_id", nullable = false)
    private Automovil auto_id;

    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    @Column(name = "Estado", nullable = false)
    private String Estado;

    public static String generarPlaca() {
        Random random = new Random();
        StringBuilder placa = new StringBuilder();

        // Generar tres letras aleatorias
        for (int i = 0; i < 3; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            placa.append(letra);
        }

        // Agregar un guión
        placa.append("-");

        // Generar tres dígitos aleatorios
        for (int i = 0; i < 3; i++) {
            int digito = random.nextInt(10);
            placa.append(digito);
        }

        return placa.toString();
    }

    public Placas(String Numero, Calendar fecha_emision, Calendar fecha_recepcion, Float costo, Automovil auto_id, String tipo, String Estado) {
        this.Numero = Numero;
        this.fecha_emision = fecha_emision;
        this.fecha_recepcion = fecha_recepcion;
        this.costo = costo;
        this.auto_id = auto_id;
        this.tipo = tipo;
        this.Estado = Estado;
    }


    public Placas() {
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Placas{" + "id=" + id + ", Numero=" + Numero + ", fecha_emision=" + fecha_emision + ", fecha_recepcion=" + fecha_recepcion + ", costo=" + costo + ", auto_id=" + auto_id + ", tipo=" + tipo + ", Estado=" + Estado + '}';
    }

  

}
