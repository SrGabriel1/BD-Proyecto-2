/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Consultas;

import Encriptador.Encriptador;
import Entidades.Persona;
import Entidades.Tramite;
import Excepciones.persistenciaException;
import GUI.ControladorVentana;
import Inegocio.IConsultasBO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.ConsultasBO;

/**
 *
 * @author Ximena
 */
public class PersonasSimilares extends javax.swing.JPanel {

    String nombre, curp;
    Integer anio;
    ControladorVentana ventana;

    /**
     * Creates new form PersonasSimilares
     */
    public PersonasSimilares(ControladorVentana ventana, String nombre, String curp, Integer anio) {
        this.ventana = ventana;
        this.nombre = nombre;
        this.anio = anio;
        this.curp = curp;
        initComponents();
        try {
               tabla();
        } catch (Exception e) {
            System.out.println("que bobis");
        }
     
    }

    public void tabla() throws persistenciaException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Curp");
        modelo.addColumn("RFC");
        modelo.addColumn("Telefono");
        modelo.addColumn("Condicion");
        modelo.addColumn("Fecha de Nacimiento");

        String[] datos = new String[8];
        try {
            IConsultasBO consulta = new ConsultasBO();
            List<Persona> persona = consulta.regresarPersonasSimilares(nombre, curp, anio);
            if (!persona.isEmpty()) {
                for (int i = 0; i < persona.size(); i++) {
                    datos[0] = persona.get(i).getNombre();
                    datos[1] = persona.get(i).getApellido_paterno();
                    datos[2] = persona.get(i).getApellido_materno();
                    datos[3] = persona.get(i).getCURP();
                    datos[4] = persona.get(i).getRFC();
                    Encriptador e = new Encriptador();
                    String telefono = e.desencriptar(persona.get(i).getTelefono());
                    datos[5] = telefono;
                    datos[6] = persona.get(i).getCondicion();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    datos[7] = formato.format(persona.get(i).getFecha_nacimiento().getTime());
                    modelo.addRow(datos);
                }
                tablaSql.setModel(modelo);
            }
        } catch (persistenciaException e) {
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
        txtRFC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaSql.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido P", "Apellido M", "CURP", "RFC", "Telefono", "Condicion", "Fecha Nacimiento"
            }
        ));
        jScrollPane2.setViewportView(tablaSql);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 510, 160));

        txtRFC.setBackground(new java.awt.Color(217, 217, 217));
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });
        add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 170, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Escriba el RFC");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PersonasSimilaresCap.PNG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        botonRegresar.setText("jButton1");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 140, 30));

        botonAceptar.setText("jButton1");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        add(botonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        ventana.cambiarVistaConsulta();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (txtRFC.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Escriba antes el RFC");
        } else {
            
            ventana.cambiarVistaConsultaGenerada(txtRFC.getText());
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaSql;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}