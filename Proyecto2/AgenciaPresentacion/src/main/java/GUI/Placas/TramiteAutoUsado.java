/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Placas;

import GUI.ControladorVentana;

/**
 *
 * @author USER
 */
public class TramiteAutoUsado extends javax.swing.JPanel {

    private ControladorVentana ventana;
    /**
     * Creates new form TramiteAutoUsado1
     */
    public TramiteAutoUsado() {
        initComponents();
    }
    public TramiteAutoUsado(ControladorVentana ventana) {
        this.ventana = ventana;
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

        jLabel1 = new javax.swing.JLabel();
        txtPlacasAntiguas = new javax.swing.JTextField();
        txtLicencia = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(450, 277));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TramiteAutoUsadoCap.PNG"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(450, 277));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 280));

        txtPlacasAntiguas.setBackground(new java.awt.Color(130, 130, 130));
        add(txtPlacasAntiguas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 260, 30));

        txtLicencia.setBackground(new java.awt.Color(130, 130, 130));
        txtLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLicenciaActionPerformed(evt);
            }
        });
        add(txtLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 260, 30));

        botonIngresar.setBorderPainted(false);
        botonIngresar.setContentAreaFilled(false);
        botonIngresar.setFocusPainted(false);
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });
        add(botonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 130, 40));

        botonRegresar.setBorderPainted(false);
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setFocusPainted(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        // TODO add your handling code here:
        
        
        ventana.cambiarVistaPlacaGenerada();
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        ventana.cambiarVistaPlaca();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void txtLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLicenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtPlacasAntiguas;
    // End of variables declaration//GEN-END:variables
}
