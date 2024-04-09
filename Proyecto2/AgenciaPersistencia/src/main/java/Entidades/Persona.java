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
 * @author USER
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellido_paterno;

    @Column(name = "apellido_materno", nullable = false)
    private String apellido_materno;

    @Column(name = "CURP", nullable = false)
    private String CURP;
    @Column(name = "RFC", nullable = false)
    private String RFC;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "condicion", nullable = false)
    private String condicion;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nacimiento;
    
    @OneToMany(mappedBy = "persona")
    private List<Tramite> tramites = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade =  {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Licencia> licencias = new ArrayList<>();
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Automovil> placas=new ArrayList<>();

    public Persona() {
    }

    public Persona(String nombre, String apellido_paterno, String apellido_materno, String CURP, String RFC, String telefono, Calendar fecha_nacimiento, String condicion) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.CURP = CURP;
        this.RFC = RFC;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        
        this.licencias = new ArrayList<>();
        this.condicion=condicion;
    }

    public Licencia getLicenciaActiva() {
        for (Licencia licencia : licencias) {
            if ("Activa".equals(licencia.getEstado())) {
                return licencia;
            }
        }
        return null;
    }

    public void agregarLicencia(Licencia licencia) {
        licencia.setPersona(this);
        licencias.add(licencia);
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }
    

    

}
