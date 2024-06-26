/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Placas;

import DTOs.AutomovilDTO;
import DTOs.PlacaDTO;
import Excepciones.persistenciaException;
import GUI.ControladorVentana;
import Inegocio.IRegistroPlacasBO;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.RegistroPlacasBO;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class TramiteGenerarPlacas extends javax.swing.JPanel {

    private ControladorVentana ventana;
    private AutomovilDTO auto;
    private String numPlaca;
    private String tipo;
    private PlacaDTO placa;
    private int modo;

    /**
     * Creates new form TramiteGenerarPlacas
     */
    public TramiteGenerarPlacas() {
        initComponents();
    }

    public TramiteGenerarPlacas(ControladorVentana ventana, AutomovilDTO auto, PlacaDTO placa, String tipo, int modo) {
        this.ventana = ventana;
        this.auto = auto;
        this.tipo = tipo;
        this.placa = placa;
        this.modo = modo;
        initComponents();
        if (modo == 1) {
            Costo.setText("$1,500");
            tipo_Auto.setText("Nuevo");
        } else if (modo == 2) {
            Costo.setText("$1,000");
            tipo_Auto.setText("Usado");
        }
    }

    public TramiteGenerarPlacas(ControladorVentana ventana, String numPlaca, PlacaDTO placa, String tipo, int modo) {
        this.ventana = ventana;
        this.numPlaca = numPlaca;
        this.tipo = tipo;
        this.placa = placa;
        this.modo = modo;
        initComponents();
        if (modo == 1) {
            Costo.setText("$1,500");
            tipo_Auto.setText("Nuevo");
        } else if (modo == 2) {
            Costo.setText("$1,000");
            tipo_Auto.setText("Usado");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_Auto = new javax.swing.JTextField();
        Costo = new javax.swing.JTextField();
        FechaEmisionDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        FechaRecepcionDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        regresar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tipo_Auto.setEditable(false);
        tipo_Auto.setBackground(new java.awt.Color(217, 217, 217));
        tipo_Auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_AutoActionPerformed(evt);
            }
        });
        add(tipo_Auto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 190, 40));

        Costo.setEditable(false);
        Costo.setBackground(new java.awt.Color(217, 217, 217));
        add(Costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 40));
        add(FechaEmisionDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, 40));
        add(FechaRecepcionDatePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 200, 40));

        regresar.setBorderPainted(false);
        regresar.setContentAreaFilled(false);
        regresar.setFocusPainted(false);
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 150, 50));

        Aceptar.setBorderPainted(false);
        Aceptar.setContentAreaFilled(false);
        Aceptar.setFocusPainted(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TramitePlacas.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 390));
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        if (tipo.equalsIgnoreCase("nuevo")) {
            ventana.cambiarVistaTramiteAutoNuevo();
        } else if (tipo.equalsIgnoreCase("usado")) {
            ventana.cambiarVistaTramiteAutoUsado();
        }

    }//GEN-LAST:event_regresarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        try {
            IRegistroPlacasBO rp = new RegistroPlacasBO();
            LocalDate localDate = FechaEmisionDatePicker.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(Calendar.YEAR, localDate.getYear());
            calendar.set(Calendar.MONTH, localDate.getMonthValue() - 1);
            calendar.set(Calendar.DAY_OF_MONTH, localDate.getDayOfMonth());
            placa.setFecha_emision(calendar);

            localDate = FechaRecepcionDatePicker.getDate();
            calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(Calendar.YEAR, localDate.getYear());
            calendar.set(Calendar.MONTH, localDate.getMonthValue() - 1);
            calendar.set(Calendar.DAY_OF_MONTH, localDate.getDayOfMonth());
            placa.setFecha_recepcion(calendar);
            String numPlacaTemp;
            if (modo == 1) {
                numPlacaTemp = rp.RegistrarPlacasNuevas(placa, auto);
            } else {
                numPlacaTemp = rp.RegistrarPlacasViejas(numPlaca, placa);
            }

            ventana.cambiarVistaPlacaGenerada(numPlacaTemp, Costo.getText());
        } catch (persistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_AceptarActionPerformed

    private void tipo_AutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_AutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_AutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField Costo;
    private com.github.lgooddatepicker.components.DatePicker FechaEmisionDatePicker;
    private com.github.lgooddatepicker.components.DatePicker FechaRecepcionDatePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField tipo_Auto;
    // End of variables declaration//GEN-END:variables
}
