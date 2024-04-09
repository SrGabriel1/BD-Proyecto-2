/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.agenciapresentacion;

import GUI.ControladorVentana;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class AgenciaPresentacion {

    /**
     * Método principal para iniciar la aplicación. Este método crea una
     * instancia del ControladorVentana, cambia la vista a la ventana de menú y
     * hace visible la ventana.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
     */
    public static void main(String[] args) {
        ControladorVentana ventana = new ControladorVentana();
        ventana.cambiarVistaMenu();
        ventana.setVisible(true);
    }
}
