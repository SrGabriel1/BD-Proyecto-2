/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOs.PlacasDAO;
import DTOs.AutomovilDTO;
import DTOs.PlacasDTO;
import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Inegocio.IRegistroPlacasBO;
import Interfaces.IPlacasDAO;
import Validadores.Validador;

/**
 *
 * @author USER
 */
public class RegistroPlacasBO implements IRegistroPlacasBO {

    @Override
    public void RegistrarPlacasNuevas(PlacasDTO placadto, AutomovilDTO auto) throws persistenciaException {
        Validador validador = new Validador();
        String numeroPlaca = Placas.generarPlaca();
        placadto.setEstado("Activa");
        Placas placa = new Placas(numeroPlaca, placadto.getFecha_emision(), placadto.getFecha_recepcion(), placadto.getCosto(), placadto.getAuto_id(), placadto.getTipo(), placadto.getEstado());
        IPlacasDAO Iplacas = new PlacasDAO();
        if (validador.ValidarPlaca(placa)) {
            throw new persistenciaException("Hay una placa con esos datos");
        }
        if (Iplacas.agregarPlacas(placa)) {
            if (auto != null) {
                auto.agregarPlaca(placa);
            } else {
                throw new persistenciaException("Error: la placa no está asociada a un automóvil.");
            }
        } else {
            throw new persistenciaException("Error al agregar la placa");
        }

    }

    //popipopopipo
    // miku miku oeo
    @Override
    public void RegistrarPlacasViejas(PlacasDTO placa) throws persistenciaException {
        Validador validador = new Validador();
        Placas Placa = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), placa.getAuto_id(), placa.getTipo(), placa.getEstado());
        IPlacasDAO Iplacas = new PlacasDAO();

        // Validar que la placa no este ya registrada
        if (validador.ValidarPlaca(Placa)) {
            throw new persistenciaException("La placa ya esta registrada.");
        }

        // Verificar que el automóvil esté registrado y asociado a una placa activa
        Automovil automovil = Placa.getAuto_id();
        AutomovilDTO auto = new AutomovilDTO();
        if (automovil == null) {
            throw new persistenciaException("Error: la placa no está asociada a un automóvil registrado.");
        }

        // Buscar una placa activa asociada al automóvil
        Placas placaActiva = auto.buscarPlacaActiva();
        if (placaActiva != null) {
            // Asociar las placas al automóvil y agregarlas
            if (Iplacas.asociarPlacas(Placa, automovil)) {
                auto.agregarPlaca(Placa);
                // Desactivar la placa activa anterior
                placaActiva.setEstado("Desactivada");
                // Actualizar la placa activa en la base de datos
                Iplacas.actualizarPlaca(placaActiva);

                // Generar nuevas placas y asociarlas al automóvil
                String numeroPlacaNueva = Placas.generarPlaca();
                placa.setNumero(numeroPlacaNueva);
                placa.setEstado("Activa");
                Placas nuevaPlaca = new Placas(placa.getNumero(), placa.getFecha_emision(), placa.getFecha_recepcion(), placa.getCosto(), automovil, placa.getTipo(), placa.getEstado());
                if (!validador.ValidarPlaca(nuevaPlaca) && Iplacas.agregarPlacas(nuevaPlaca)) {
                    auto.agregarPlaca(nuevaPlaca);
                } else {
                    throw new persistenciaException("Error al generar y asociar las nuevas placas al automóvil.");
                }
            } else {
                throw new persistenciaException("Error al asociar las placas al automóvil registrado.");
            }
        } else {
            throw new persistenciaException("No se encontró una placa activa asociada al automóvil.");
        }
    }
}
