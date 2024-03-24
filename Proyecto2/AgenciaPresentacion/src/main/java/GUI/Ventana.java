package GUI;

import GUI.Licencia.LicenciaGenerada;
import GUI.Licencia.TramiteLicenciaMenu;
import GUI.Licencia.VigenciaLicencia;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * La clase Ventana representa la ventana principal de la aplicación bancaria.
 * Se encarga de gestionar la navegación entre diferentes vistas de la interfaz
 * de usuario, así como de interactuar con el usuario mediante ventanas
 * emergentes. También mantiene instancias de DTOs y una conexión a la base de
 * datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesús Roberto García Armenta - 244913
 */
public class Ventana extends javax.swing.JFrame {

    private JPanel panelActual;

    /**
     * Constructor de la clase Ventana.
     */
    public Ventana() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agencia");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(526, 400));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Método para limpiar el contenido de la ventana. Si hay un panel
     * actualmente mostrado, lo elimina de la ventana.
     */
    public void limpiarFrame() {
        if (panelActual != null) {
            this.remove(panelActual);
            panelActual = null;
        }
    }

    /**
     * Método para cambiar a la vista de la ventana de Inicio. Este método
     * elimina el panel actual
     */
    public void cambiarVistaMenu() {
        limpiarFrame();
        Menu vistaMenu = new Menu(this);
        ponerEnJFrame(vistaMenu);
        panelActual = vistaMenu;
    }

    /**
     * Método para cambiar a la vista de la ventana de Carrito . Este método
     * elimina el panel actual
     */
    public void cambiarVistaVigencia() {
        limpiarFrame();
        VigenciaLicencia vistaVigencia = new VigenciaLicencia(this);
        ponerEnJFrame(vistaVigencia);
        panelActual = vistaVigencia;
    }

    public void cambiarVistaLicenciaGenerada() {
        limpiarFrame();
        LicenciaGenerada vistaLicenciaGenerada = new LicenciaGenerada(this);
        ponerEnJFrame(vistaLicenciaGenerada);
        panelActual = vistaLicenciaGenerada;
    }

    /**
     * Método para cambiar a la vista de la ventana de MetodoPago . Este método
     * elimina el panel actual
     */
    public void cambiarVistaLicencia() {
        limpiarFrame();
        TramiteLicenciaMenu vistaLicencia = new TramiteLicenciaMenu(this);
        ponerEnJFrame(vistaLicencia);
        panelActual = vistaLicencia;
    }

    /**
     * Método para agregar un panel a la ventana. Este método agrega el panel
     * especificado a la ventana, lo posiciona y ajusta su tamaño
     * automáticamente.
     *
     * @param panel El panel que se va a agregar a la ventana.
     */
    public void ponerEnJFrame(JPanel panel) {
        // Se obtiene el tamaño preferido del panel
        Dimension panelSize = panel.getPreferredSize();

        // Se agrega un margen adicional para garantizar que el panel se muestre completamente
        int margin = 18; // Puedes ajustar este valor según sea necesario
        panelSize.width += margin;
        panelSize.height += margin;

        setPreferredSize(panelSize);

        setLocationRelativeTo(null);

        setContentPane(panel);

        pack();

        setVisible(true);
    }

    /**
     * Método para mostrar un aviso al usuario mediante una ventana emergente.
     *
     * @param mensaje El mensaje a mostrar en el aviso.
     */
    public void mostrarAviso(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Método para mostrar una ventana emergente de confirmación al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana de confirmación.
     * @param titulo El título de la ventana de confirmación.
     * @return true si el usuario selecciona "OK", false si selecciona
     * "Cancelar".
     */
    public boolean mostrarConfirmacion(String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.OK_CANCEL_OPTION);
        return respuesta == JOptionPane.OK_OPTION;
    }

    /**
     * Método para mostrar una ventana emergente de información al usuario.
     *
     * @param mensaje El mensaje a mostrar en la ventana de información.
     * @param titulo El título de la ventana de información.
     */
    public void mostrarInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}
