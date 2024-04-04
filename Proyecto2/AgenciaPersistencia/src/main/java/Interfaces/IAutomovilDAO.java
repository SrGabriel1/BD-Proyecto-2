/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Placas;
import Excepciones.persistenciaException;

/**
 *
 * @author yohan
 */
public interface IAutomovilDAO {

   public void agregarPlaca(Placas placa) throws persistenciaException;

    public Placas buscarPlacaActiva() throws persistenciaException;
}
