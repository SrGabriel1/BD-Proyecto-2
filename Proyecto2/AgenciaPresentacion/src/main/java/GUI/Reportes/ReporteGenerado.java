/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Reportes;

import com.google.protobuf.compiler.PluginProtos;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ximena
 */
public class ReporteGenerado extends javax.swing.JFrame {

    ReporteGenerado reporte;
   Connection conexionReporte;
//     conexionReporte = DriverManager.getConnection("jdbc:mysql://localhost:3306/Agencia","root", "233300515");
    /**
     * Creates new form Reporte
     */
    public ReporteGenerado() {
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

        jLabel2 = new javax.swing.JLabel();
        botonRegresarMenu = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ximena\\Documents\\GitHub\\BD-Proyecto-2\\Proyecto2\\AgenciaPresentacion\\src\\main\\resources\\Imagenes\\ReporteExitosoCap.PNG")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonRegresarMenu.setText("a");
        getContentPane().add(botonRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 230, 30));

        botonImprimir.setText("jButton1");
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(botonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 384, 230, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        JasperPrint jp;
        try {
            jp = reporte.reportesTramites();
            JasperViewer.viewReport(jp);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteGenerado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReporteGenerado.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_botonImprimirActionPerformed

    public JasperPrint reportesTramites() throws SQLException, JRException{
       conexionReporte = DriverManager.getConnection("jdbc:mysql://localhost:3306/Agencia","root", "233300515");
        File reporte = new File(getClass().getResource("/reportes/ReporteAF.jasper").getFile());
        if(!reporte.exists()){
            return null;
        }
       try {
           InputStream is = new BufferedInputStream(new FileInputStream(reporte.getAbsoluteFile()));
           JasperReport jr = (JasperReport) JRLoader.loadObject(is);
           JasperPrint jp = JasperFillManager.fillReport(jr, null, conexionReporte);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(ReporteGenerado.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    
    
    
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Reporte().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonRegresarMenu;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}