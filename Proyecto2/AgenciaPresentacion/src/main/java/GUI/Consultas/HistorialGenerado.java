/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Consultas;

import Entidades.Tramite;
import Excepciones.persistenciaException;
import GUI.ControladorVentana;
import Inegocio.IConsultasBO;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ConsultasBO;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class HistorialGenerado extends javax.swing.JPanel {

    String RFC;
    ControladorVentana ventana;

    /**
     * Creates new form HistorialGenerado
     */
    public HistorialGenerado(ControladorVentana ventana, String RFC) {
        this.ventana = ventana;
        this.RFC = RFC;
        initComponents();
        try {
            tabla();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para poblar una tabla con los datos de los trámites consultados.
     * Este método obtiene los trámites asociados a un RFC dado, los cuales son
     * recuperados mediante una consulta a la capa de persistencia. Luego,
     * utiliza un modelo de tabla para mostrar los datos en una tabla en la
     * interfaz gráfica.
     *
     * @throws persistenciaException Si ocurre un error durante la consulta a la
     * capa de persistencia.
     */
    public void tabla() throws persistenciaException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Persona");
        modelo.addColumn("Tramite");
        modelo.addColumn("Fecha de Realizacion");

        String[] datos = new String[3];
        try {
            IConsultasBO consulta = new ConsultasBO();
            List<Tramite> tramite = consulta.ConsultaTramite(RFC);
            System.out.println(tramite.get(0).getPersona());
            if (!tramite.isEmpty()) {
                for (Tramite t : tramite) {
                    datos[0] = t.getPersona().getNombre();
                    datos[1] = t.getTipoTramite();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    datos[2] = formato.format(t.getFechaRealizacion().getTime());
                    modelo.addRow(datos);
                }
                tablaSql.setModel(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSql = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonRegresarMenu = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSql.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Persona", "Tramite", "Fecha de Realizacion"
            }
        ));
        jScrollPane2.setViewportView(tablaSql);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 490, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/HistorialGeneradoCap.PNG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonRegresarMenu.setText("jButton1");
        botonRegresarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarMenuActionPerformed(evt);
            }
        });
        add(botonRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarMenuActionPerformed
        ventana.cambiarVistaMenu();
    }//GEN-LAST:event_botonRegresarMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegresarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaSql;
    // End of variables declaration//GEN-END:variables
}
