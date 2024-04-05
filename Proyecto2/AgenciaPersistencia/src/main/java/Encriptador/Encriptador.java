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

    public static String encriptar(String value) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] initVector = new byte[16];
            random.nextBytes(initVector);
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(initVector) + ":" + Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            System.err.println("Error al encriptar: " + ex.getMessage());
            return null;
        }
    }

    public static String desencriptar(String encriptado) {
        try {
            String[] parts = encriptado.split(":");
            IvParameterSpec iv = new IvParameterSpec(Base64.getDecoder().decode(parts[0]));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(parts[1]));
            return new String(original);
        } catch (Exception ex) {
            System.err.println("Error al desencriptar: " + ex.getMessage());
            return null;
        }
    }
}
