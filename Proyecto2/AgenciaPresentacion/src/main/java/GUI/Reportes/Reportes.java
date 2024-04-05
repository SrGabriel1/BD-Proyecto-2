/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Reportes;

/**
 *
 * @author Ximena
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
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

        txtCurp = new javax.swing.JTextField();
        comoBoxTipoTramite = new javax.swing.JComboBox<>();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCurp.setBackground(new java.awt.Color(217, 217, 217));
        getContentPane().add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 240, 40));

        comoBoxTipoTramite.setBackground(new java.awt.Color(217, 217, 217));
        comoBoxTipoTramite.setEditable(true);
        comoBoxTipoTramite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comoBoxTipoTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comoBoxTipoTramiteActionPerformed(evt);
            }
        });
        getContentPane().add(comoBoxTipoTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 240, 40));

        txtFecha2.setEditable(false);
        txtFecha2.setBackground(new java.awt.Color(217, 217, 217));
        txtFecha2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        getContentPane().add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 170, 40));

        txtFecha1.setEditable(false);
        txtFecha1.setBackground(new java.awt.Color(217, 217, 217));
        txtFecha1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        getContentPane().add(txtFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ximena\\Documents\\GitHub\\BD-Proyecto-2\\Proyecto2\\AgenciaPresentacion\\src\\main\\resources\\Imagenes\\TramiteReportesCap.PNG")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 452));

        botonRegresar.setText("Regresar");
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 130, 30));

        botonAceptar.setText("Aceptar");
        getContentPane().add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comoBoxTipoTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comoBoxTipoTramiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comoBoxTipoTramiteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JComboBox<String> comoBoxTipoTramite;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    // End of variables declaration//GEN-END:variables
}
