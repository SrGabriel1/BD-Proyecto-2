/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class persistenciaException extends Exception {

    /**
     * Excepción personalizada para la capa de persistencia.
     */
    public persistenciaException() {
    }

    /**
     * Crea una nueva instancia de PersistenciaException con el mensaje
     * especificado.
     *
     * @param message El mensaje que describe la excepción.
     */
    public persistenciaException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con el mensaje y la
     * causa específica.
     *
     * @param message El mensaje que describe la excepción.
     * @param cause La causa de la excepción.
     */
    public persistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con la causa
     * específica.
     *
     * @param cause La causa de la excepción.
     */
    public persistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con el mensaje, la
     * causa, la capacidad de supresión habilitada o deshabilitada y la
     * capacidad de rastreo en la pila habilitada o deshabilitada.
     *
     * @param message El mensaje que describe la excepción.
     * @param cause La causa de la excepción.
     * @param enableSuppression Indica si la supresión de excepciones está
     * habilitada o no.
     * @param writableStackTrace Indica si el rastreo en la pila debe ser
     * habilitado o no.
     */

    public persistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
