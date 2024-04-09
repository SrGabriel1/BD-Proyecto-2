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
     * Constructor sin argumentos para la excepción PersistenciaException.
     */
    public persistenciaException() {
    }

    /**
     * Constructor que recibe un mensaje para la excepción
     * PersistenciaException.
     *
     * @param message El mensaje que describe el error.
     */
    public persistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje y una causa para la excepción
     * PersistenciaException.
     *
     * @param message El mensaje que describe el error.
     * @param cause La causa del error.
     */
    public persistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe una causa para la excepción PersistenciaException.
     *
     * @param cause La causa del error.
     */
    public persistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que recibe un mensaje, una causa, un indicador de si la
     * supresión está habilitada y un indicador de si la pila de llamadas es
     * editable para la excepción PersistenciaException.
     *
     * @param message El mensaje que describe el error.
     * @param cause La causa del error.
     * @param enableSuppression Un indicador de si la supresión está habilitada
     * o no.
     * @param writableStackTrace Un indicador de si la pila de llamadas es
     * editable o no.
     */
    public persistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
