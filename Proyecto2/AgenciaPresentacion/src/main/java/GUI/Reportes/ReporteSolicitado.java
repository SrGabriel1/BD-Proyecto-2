/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Reportes;

import Entidades.Tramite;
import Excepciones.persistenciaException;
import GUI.ControladorVentana;
import Inegocio.IConsultasBO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ConsultasBO;

/**
 *
 * @author Yohan Gabriel Melendrez Leal - 244907
 * @author Jesus Francisco Tapia Maldonado - 245136
 * @author Ximena Oliva Andrade - 247563
 */
public class ReporteSolicitado extends javax.swing.JPanel {

    ControladorVentana ventana;
    String nombre, tipo;
    Calendar desde, hasta;

    /**
     * Creates new form ReporteSolicitado
     */
    public ReporteSolicitado(ControladorVentana ventana, String nombre, String tipo, Calendar desde, Calendar hasta) {
        this.ventana = ventana;
        this.nombre = nombre;
        this.tipo = tipo;
        this.desde = desde;
        this.hasta = hasta;
        initComponents();
        try {
            tabla();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para poblar una tabla con los datos de los trámites realizados
     * dentro de un rango de fechas y un tipo de trámite específico. Este método
     * consulta a la capa de negocio para obtener una lista de trámites que
     * coinciden con los criterios de nombre, tipo de trámite, fecha de inicio y
     * fecha de fin proporcionados. Luego, utiliza un modelo de tabla para
     * mostrar estos datos en una tabla en la interfaz gráfica.
     *
     * @throws persistenciaException Si ocurre un error durante la consulta a la
     * capa de persistencia.
     */
    public void tabla() throws persistenciaException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Persona");
        modelo.addColumn("Tramite");
        modelo.addColumn("Fecha de Realizacion");
        modelo.addColumn("costo");

        String[] datos = new String[4];
        try {
            IConsultasBO consulta = new ConsultasBO();
            List<Tramite> tramite = consulta.ConsultaConTipo(nombre, tipo, desde, hasta);
            System.out.println(tramite.get(0).getPersona());
            if (!tramite.isEmpty()) {
                for (Tramite t : tramite) {
                    datos[0] = t.getPersona().getNombre();
                    datos[1] = t.getTipoTramite();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    datos[2] = formato.format(t.getFechaRealizacion().getTime());
                    datos[3] = Float.toString(t.getCosto());
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
        jLabel2 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSql.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Persona", "Tramite", "Fecha de Realizacion", "Costo"
            }
        ));
        jScrollPane2.setViewportView(tablaSql);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 490, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        botonAceptar.setBorderPainted(false);
        botonAceptar.setContentAreaFilled(false);
        botonAceptar.setFocusPainted(false);
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 140, 50));

        botonCancelar.setBorderPainted(false);
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.setFocusPainted(false);
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        ventana.cambiarVistaReporteGenerado();

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        ventana.cambiarVistaTramiteReporte();
    }//GEN-LAST:event_botonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaSql;
    // End of variables declaration//GEN-END:variables
}
