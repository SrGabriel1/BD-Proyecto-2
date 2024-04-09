/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encriptador;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class Encriptador {

    //Entidades de la clase
    private static final String key = "1234";

    /**
     * Este método encripta un texto utilizando un algoritmo simple de
     * desplazamiento de caracteres. Cada carácter del texto se desplaza 20
     * posiciones en el código ASCII.
     *
     * @param texto El texto que se va a encriptar.
     * @return El texto encriptado.
     */
    public static String encriptar(String texto) {
        try {
            char array[] = texto.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = (char) (array[i] + (char) 20);
            }
            return String.valueOf(array);
        } catch (Exception ex) {
            System.err.println("Error al encriptar: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Este método desencripta un texto que ha sido encriptado utilizando el
     * método encriptar de esta clase. Cada carácter del texto se desplaza 20
     * posiciones hacia atrás en el código ASCII.
     *
     * @param texto El texto encriptado que se va a desencriptar.
     * @return El texto desencriptado.
     */
    public static String desencriptar(String texto) {
        try {
            char array[] = texto.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = (char) (array[i] - (char) 20);
            }
            return String.valueOf(array);
        } catch (Exception ex) {
            System.err.println("Error al encriptar: " + ex.getMessage());
            return null;
        }
    }
}
