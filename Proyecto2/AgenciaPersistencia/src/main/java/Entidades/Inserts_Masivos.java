/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Encriptador.Encriptador;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yohan
 */
public class Inserts_Masivos {

    public static void main(String[] args) {
        //creamos la lista donde almacenaremos las entidades a persistir
        //tipo Object para guardar independiente de la clase
        ArrayList<Object> entidades = new ArrayList<>();

        // creamos las fechas
        GregorianCalendar fecha1 = new GregorianCalendar(2004, 1, 5);
        GregorianCalendar fecha2 = new GregorianCalendar(1995, 4, 15);
        GregorianCalendar fecha3 = new GregorianCalendar(1980, 8, 25);
        GregorianCalendar fecha4 = new GregorianCalendar(1998, 11, 10);
        GregorianCalendar fecha5 = new GregorianCalendar(1975, 6, 30);
        GregorianCalendar fecha6 = new GregorianCalendar(1990, 9, 12);
        GregorianCalendar fecha7 = new GregorianCalendar(2002, 3, 20);
        GregorianCalendar fecha8 = new GregorianCalendar(1988, 2, 8);
        GregorianCalendar fecha9 = new GregorianCalendar(1993, 12, 3);
        GregorianCalendar fecha10 = new GregorianCalendar(1972, 10, 18);
        GregorianCalendar fecha11 = new GregorianCalendar(2006, 7, 28);
        GregorianCalendar fecha12 = new GregorianCalendar(1985, 5, 14);
        GregorianCalendar fecha13 = new GregorianCalendar(1999, 9, 5);
        GregorianCalendar fecha14 = new GregorianCalendar(2000, 1, 1);
        GregorianCalendar fecha15 = new GregorianCalendar(1999, 5, 5);
        GregorianCalendar fecha16 = new GregorianCalendar(1987, 11, 24);
        GregorianCalendar fecha17 = new GregorianCalendar(1980, 7, 12);
        GregorianCalendar fecha18 = new GregorianCalendar(1991, 4, 9);
        GregorianCalendar fecha19 = new GregorianCalendar(1983, 2, 15);
        GregorianCalendar fecha20 = new GregorianCalendar(1995, 6, 20);
        // creamos Personas
        Persona p1 = new Persona("Jesus", "mendoza", "cruz", "MENJ040205HMCRNL04 ", "MECJ940205123", "644213413", fecha1);
        Persona p2 = new Persona("Gabriel", "Hernández", "Álvarez", "MENJ040205HMCRNL04 ", "HEAG880702456", "6442345678", fecha2);
        Persona p3 = new Persona("Luis", "López", "Bautista", "LOBL660612HDFXTC01 ", "LOBL660612789", "6443456789", fecha3);
        Persona p4 = new Persona("Pepe", "Pérez", "Cervantes", "PECR780525HMCFVR03 ", "PECR780525321", "6444567890", fecha4);
        Persona p5 = new Persona("Juan", "Rodríguez", "Espinoza", "RODE851005HDFRTN04 ", "ROES851005678", "6445678901", fecha5);
        Persona p6 = new Persona("Ximena", "Martínez", "Fuentes", "MAFJ870725HDFXRS06 ", "MAFJ870725901", "6446789012", fecha6);
        Persona p7 = new Persona("Andrea", "García", "Gómez", "GAAG910321HDFGRR09 ", "GAGG910321234", "6447890123", fecha7);
        Persona p8 = new Persona("Daniela", "Sánchez", "Herrera", "SANJ891105HDFHRR08 ", "SAHD891105567", "6448901234", fecha8);
        Persona p9 = new Persona("Gabriela", "Ramírez", "Juárez", "RAGJ910630HDFTNZ02 ", "RAJG910630890", "6449012345", fecha9);
        Persona p10 = new Persona("Paulina", "Torres", "Ibarra", "TOCP880218HDFRLS08 ", "TOIP880218234", "6440123456", fecha10);
        Persona p11 = new Persona("Carla", "Flores", "León", "FLRC920713HDFCRN01 ", "FOLC920713345", "6441234567", fecha11);
        Persona p12 = new Persona("Carlos", "Vázquez", "Morales", "VZCM900504HDFMLL00 ", "VAMC900504678", "6442345678", fecha12);
        Persona p13 = new Persona("Felipe", "Díaz", "Núñez", "DIFP800719HDFNXF02 ", "DINF800719901", "6443456789", fecha13);
        Persona p14 = new Persona("Sarahi", "Romero", "Ortega", "RORX930830HDFMTG02 ", "RORS930830456", "6444567890", fecha14);
        Persona p15 = new Persona("Ana", "González", "Martínez", "GONM990505HDFXXX01 ", "GOMA990505XXX", "6449876543", fecha15);
        Persona p16 = new Persona("Miguel", "Hernández", "López", "HELM871124HDFXXX02 ", "HELO871124XXX", "6448765432", fecha16);
        Persona p17 = new Persona("Elena", "Martínez", "Pérez", "MAPJ800712HDFXXX03 ", "MAPE800712XXX", "6447654321", fecha17);
        Persona p18 = new Persona("David", "López", "Gómez", "LOGD910409HDFXXX04 ", "LOGO910409XXX", "6446543210", fecha18);
        Persona p19 = new Persona("Alejandra", "Torres", "Rodríguez", "TORA830215HDFXXX05 ", "TORO830215XXX", "6445432109", fecha19);
        Persona p20 = new Persona("Santiago", "García", "Flores", "GAFS950620HDFXXX06 ", "GAFL950620XXX", "6444321098", fecha20);

        // Encripta los teléfonos antes de agregarlos a la lista de entidades
        p1.setTelefono(Encriptador.encriptar(p1.getTelefono()));
        p2.setTelefono(Encriptador.encriptar(p2.getTelefono()));
        p3.setTelefono(Encriptador.encriptar(p3.getTelefono()));
        p4.setTelefono(Encriptador.encriptar(p4.getTelefono()));
        p5.setTelefono(Encriptador.encriptar(p5.getTelefono()));
        p6.setTelefono(Encriptador.encriptar(p6.getTelefono()));
        p7.setTelefono(Encriptador.encriptar(p7.getTelefono()));
        p8.setTelefono(Encriptador.encriptar(p8.getTelefono()));
        p9.setTelefono(Encriptador.encriptar(p9.getTelefono()));
        p10.setTelefono(Encriptador.encriptar(p10.getTelefono()));
        p11.setTelefono(Encriptador.encriptar(p11.getTelefono()));
        p12.setTelefono(Encriptador.encriptar(p12.getTelefono()));
        p13.setTelefono(Encriptador.encriptar(p13.getTelefono()));
        p14.setTelefono(Encriptador.encriptar(p14.getTelefono()));
        p15.setTelefono(Encriptador.encriptar(p15.getTelefono()));
        p16.setTelefono(Encriptador.encriptar(p16.getTelefono()));
        p17.setTelefono(Encriptador.encriptar(p17.getTelefono()));
        p18.setTelefono(Encriptador.encriptar(p18.getTelefono()));
        p19.setTelefono(Encriptador.encriptar(p19.getTelefono()));
        p20.setTelefono(Encriptador.encriptar(p20.getTelefono()));
        //agregamos las personas a la lista de entidades
        entidades.add(p1);
        entidades.add(p2);
        entidades.add(p3);
        entidades.add(p4);
        entidades.add(p5);
        entidades.add(p6);
        entidades.add(p7);
        entidades.add(p8);
        entidades.add(p9);
        entidades.add(p10);
        entidades.add(p11);
        entidades.add(p12);
        entidades.add(p13);
        entidades.add(p14);
        entidades.add(p15);
        entidades.add(p16);
        entidades.add(p17);
        entidades.add(p18);
        entidades.add(p19);
        entidades.add(p20);
        //empezamos el proceso para persistir las entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //persistimos todas las entidades almacenadas en la lista
        for (Object entidad : entidades) {
            em.persist(entidad); //cada vuelta almacena la entidad correspondiente
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
