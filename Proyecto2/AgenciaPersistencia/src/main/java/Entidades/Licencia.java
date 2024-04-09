/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
@Entity
@PrimaryKeyJoinColumn(name = "tramite_id")
public class Licencia extends Tramite implements Serializable {

    /**
     * Clase que representa una Licencia. Contiene los atributos específicos de
     * una licencia, como vigencia, número de licencia, tipo, precio y estado.
     * Además, tiene una relación ManyToOne con la entidad Persona.
     */
    /**
     * Identificador único de la Licencia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * La vigencia de la licencia.
     */
    @Column(name = "vigencia", nullable = false)
    private String vigencia;

    /**
     * La vigencia de la licencia.
     */
    @Column(name = "Numero_Licencia", nullable = false)
    private String numeroLicencia;

    /**
     * El tipo de licencia (por ejemplo: tipo A, tipo B, etc.).
     */
    @Column(name = "tipo", nullable = false)
    private String tipo;

    /**
     * El precio de la licencia.
     */
    @Column(name = "precio", nullable = false)
    private Float precio;

    /**
     * El estado de la licencia (por ejemplo: Vigente, Vencida, etc.).
     */
    @Column(name = "estado", nullable = false)
    private String estado;

    /**
     * La persona asociada a la licencia.
     */
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    /**
     * Constructor por defecto de la clase Licencia.
     */
    public Licencia() {
        super();
    }

    /**
     * Constructor de la clase Licencia.
     *
     * @param vigencia La vigencia de la licencia.
     * @param tipo El tipo de licencia.
     * @param precio El precio de la licencia.
     * @param estado El estado de la licencia.
     * @param persona La persona asociada a la licencia.
     */
    public Licencia(String vigencia, String tipo, Float precio, String estado, Persona persona) {
        super(persona, "Licencia", precio);
        this.vigencia = vigencia;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
        this.persona = persona;
        this.numeroLicencia = generarNumeroAleatorio();
    }

    /**
     * Método privado para generar un número de licencia aleatorio.
     *
     * @return El número de licencia generado.
     */
    private String generarNumeroAleatorio() {
        // Crear un objeto Random
        Random random = new Random();

        // Generar un número aleatorio de 8 cifras
        int numero = random.nextInt(90000000) + 10000000;

        // Convertir el número a String y devolverlo
        return String.valueOf(numero);
    }

    /**
     * Método getter para obtener el número de licencia.
     *
     * @return El número de licencia.
     */
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    /**
     * Método setter para establecer el número de licencia.
     *
     * @param numeroLicencia El número de licencia a establecer.
     */
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    /**
     * Método getter para obtener la persona asociada a la licencia.
     *
     * @return La persona asociada a la licencia.
     */
    @Override
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método setter para establecer la persona asociada a la licencia.
     *
     * @param persona La persona a establecer.
     */
    @Override
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Método getter para obtener el ID de la licencia.
     *
     * @return El ID de la licencia.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el ID de la licencia.
     *
     * @param id El ID de la licencia a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener la vigencia de la licencia.
     *
     * @return La vigencia de la licencia.
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * Método setter para establecer la vigencia de la licencia.
     *
     * @param vigencia La vigencia de la licencia a establecer.
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Método getter para obtener el tipo de la licencia.
     *
     * @return El tipo de la licencia.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método setter para establecer el tipo de la licencia.
     *
     * @param tipo El tipo de la licencia a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método getter para obtener el precio de la licencia.
     *
     * @return El precio de la licencia.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Método setter para establecer el precio de la licencia.
     *
     * @param precio El precio de la licencia a establecer.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    /**
     * Método getter para obtener el estado de la licencia.
     *
     * @return El estado de la licencia.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado de la licencia.
     *
     * @param estado El estado de la licencia a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString que devuelve una representación en cadena de la licencia.
     *
     * @return Representación en cadena de la licencia.
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaRealizacion = formato.format(getFechaRealizacion().getTime());
        return "Trámites de licencia realizados por la persona: " + super.getPersona().getNombre() + ", fechaRealizacion=" + fechaRealizacion + "," + "licencia tramitada'{ numero " + numeroLicencia + " ,vigencia=" + vigencia + ", tipo=" + tipo + ", precio=" + precio + ", estado=" + estado + '}';
    }
}
