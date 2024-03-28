/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;

/**
 *
 * @author yohan
 */
public interface IPlacasDAO {
    public String GenerarNumero() throws persistenciaException;
    public Placas agregarPlacas(Placas placas) throws persistenciaException;
    public boolean asociarPlacas(Placas placas,Automovil auto) throws persistenciaException;
}
