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

    /**
     * Registra nuevas placas para un automóvil en el sistema.
     *
     * @param placa La información de las placas a registrar.
     * @param auto La información del automóvil al que se asociarán las placas.
     * @return El número de placas registrado.
     * @throws PersistenciaException Si ocurre algún error durante la operación
     * de registro.
     */
    public String RegistrarPlacasNuevas(PlacaDTO placa, AutomovilDTO auto) throws persistenciaException;

    /**
     * Registra placas para un automóvil existente en el sistema.
     *
     * @param numeroPlaca El número de placa del automóvil al que se registrarán
     * las nuevas placas.
     * @param placa La información de las nuevas placas a registrar.
     * @return El número de placas registrado.
     * @throws PersistenciaException Si ocurre algún error durante la operación
     * de registro.
     */
    public String RegistrarPlacasViejas(String numeroPlaca, PlacaDTO placa) throws persistenciaException;

}
