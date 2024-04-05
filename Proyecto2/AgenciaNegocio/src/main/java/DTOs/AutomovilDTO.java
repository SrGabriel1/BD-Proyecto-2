/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import DAOs.AutomovilDAO;
import Entidades.Licencia;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IAutomovilDAO;

/**
 *
 * @author yohan
 */
public class AutomovilDTO implements IAutomovilDAO {

    IAutomovilDAO auto;
    
    private String Numero_Serie;

    private String Modelo;

    private String línea;

    private String marca;

    private String color;
    
    private Licencia licencia;

    public AutomovilDTO() {
        this.auto = new AutomovilDAO();
    }

    public AutomovilDTO(String Numero_Serie, String Modelo, String línea, String marca, String color, Licencia licencia) {
        this.Numero_Serie = Numero_Serie;
        this.Modelo = Modelo;
        this.línea = línea;
        this.marca = marca;
        this.color = color;
        this.licencia = licencia;
    }
    
    @Override
    public void agregarPlaca(Placas placa) throws persistenciaException {
        auto.agregarPlaca(placa);
    }

    @Override
    public Placas buscarPlacaActiva() throws persistenciaException {
        return auto.buscarPlacaActiva();
    }

    public IAutomovilDAO getAuto() {
        return auto;
    }

    public void setAuto(IAutomovilDAO auto) {
        this.auto = auto;
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

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }
    
}
