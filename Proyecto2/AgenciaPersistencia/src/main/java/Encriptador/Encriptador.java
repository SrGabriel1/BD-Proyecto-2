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
 * @author yohan
 */
public class Encriptador {

    private static final String key = "1234"; 

    public static String encriptar(String texto) {
        try {
            char array[]=texto.toCharArray();
            for(int i =0;i<array.length;i++){
                array[i]=(char)(array[i] +(char)20);
            }
            return String.valueOf(array);
        } catch (Exception ex) {
            System.err.println("Error al encriptar: " + ex.getMessage());
            return null;
        }
    }

    public static String desencriptar(String texto) {
        try {
            char array[]=texto.toCharArray();
            for(int i =0;i<array.length;i++){
                array[i]=(char)(array[i] -(char)20);
            }
            return String.valueOf(array);
        } catch (Exception ex) {
            System.err.println("Error al encriptar: " + ex.getMessage());
            return null;
        }
    }
}
