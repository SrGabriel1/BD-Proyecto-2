/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
@Entity
@PrimaryKeyJoinColumn(name = "tramite_id")
public class Placas extends Tramite implements Serializable {

    //Columnas dentro de la base de datos
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

    /**
     * Genera una placa aleatoria.
     *
     * @return La placa generada.
     */
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

    /**
     * Constructor de la clase Placas.
     *
     * @param Numero El número de las placas.
     * @param fecha_emision La fecha de emisión de las placas.
     * @param fecha_recepcion La fecha de recepción de las placas.
     * @param costo El costo de las placas.
     * @param auto_id El automóvil asociado a las placas.
     * @param tipo El tipo de las placas.
     * @param Estado El estado de las placas.
     */
    public Placas(String Numero, Calendar fecha_emision, Calendar fecha_recepcion, Float costo, Automovil auto_id, String tipo, String Estado) {
        super(auto_id.getPersona(), "Placas", costo);
        this.Numero = Numero;
        this.fecha_emision = fecha_emision;
        this.fecha_recepcion = fecha_recepcion;
        this.costo = costo;
        this.auto_id = auto_id;
        this.tipo = tipo;
        this.Estado = Estado;
    }

    /**
     * Constructor sin argumentos de la clase Placas.
     */
    public Placas() {
        super();
    }

    /**
     * Retorna el estado de las placas.
     *
     * @return El estado de las placas.
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * Establece el estado de las placas.
     *
     * @param Estado El estado de las placas a establecer.
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * Retorna el identificador único de las placas.
     *
     * @return El identificador único de las placas.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de las placas.
     *
     * @param id El identificador único de las placas a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el número de las placas.
     *
     * @return El número de las placas.
     */
    public String getNumero() {
        return Numero;
    }

    /**
     * Establece el número de las placas.
     *
     * @param Numero El número de las placas a establecer.
     */
    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    /**
     * Retorna la fecha de emisión de las placas.
     *
     * @return La fecha de emisión de las placas.
     */
    public Calendar getFecha_emision() {
        return fecha_emision;
    }

    /**
     * Establece la fecha de emisión de las placas.
     *
     * @param fecha_emision La fecha de emisión de las placas a establecer.
     */
    public void setFecha_emision(Calendar fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    /**
     * Retorna la fecha de recepción de las placas.
     *
     * @return La fecha de recepción de las placas.
     */
    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    /**
     * Establece la fecha de recepción de las placas.
     *
     * @param fecha_recepcion La fecha de recepción de las placas a establecer.
     */
    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    /**
     * Retorna el costo de las placas.
     *
     * @return El costo de las placas.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo de las placas.
     *
     * @param costo El costo de las placas a establecer.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Retorna el automóvil asociado a las placas.
     *
     * @return El automóvil asociado a las placas.
     */
    public Automovil getAuto_id() {
        return auto_id;
    }

    /**
     * Establece el automóvil asociado a las placas.
     *
     * @param auto_id El automóvil asociado a las placas.
     */
    public void setAuto_id(Automovil auto_id) {
        this.auto_id = auto_id;
    }

    /**
     * Retorna el tipo de las placas.
     *
     * @return El tipo de las placas.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de las placas.
     *
     * @param tipo El tipo de las placas a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método toString que devuelve una representación en cadena de las placas.
     *
     * @return Representación en cadena de las placas.
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaRealizacion = formato.format(getFechaRealizacion().getTime());
        return "Trámites de placas realizados por la persona: " + super.getPersona().getNombre() + ", fechaRealizacion=" + fechaRealizacion + "Placas{" + "Numero=" + Numero + ", fecha_emision=" + fecha_emision + ", fecha_recepcion=" + fecha_recepcion + ", costo=" + costo + ", auto_id=" + auto_id + ", tipo=" + tipo + ", Estado=" + Estado + '}';
    }

}
