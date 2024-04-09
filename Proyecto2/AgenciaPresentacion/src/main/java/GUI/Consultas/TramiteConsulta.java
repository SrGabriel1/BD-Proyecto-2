/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Consultas;

import GUI.ControladorVentana;
import javax.swing.JOptionPane;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class TramiteConsulta extends javax.swing.JPanel {

    ControladorVentana ventana;

    /**
     * Creates new form TramiteHistorial
     */
    public TramiteConsulta(ControladorVentana ventana) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtAnioNacimiento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAnioNacimiento.setBackground(new java.awt.Color(217, 217, 217));
        txtAnioNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioNacimientoActionPerformed(evt);
            }
        });
        add(txtAnioNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 160, 30));

        txtNombre.setBackground(new java.awt.Color(217, 217, 217));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 160, 30));

        txtCURP.setBackground(new java.awt.Color(217, 217, 217));
        txtCURP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPActionPerformed(evt);
            }
        });
        add(txtCURP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TramiteHistorialCap.PNG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonRegresar.setBorderPainted(false);
        botonRegresar.setContentAreaFilled(false);
        botonRegresar.setFocusPainted(false);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 130, 30));

        botonAceptar.setText("jButton1");
        botonAceptar.setBorderPainted(false);
        botonAceptar.setContentAreaFilled(false);
        botonAceptar.setDefaultCapable(false);
        botonAceptar.setFocusPainted(false);
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCURPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtAnioNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioNacimientoActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (txtNombre.getText().isEmpty() && txtCURP.getText().isEmpty() && txtAnioNacimiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese minimo un valor");
            return;
        }
        try {
            ventana.cambiarVistaPersonasSimilares(txtNombre.getText(), txtCURP.getText(), Integer.parseInt(txtAnioNacimiento.getText()));

        } catch (NumberFormatException e) {
            ventana.cambiarVistaPersonasSimilares(txtNombre.getText(), txtCURP.getText(), null);
        }

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        ventana.cambiarVistaMenu();
    }//GEN-LAST:event_botonRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtAnioNacimiento;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
