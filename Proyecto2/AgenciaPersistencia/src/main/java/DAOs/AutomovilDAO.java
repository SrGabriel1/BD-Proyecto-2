/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Automovil;
import Entidades.Placas;
import Excepciones.persistenciaException;
import Interfaces.IAutomovilDAO;

/**
 *
 * @author yohan
 */
public class AutomovilDAO implements IAutomovilDAO {

    Automovil auto;

    public Automovil getAuto() {
        return auto;
    }

    public void setAuto(Automovil auto) {
        this.auto = auto;
    }

    @Override
    public void agregarPlaca(Placas placa) throws persistenciaException {
        auto.agregarPlaca(placa);
    }

    @Override
    public Placas buscarPlacaActiva() throws persistenciaException {
        return auto.buscarPlacaActiva();
    }
        
    }
