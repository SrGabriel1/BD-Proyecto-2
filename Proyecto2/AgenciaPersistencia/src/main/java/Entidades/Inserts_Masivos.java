/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

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
