package GUI;


import GUI.Ventana;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author yohan
 */
public class Menu extends javax.swing.JPanel {

    private Ventana ventana;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }
       public Menu(Ventana ventana) {
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
        BotonLicencia = new javax.swing.JButton();
        BotonPlacas = new javax.swing.JButton();
        BotonReportes = new javax.swing.JButton();
        BotonHistorial = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/InicioCap.PNG"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(526, 390));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 530, 360));

        BotonLicencia.setContentAreaFilled(false);
        BotonLicencia.setFocusPainted(false);
        BotonLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLicenciaActionPerformed(evt);
            }
        });
        add(BotonLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 140, 50));

        BotonPlacas.setContentAreaFilled(false);
        BotonPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPlacasActionPerformed(evt);
            }
        });
        add(BotonPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 130, 30));

        BotonReportes.setContentAreaFilled(false);
        BotonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReportesActionPerformed(evt);
            }
        });
        add(BotonReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 140, 30));

        BotonHistorial.setContentAreaFilled(false);
        add(BotonHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLicenciaActionPerformed
        ventana.cambiarVistaLicencia();
    }//GEN-LAST:event_BotonLicenciaActionPerformed

    private void BotonPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPlacasActionPerformed
        // TODO add your handling code here:
        ventana.cambiarVistaPlaca();
    }//GEN-LAST:event_BotonPlacasActionPerformed

    private void BotonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonHistorial;
    private javax.swing.JButton BotonLicencia;
    private javax.swing.JButton BotonPlacas;
    private javax.swing.JButton BotonReportes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
