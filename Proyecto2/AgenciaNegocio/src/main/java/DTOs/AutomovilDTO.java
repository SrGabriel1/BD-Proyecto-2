/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import DAOs.AutomovilDAO;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IAutomovilDAO;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class AutomovilDTO {

    //Atributos de la clase
    private String Numero_Serie;

    private String Modelo;

    private String línea;

    private String marca;

    private String color;

    private Persona persona;

    /**
     * Constructor vacío de AutomovilDTO.
     */
    public AutomovilDTO() {
    }

    /**
     * Constructor de AutomovilDTO que inicializa todos los atributos.
     *
     * @param Numero_Serie El número de serie del automóvil.
     * @param Modelo El modelo del automóvil.
     * @param línea La línea del automóvil.
     * @param marca La marca del automóvil.
     * @param color El color del automóvil.
     * @param persona La persona asociada al automóvil.
     */
    public AutomovilDTO(String Numero_Serie, String Modelo, String línea, String marca, String color, Persona persona) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.línea = línea;
        this.marca = marca;
        this.color = color;
        this.persona = persona;
    }

    /**
     * Retorna el número de serie del automóvil.
     *
     * @return El número de serie del automóvil.
     */
    public String getNumero_Serie() {
        return Numero_Serie;
    }

    /**
     * Establece el número de serie del automóvil.
     *
     * @param Numero_Serie El número de serie del automóvil a establecer.
     */
    public void setNumero_Serie(String Numero_Serie) {
        this.Numero_Serie = Numero_Serie;
    }

    /**
     * Retorna el modelo del automóvil.
     *
     * @return El modelo del automóvil.
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * Establece el modelo del automóvil.
     *
     * @param Modelo El modelo del automóvil a establecer.
     */
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * Retorna la línea del automóvil.
     *
     * @return La línea del automóvil.
     */
    public String getLínea() {
        return línea;
    }

    /**
     * Establece la línea del automóvil.
     *
     * @param línea La línea del automóvil a establecer.
     */
    public void setLínea(String línea) {
        this.línea = línea;
    }

    /**
     * Retorna la marca del automóvil.
     *
     * @return La marca del automóvil.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del automóvil.
     *
     * @param marca La marca del automóvil a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna el color del automóvil.
     *
     * @return El color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del automóvil.
     *
     * @param color El color del automóvil a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retorna la persona asociada al automóvil.
     *
     * @return La persona asociada al automóvil.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al automóvil.
     *
     * @param persona La persona asociada al automóvil a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
