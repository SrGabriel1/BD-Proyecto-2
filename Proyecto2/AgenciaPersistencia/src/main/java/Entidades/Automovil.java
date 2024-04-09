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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
@Entity
@Table(name = "Automoviles")
public class Automovil implements Serializable {

    /**
     * Identificador único del automóvil.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Número de serie del automóvil.
     */
    @Column(name = "Numero_Serie", nullable = false)
    private String Numero_Serie;

    /**
     * Modelo del automóvil.
     */
    @Column(name = "Modelo", nullable = false)
    private String Modelo;

    /**
     * Línea del automóvil.
     */
    @Column(name = "línea", nullable = false)
    private String línea;

    /**
     * Marca del automóvil.
     */
    @Column(name = "marca", nullable = false)
    private String marca;

    /**
     * Color del automóvil.
     */
    @Column(name = "color ", nullable = false)
    private String color;

    /**
     * Persona propietaria del automóvil.
     */
    @ManyToOne
    @JoinColumn(name = "persona", nullable = false)
    private Persona persona;

    /**
     * Lista de placas asociadas al automóvil.
     */
    @OneToMany(mappedBy = "auto_id", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Placas> placas;

    /**
     * Constructor por defecto de la clase Automovil.
     */
    public Automovil() {
    }

    /**
     * Constructor de la clase Automovil que inicializa los atributos básicos
     * del automóvil.
     *
     * @param Numero_Serie Número de serie del automóvil.
     * @param Modelo Modelo del automóvil.
     * @param línea Línea del automóvil.
     * @param marca Marca del automóvil.
     * @param color Color del automóvil.
     * @param persona Persona propietaria del automóvil.
     */
    public Automovil(String Numero_Serie, String Modelo, String línea, String marca, String color, Persona persona) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.línea = línea;
        this.marca = marca;
        this.color = color;
        this.persona = persona;
        this.placas = new ArrayList<>();
    }

    /**
     * Método para agregar una placa al automóvil.
     *
     * @param placa Placa que se agregará al automóvil.
     */
    public void agregarPlaca(Placas placa) {
        placa.setAuto_id(this);
        placas.add(placa);
    }

    /**
     * Método para buscar una placa activa asociada al automóvil.
     *
     * @return La placa activa asociada al automóvil, o null si no hay ninguna
     * placa activa.
     */
    public Placas buscarPlacaActiva() {
        for (Placas placa : placas) {
            if ("Activa".equals(placa.getEstado())) {
                return placa;
            }
        }
        return null;
    }

    // Getters y setters
    /**
     * Obtiene el identificador único del automóvil.
     *
     * @return El identificador único del automóvil.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del automóvil.
     *
     * @param id El identificador único del automóvil.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el número de serie del automóvil.
     *
     * @return El número de serie del automóvil.
     */
    public String getNumero_Serie() {
        return Numero_Serie;
    }

    /**
     * Establece el número de serie del automóvil.
     *
     * @param Numero_Serie El número de serie del automóvil.
     */
    public void setNumero_Serie(String Numero_Serie) {
        this.Numero_Serie = Numero_Serie;
    }

    /**
     * Obtiene el modelo del automóvil.
     *
     * @return El modelo del automóvil.
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * Establece el modelo del automóvil.
     *
     * @param Modelo El modelo del automóvil.
     */
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * Obtiene la línea del automóvil.
     *
     * @return La línea del automóvil.
     */
    public String getLínea() {
        return línea;
    }

    /**
     * Establece la línea del automóvil.
     *
     * @param línea La línea del automóvil.
     */
    public void setLínea(String línea) {
        this.línea = línea;
    }

    /**
     * Obtiene la marca del automóvil.
     *
     * @return La marca del automóvil.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del automóvil.
     *
     * @param marca La marca del automóvil.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el color del automóvil.
     *
     * @return El color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del automóvil.
     *
     * @param color El color del automóvil.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene la persona propietaria del automóvil.
     *
     * @return La persona propietaria del automóvil.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona propietaria del automóvil.
     *
     * @param persona La persona propietaria del automóvil.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;

    }

    /**
     * Obtiene la lista de placas asociadas al automóvil.
     *
     * @return La lista de placas asociadas al automóvil.
     */
    public List<Placas> getPlacas() {
        return placas;
    }

    /**
     * Establece la lista de placas asociadas al automóvil.
     *
     * @param placas La lista de placas asociadas al automóvil.
     */
    public void setPlacas(List<Placas> placas) {
        this.placas = placas;
    }

}
