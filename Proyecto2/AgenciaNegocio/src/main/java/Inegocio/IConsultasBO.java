/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inegocio;

import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import Excepciones.persistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IConsultasBO {

    /**
     *
     * @return @throws persistenciaException
     */
    public Persona regresarPersona(Licencia licencia) throws persistenciaException;

    public Licencia regresarLicencia(String numLicencia) throws persistenciaException;

    public Automovil regresarAutomovil(String numPlaca) throws persistenciaException;

    public void comprobarMismoDueno(Automovil auto, Licencia licencia) throws persistenciaException;

    public List<Tramite> ConsultaTramite(String RFC) throws persistenciaException;

    public List<Persona> regresarPersonasSimilares(String nombre, String curp, Integer anioNacimiento) throws persistenciaException;

    public List<Tramite> ConsultaConTipo(String nombre, String tipoTramite, Calendar desde, Calendar hasta) throws persistenciaException;
}
