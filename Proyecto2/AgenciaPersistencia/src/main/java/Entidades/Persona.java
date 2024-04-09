/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador único de la persona.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El nombre de la persona.
     */
    @Column(name = "nombre", nullable = false)
    private String nombre;

    /**
     * El apellido paterno de la persona.
     */
    @Column(name = "apellido_paterno", nullable = false)
    private String apellido_paterno;

    /**
     * El apellido materno de la persona.
     */
    @Column(name = "apellido_materno", nullable = false)
    private String apellido_materno;

    /**
     * La Clave Única de Registro de Población (CURP) de la persona.
     */
    @Column(name = "CURP", nullable = false)
    private String CURP;

    /**
     * El Registro Federal de Contribuyentes (RFC) de la persona.
     */
    @Column(name = "RFC", nullable = false)
    private String RFC;

    /**
     * El número de teléfono de la persona.
     */
    @Column(name = "telefono", nullable = false)
    private String telefono;

    /**
     * La condición de la persona (por ejemplo: Normal, Discapacitado, etc.).
     */
    @Column(name = "condicion", nullable = false)
    private String condicion;

    /**
     * La fecha de nacimiento de la persona.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nacimiento;

    /**
     * La lista de trámites realizados por la persona.
     */
    @OneToMany(mappedBy = "persona")
    private List<Tramite> tramites = new ArrayList<>();

    /**
     * La lista de licencias asociadas a la persona.
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Licencia> licencias = new ArrayList<>();

    /**
     * La lista de automóviles asociados a la persona.
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Automovil> placas = new ArrayList<>();

    /**
     * Constructor sin argumentos de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre El nombre de la persona.
     * @param apellido_paterno El apellido paterno de la persona.
     * @param apellido_materno El apellido materno de la persona.
     * @param CURP La Clave Única de Registro de Población (CURP) de la persona.
     * @param RFC El Registro Federal de Contribuyentes (RFC) de la persona.
     * @param telefono El número de teléfono de la persona.
     * @param fecha_nacimiento La fecha de nacimiento de la persona.
     * @param condicion La condición de la persona (por ejemplo: Normal,
     * Discapacitado, etc.).
     */
    public Persona(String nombre, String apellido_paterno, String apellido_materno, String CURP, String RFC, String telefono, Calendar fecha_nacimiento, String condicion) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.CURP = CURP;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;

        this.licencias = new ArrayList<>();
        this.condicion = condicion;
    }

    /**
     * Retorna la licencia activa asociada a la persona.
     *
     * @return La licencia activa de la persona.
     */
    public Licencia getLicenciaActiva() {
        for (Licencia licencia : licencias) {
            if ("Activa".equals(licencia.getEstado())) {
                return licencia;
            }
        }
        return null;
    }

    /**
     * Agrega una licencia a la lista de licencias asociadas a la persona.
     *
     * @param licencia La licencia a agregar.
     */
    public void agregarLicencia(Licencia licencia) {
        licencia.setPersona(this);
        licencias.add(licencia);
    }

    /**
     * Retorna la lista de licencias asociadas a la persona.
     *
     * @return La lista de licencias de la persona.
     */
    public List<Licencia> getLicencias() {
        return licencias;
    }

    /**
     * Establece la lista de licencias asociadas a la persona.
     *
     * @param licencias La lista de licencias a establecer.
     */
    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    /**
     * Retorna el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Establece el RFC de la persona.
     *
     * @param RFC El RFC a establecer.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Retorna el identificador único de la persona.
     *
     * @return El identificador único de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la persona.
     *
     * @param id El identificador único a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param apellido_paterno El apellido paterno a establecer.
     */

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Retorna el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellido_materno El apellido materno a establecer.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Retorna el CURP de la persona.
     *
     * @return El CURP de la persona.
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * Establece el CURP de la persona.
     *
     * @param CURP El CURP a establecer.
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * Retorna el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     *
     * @param telefono El número de teléfono a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fecha_nacimiento La fecha de nacimiento a establecer.
     */
    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Retorna la condición de la persona.
     *
     * @return La condición de la persona.
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Establece la condición de la persona.
     *
     * @param condicion La condición a establecer.
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    /**
     * Retorna la lista de trámites realizados por la persona.
     *
     * @return La lista de trámites de la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

}
