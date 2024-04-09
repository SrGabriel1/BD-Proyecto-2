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
public interface IAutomovilDAO {

    /**
     * Registra un nuevo auto y su placa asociada en la base de datos.
     *
     * @param placa La placa del auto a registrar.
     * @param auto El automóvil a registrar.
     * @throws persistenciaException Si ocurre un error durante la persistencia
     * de los datos.
     */
    public void registrarAutoYPlaca(Placas placa, Automovil auto) throws persistenciaException;

    /**
     * Actualiza la información de la placa asociada a un automóvil en la base
     * de datos.
     *
     * @param placa La nueva información de la placa a actualizar.
     * @param auto El automóvil al que se le actualizará la placa.
     * @throws persistenciaException Si ocurre un error durante la actualización
     * de la placa.
     */
    public void actualizarPlaca(Placas placa, Automovil auto) throws persistenciaException;

    /**
     * Busca la placa activa asociada a un automóvil en la base de datos.
     *
     * @param auto El automóvil del que se desea obtener la placa activa.
     * @return La placa activa asociada al automóvil.
     * @throws persistenciaException Si ocurre un error durante la búsqueda de
     * la placa activa.
     */
    public Placas buscarPlacaActiva(Automovil auto) throws persistenciaException;

    /**
     * Busca un automóvil por su número de placa en la base de datos.
     *
     * @param numPlaca El número de placa del automóvil que se desea buscar.
     * @return El automóvil correspondiente al número de placa especificado.
     * @throws persistenciaException Si ocurre un error durante la búsqueda del
     * automóvil.
     */
    public Automovil buscarAutomovilPorPlaca(String numPlaca) throws persistenciaException;
}
