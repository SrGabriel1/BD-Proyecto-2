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
     * Registra un nuevo juego de placas para un automóvil nuevo en el sistema.
     *
     * @param placa La información de la placa que se va a registrar.
     * @param auto La información del automóvil al que se le asignarán las
     * placas.
     * @return Un mensaje indicando el resultado del registro de placas.
     * @throws persistenciaException Si ocurre algún error durante el proceso de
     * persistencia.
     */
    public String RegistrarPlacasNuevas(PlacaDTO placa, AutomovilDTO auto) throws persistenciaException;

    /**
     * Registra la devolución de un juego de placas viejas y asigna nuevas
     * placas al vehículo correspondiente.
     *
     * @param numeroPlaca El número de placa que se está devolviendo.
     * @param placa La información de la nueva placa que se asignará al
     * vehículo.
     * @return Un mensaje indicando el resultado del registro de la devolución y
     * asignación de placas.
     * @throws persistenciaException Si ocurre algún error durante el proceso de
     * persistencia.
     */
    public String RegistrarPlacasViejas(String numeroPlaca, PlacaDTO placa) throws persistenciaException;

}
