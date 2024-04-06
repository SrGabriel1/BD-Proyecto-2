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
public interface IAutomovilDAO {

   public void registrarAutoYPlaca(Placas placa,Automovil auto) throws persistenciaException;
   public void actualizarPlaca(Placas placa,Automovil auto) throws persistenciaException;

    public Placas buscarPlacaActiva(Automovil auto) throws persistenciaException;
    public Automovil buscarAutomovilPorPlaca(String numPlaca)throws persistenciaException;
}
