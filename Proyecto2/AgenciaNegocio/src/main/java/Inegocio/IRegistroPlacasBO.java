/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inegocio;

import DTOs.AutomovilDTO;
import DTOs.PlacaDTO;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface IRegistroPlacasBO {

    public String RegistrarPlacasNuevas(PlacaDTO placa, AutomovilDTO auto) throws persistenciaException;
    
     public String RegistrarPlacasViejas(PlacaDTO placa) throws persistenciaException;

    
}
