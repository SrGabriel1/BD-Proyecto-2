/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Placas;

import DTOs.AutomovilDTO;
import GUI.Ventana;
import Inegocio.IRegistroPlacasBO;
import negocio.RegistroPlacasBO;

/**
 *
 * @author USER
 */
public class PlacaGenerada extends javax.swing.JPanel {

    AutomovilDTO auto;
    private IRegistroPlacasBO rp;

    private Ventana ventana;

    /**
     * Creates new form PlacasGeneradas
     */
    public PlacaGenerada() {
        initComponents();
    }

    public PlacaGenerada(Ventana ventana) {
        this.ventana = ventana;
        this.auto = auto;
        this.rp = new RegistroPlacasBO();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrecio = new javax.swing.JTextField();
        txtPlacasNuevas = new javax.swing.JTextField();
        botonRegresarMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrecio.setEditable(false);
        txtPrecio.setBackground(new java.awt.Color(217, 217, 217));
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 200, 40));

        txtPlacasNuevas.setEditable(false);
        txtPlacasNuevas.setBackground(new java.awt.Color(217, 217, 217));
        add(txtPlacasNuevas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 210, 40));

        botonRegresarMenu.setBorderPainted(false);
        botonRegresarMenu.setContentAreaFilled(false);
        botonRegresarMenu.setFocusPainted(false);
        botonRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarMenuActionPerformed(evt);
            }
        });
        add(botonRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PlacasGeneradasCap.PNG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarMenuActionPerformed
        // TODO add your handling code here:
        ventana.cambiarVistaMenu();
    }//GEN-LAST:event_botonRegresarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtPlacasNuevas;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
