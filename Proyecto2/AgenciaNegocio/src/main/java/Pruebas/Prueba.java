/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import DAOs.LicenciasDAO;
import Excepciones.persistenciaException;
import negocio.RegistroLicenciaBO;

/**
 *
 * @author yohan
 */
public class Prueba {

    public static void main(String[] args) throws persistenciaException {
        RegistroLicenciaBO r = new RegistroLicenciaBO();
        System.out.println(r.VerificarPersona("FOLC920713345").getPersona().toString());
        LicenciasDAO licencia = new LicenciasDAO();
        licencia.setLicencia("1 ano", "normal", 600F, "Activa");
        r.RegistrarLicencia(licencia);
    }
}
