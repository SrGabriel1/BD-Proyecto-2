/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inegocio;

import DAOs.LicenciasDAO;
import Excepciones.persistenciaException;

/**
 *
 * @author USER
 */
public interface IRegistroLicenciaBO {
    public void RegistrarLicencia(LicenciasDAO licencia) throws persistenciaException;
}
