/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Licencia;

import GUI.Ventana;

/**
 *
 * @author yohan
 */
public class VigenciaLicencia extends javax.swing.JPanel {

    private Ventana ventana;

    /**
     * Creates new form VigenciaLicencia1
     */
    public VigenciaLicencia() {
        initComponents();
    }
 public VigenciaLicencia(Ventana ventana) {
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

        CheckBox3anios = new javax.swing.JCheckBox();
        CheckBox1anio1 = new javax.swing.JCheckBox();
        CheckBox2anios = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        BotonAceptar = new javax.swing.JButton();
        BotonRegresar = new javax.swing.JButton();

        CheckBox3anios.setBackground(new java.awt.Color(217, 217, 217));
        CheckBox3anios.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        CheckBox3anios.setText("3 Años");

        CheckBox1anio1.setBackground(new java.awt.Color(217, 217, 217));
        CheckBox1anio1.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        CheckBox1anio1.setText("1 Año");
        CheckBox1anio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox1anio1ActionPerformed(evt);
            }
        });

        CheckBox2anios.setBackground(new java.awt.Color(217, 217, 217));
        CheckBox2anios.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        CheckBox2anios.setText("2 Años");
        CheckBox2anios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox2aniosActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TablaVigenciaCap.PNG"))); // NOI18N

        BotonAceptar.setBorderPainted(false);
        BotonAceptar.setContentAreaFilled(false);
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        BotonRegresar.setBorderPainted(false);
        BotonRegresar.setContentAreaFilled(false);
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(CheckBox1anio1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(CheckBox2anios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(CheckBox3anios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(150, 150, 150)
                            .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(CheckBox1anio1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(CheckBox2anios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(CheckBox3anios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBox2aniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox2aniosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox2aniosActionPerformed

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
ventana.cambiarVistaLicenciaGenerada();
    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
ventana.cambiarVistaLicencia();
    }//GEN-LAST:event_BotonRegresarActionPerformed

    private void CheckBox1anio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox1anio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBox1anio1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JCheckBox CheckBox1anio1;
    private javax.swing.JCheckBox CheckBox2anios;
    private javax.swing.JCheckBox CheckBox3anios;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
