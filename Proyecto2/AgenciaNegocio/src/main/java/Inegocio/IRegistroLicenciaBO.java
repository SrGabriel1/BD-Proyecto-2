/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inegocio;

import DTOs.LicenciaDTO;
import DTOs.PlacasDTO;
import Entidades.Automovil;
import Entidades.Licencia;
import Entidades.Persona;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface IRegistroLicenciaBO {

    public void RegistrarLicencia(LicenciaDTO licencia) throws persistenciaException;

    public Persona VerificarPersona(String rfc) throws persistenciaException;

    public void RegistrarPlacasNuevas(PlacasDTO placa, Automovil auto) throws persistenciaException;
    
     public void RegistrarPlacasViejas(PlacasDTO placa) throws persistenciaException;

    
}
