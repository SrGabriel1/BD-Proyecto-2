/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Licencia;

import DTOs.LicenciaDTO;
import Entidades.Licencia;
import Excepciones.persistenciaException;
import GUI.Ventana;
import Inegocio.IRegistroLicenciaBO;
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import negocio.RegistroLicenciaBO;

/**
 *
 * @author yohan
 */
public class VigenciaLicencia extends javax.swing.JPanel {

    private Ventana ventana;
    private IRegistroLicenciaBO rlb=new RegistroLicenciaBO();
    LicenciaDTO licencia = new LicenciaDTO();

    /**
     * Creates new form VigenciaLicencia1
     */
    public VigenciaLicencia() {
        initComponents();
    }

    public VigenciaLicencia(Ventana ventana, LicenciaDTO licencia) {
        this.ventana = ventana;
        this.licencia = licencia;
        this.rlb = new RegistroLicenciaBO();
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

        jRadioButton1 = new javax.swing.JRadioButton();
        checkBox700 = new javax.swing.JCheckBox();
        checkBox500 = new javax.swing.JCheckBox();
        checkBox200 = new javax.swing.JCheckBox();
        checkBox1100 = new javax.swing.JCheckBox();
        checkBox900 = new javax.swing.JCheckBox();
        checkBox600 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        BotonAceptar = new javax.swing.JButton();
        BotonRegresar = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();

        jRadioButton1.setText("jRadioButton1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkBox700.setBackground(new java.awt.Color(217, 217, 217));
        checkBox700.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        checkBox700.setText("$700");
        checkBox700.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox700ActionPerformed(evt);
            }
        });
        add(checkBox700, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 170, -1));

        checkBox500.setBackground(new java.awt.Color(217, 217, 217));
        checkBox500.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        checkBox500.setText("$500");
        checkBox500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox500ActionPerformed(evt);
            }
        });
        add(checkBox500, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 170, -1));

        checkBox200.setBackground(new java.awt.Color(217, 217, 217));
        checkBox200.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        checkBox200.setText("$200");
        checkBox200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox200ActionPerformed(evt);
            }
        });
        add(checkBox200, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 170, -1));

        checkBox1100.setBackground(new java.awt.Color(217, 217, 217));
        checkBox1100.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        checkBox1100.setText("$1,100");
        checkBox1100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox1100ActionPerformed(evt);
            }
        });
        add(checkBox1100, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 170, -1));

        checkBox900.setBackground(new java.awt.Color(217, 217, 217));
        checkBox900.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        checkBox900.setText("$900");
        checkBox900.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox900ActionPerformed(evt);
            }
        });
        add(checkBox900, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 170, -1));

        checkBox600.setBackground(new java.awt.Color(217, 217, 217));
        checkBox600.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        checkBox600.setText("$600");
        checkBox600.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBox600ActionPerformed(evt);
            }
        });
        add(checkBox600, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vigencia2.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(542, 346));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        BotonAceptar.setBorderPainted(false);
        BotonAceptar.setContentAreaFilled(false);
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });
        add(BotonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 299, 130, 30));

        BotonRegresar.setBorderPainted(false);
        BotonRegresar.setContentAreaFilled(false);
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });
        add(BotonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 289, 144, 40));

        jCheckBox3.setBackground(new java.awt.Color(217, 217, 217));
        jCheckBox3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jCheckBox3.setText("$900");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 170, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed

        try {
            if (checkBox200.isSelected()) {
                licencia.setTipoLicencia("Discapacitado");
                licencia.setPrecio(200F);
                licencia.setVigencia("1 año");
            } else if (checkBox500.isSelected()) {
                licencia.setTipoLicencia("Discapacitado");
                licencia.setPrecio(500F);
                licencia.setVigencia("2 año");
            } else if (checkBox700.isSelected()) {
                licencia.setTipoLicencia("Discapacitado");
                licencia.setPrecio(700F);
                licencia.setVigencia("3 año");
            } else if (checkBox600.isSelected()) {
                licencia.setTipoLicencia("Normal");
                licencia.setPrecio(600F);
                licencia.setVigencia("1 año");
            } else if (checkBox900.isSelected()) {
                licencia.setTipoLicencia("Normal");
                licencia.setPrecio(900F);
                licencia.setVigencia("2 año");
            } else if (checkBox1100.isSelected()) {
                licencia.setTipoLicencia("Normal");
                licencia.setPrecio(1100F);
                licencia.setVigencia("3 año");
            } else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar al menos una opción de licencia.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            licencia.setEstado("Activa");
           licencia.setNumeroLicencia(rlb.RegistrarLicencia(licencia));
        } catch (persistenciaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VigenciaLicencia.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        ventana.cambiarVistaLicenciaGenerada(licencia);

    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        ventana.cambiarVistaLicencia();
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void checkBox1100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox1100ActionPerformed
        // TODO add your handling code here:
        checkBox200.setSelected(false);
        checkBox500.setSelected(false);
        checkBox600.setSelected(false);
        checkBox700.setSelected(false);
        checkBox900.setSelected(false);
    }//GEN-LAST:event_checkBox1100ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void checkBox600ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox600ActionPerformed
        // TODO add your handling code here:
        checkBox200.setSelected(false);
        checkBox500.setSelected(false);
        checkBox1100.setSelected(false);
        checkBox700.setSelected(false);
        checkBox900.setSelected(false);
    }//GEN-LAST:event_checkBox600ActionPerformed

    private void checkBox900ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox900ActionPerformed
        // TODO add your handling code here:
        checkBox200.setSelected(false);
        checkBox500.setSelected(false);
        checkBox600.setSelected(false);
        checkBox700.setSelected(false);
        checkBox1100.setSelected(false);
    }//GEN-LAST:event_checkBox900ActionPerformed

    private void checkBox700ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox700ActionPerformed
        // TODO add your handling code here:
        checkBox200.setSelected(false);
        checkBox500.setSelected(false);
        checkBox600.setSelected(false);
        checkBox1100.setSelected(false);
        checkBox900.setSelected(false);
    }//GEN-LAST:event_checkBox700ActionPerformed

    private void checkBox200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox200ActionPerformed
        // TODO add your handling code here:
        checkBox1100.setSelected(false);
        checkBox500.setSelected(false);
        checkBox600.setSelected(false);
        checkBox700.setSelected(false);
        checkBox900.setSelected(false);
    }//GEN-LAST:event_checkBox200ActionPerformed

    private void checkBox500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox500ActionPerformed
        // TODO add your handling code here:
        checkBox200.setSelected(false);
        checkBox1100.setSelected(false);
        checkBox600.setSelected(false);
        checkBox700.setSelected(false);
        checkBox900.setSelected(false);
    }//GEN-LAST:event_checkBox500ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JCheckBox checkBox1100;
    private javax.swing.JCheckBox checkBox200;
    private javax.swing.JCheckBox checkBox500;
    private javax.swing.JCheckBox checkBox600;
    private javax.swing.JCheckBox checkBox700;
    private javax.swing.JCheckBox checkBox900;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
}
