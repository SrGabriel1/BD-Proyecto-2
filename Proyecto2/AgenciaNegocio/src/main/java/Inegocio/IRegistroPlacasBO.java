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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public interface IRegistroPlacasBO {

    public String RegistrarPlacasNuevas(PlacaDTO placa, AutomovilDTO auto) throws persistenciaException;

  
    public String RegistrarPlacasViejas(String numeroPlaca, PlacaDTO placa) throws persistenciaException;

}
