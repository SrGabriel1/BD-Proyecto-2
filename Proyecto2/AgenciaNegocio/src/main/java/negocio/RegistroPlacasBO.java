/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.AutomovilDAO;
import DAOs.PlacasDAO;
import DTOs.AutomovilDTO;
import DTOs.PlacaDTO;
import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Inegocio.IConsultasBO;
import Inegocio.IRegistroPlacasBO;
import Interfaces.IAutomovilDAO;
import Interfaces.IPlacasDAO;
import Validadores.Validador;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class RegistroPlacasBO implements IRegistroPlacasBO {

    /**
     * Registra placas nuevas para un automóvil.
     *
     * @param placadto El objeto PlacaDTO que contiene la información de las
     * placas a registrar.
     * @param auto El objeto AutomovilDTO que contiene la información del
     * automóvil al que se le asignarán las placas.
     * @return El número de placa generado para las nuevas placas.
     * @throws persistenciaException Si ocurre un error durante el registro de
     * las placas.
     */
    @Override
    public String RegistrarPlacasNuevas(PlacaDTO placadto, AutomovilDTO auto) throws persistenciaException {
        try {
            Validador validador = new Validador();
            String numeroPlaca = Placas.generarPlaca();
            placadto.setEstado("Activa");

            Automovil autoTemp = new Automovil(auto.getNumero_Serie(), auto.getModelo(), auto.getLínea(), auto.getMarca(), auto.getColor(), auto.getPersona());
            Placas placa = new Placas(numeroPlaca, placadto.getFecha_emision(), placadto.getFecha_recepcion(), placadto.getCosto(), autoTemp, placadto.getTipo(), placadto.getEstado());

            IAutomovilDAO Iautomovil = new AutomovilDAO();
            if (validador.ValidarPlaca(placa)) {
                throw new persistenciaException("Hay una placa con esos datos");
            } else {
                Iautomovil.registrarAutoYPlaca(placa, autoTemp);
                return numeroPlaca;
            }
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }
    }

    /**
     * Registra placas para un automóvil existente (placas viejas).
     *
     * @param numeroPlaca El número de placa a asignar.
     * @param placa El objeto PlacaDTO que contiene la información de las placas
     * a registrar.
     * @return El número de placa generado para las placas registradas.
     * @throws persistenciaException Si ocurre un error durante el registro de
     * las placas.
     */
    @Override
    public String RegistrarPlacasViejas(String numeroPlaca, PlacaDTO placa) throws persistenciaException {

        Validador validador = new Validador();
        String numeroPlacaGenerado = Placas.generarPlaca();
        Placas Placa = new Placas(numeroPlacaGenerado, placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), placa.getAuto_id(), placa.getTipo(), placa.getEstado());
        IPlacasDAO Iplacas = new PlacasDAO();
        IAutomovilDAO Iautomovil = new AutomovilDAO();
        IConsultasBO consultas = new ConsultasBO();
        try {
            Automovil autoTemp = consultas.regresarAutomovil(numeroPlaca);
            Iautomovil.actualizarPlaca(Placa, autoTemp);
            return numeroPlacaGenerado;
        } catch (Exception e) {
            throw new persistenciaException(e.getMessage());
        }

    }
}
