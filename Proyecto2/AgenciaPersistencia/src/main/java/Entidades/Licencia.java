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
import javax.persistence.Table;

/**
 *
 * @author yohan
 */
@Entity
@Table(name = "Licencias")
public class Licencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="vigencia",nullable=false)
    private String vigencia;
    
    @Column(name="tipo",nullable=false)
    private String tipo;
    
    @Column(name="precio",nullable=false)
    private float precio;
    
    @Column(name="estado",nullable=false)
    private String estado;
    

    public Licencia() {
    }

    
    
    

}
