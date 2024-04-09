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
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public interface IPlacasDAO {

    /**
     * Genera un número de placa de manera aleatoria.
     *
     * @return El número de placa generado.
     * @throws persistenciaException Si ocurre un error durante la generación
     * del número de placa.
     */
    public String GenerarNumero() throws persistenciaException;

    /**
     * Agrega nuevas placas a la base de datos.
     *
     * @param placas Las placas que se desean agregar.
     * @return true si las placas se agregan correctamente, false en caso
     * contrario.
     * @throws persistenciaException Si ocurre un error durante la inserción de
     * las placas.
     */
    public boolean agregarPlacas(Placas placas) throws persistenciaException;

    /**
     * Asocia las placas especificadas a un automóvil en la base de datos.
     *
     * @param placas Las placas que se desean asociar.
     * @param auto El automóvil al que se desean asociar las placas.
     * @return true si las placas se asocian correctamente al automóvil, false
     * en caso contrario.
     * @throws persistenciaException Si ocurre un error durante la asociación de
     * las placas.
     */
    public boolean asociarPlacas(Placas placas, Automovil auto) throws persistenciaException;

    /**
     * Actualiza la información de las placas en la base de datos.
     *
     * @param placa Las placas que se desean actualizar.
     * @return true si las placas se actualizan correctamente, false en caso
     * contrario.
     * @throws persistenciaException Si ocurre un error durante la actualización
     * de las placas.
     */
    public boolean actualizarPlaca(Placas placa) throws persistenciaException;
}
