
package facturacion2v;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class FactCrearCabecera extends JFrame{
    private JLabel labelFacturaNo;
    private JTextField textFacturaNo;
    private JLabel labelCliente;
    private JTextField textCliente;
    private JLabel labelFecha;
    private JButton buttonClienteNuevo;
    private JButton buttonGenerarCabecera;
    private JLabel labelFechaValor; // Declare it here
    private Connection conn;

    public FactCrearCabecera() {
        super("Facturación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labelFacturaNo = new JLabel("Factura No:");
        labelFacturaNo.setBounds(10, 10, 100, 20);
        add(labelFacturaNo);

        textFacturaNo = new JTextField();
        textFacturaNo.setBounds(120, 10, 150, 25);
        add(textFacturaNo);

        labelCliente = new JLabel("Cliente:");
        labelCliente.setBounds(10, 40, 100, 25);
        add(labelCliente);

        textCliente = new JTextField();
        textCliente.setBounds(120, 40, 150, 25);
        add(textCliente);

        labelFecha = new JLabel("Fecha:");
        labelFecha.setBounds(10, 70, 100, 25);
        add(labelFecha);

        labelFechaValor = new JLabel();
        labelFechaValor.setBounds(120, 70, 150, 25);
        add(labelFechaValor);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    Date fechaActual = new Date();
                    String fechaFormateada = new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
                    labelFechaValor.setText(fechaFormateada);
                }
            }
        }).start();

        buttonClienteNuevo = new JButton("Cliente Nuevo");
        buttonClienteNuevo.setBounds(10, 100, 120, 20);
        add(buttonClienteNuevo);
        buttonClienteNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FactCrearCabecera.this, "Necesita otro usuario");
                UserJFrame userFrame = new UserJFrame();
                userFrame.setVisible(true);
                dispose();
            }
        });

        buttonGenerarCabecera = new JButton("Generar Cabecera");
        buttonGenerarCabecera.setBounds(140, 100, 150, 20);
        add(buttonGenerarCabecera);
        buttonGenerarCabecera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    generarCabecera();
                } catch (ClassNotFoundException ex) {
                    
                    Logger.getLogger(FactCrearCabecera.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(FactCrearCabecera.this, "Error al generar la cabecera de la factura");
                    // Limpia los campos que contienen datos incorrectos
                    textFacturaNo.setText("");
                    textCliente.setText("");
                }
            }
        });

        setSize(325, 200);
        setVisible(true);

        // Conectar a la base de datos
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/facturacionsql", "postgres", "123456NumDiabl@654321");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
    }

    private void generarCabecera() throws ClassNotFoundException {
        try{
        // Obtener los valores del formulario
        String facturaNo = textFacturaNo.getText();
        String clienteCodigo = textCliente.getText();
        

        // Verificar si la factura es nueva
        if (!verificarFactura(facturaNo)) {
            javax.swing.JOptionPane.showMessageDialog(this, "La factura ya existe");
            textFacturaNo.setText("");
            return;
        }

        // Verificar si el cliente es válido
        if (!verificarCliente(clienteCodigo)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente inválido");
            textCliente.setText("");
            return;
        }
        
            // Si ambos son válidos, entonces cerramos el JFrame y abrimos la siguiente ventana
        dispose();
        String fecha = labelFechaValor.getText();
        openFacturaCompletaFrame(facturaNo, clienteCodigo, fecha);
        // Generar la cabecera de la factura
        // ...
        } catch (Exception ex) {
        Logger.getLogger(FactCrearCabecera.class.getName()).log(Level.SEVERE, "Error general", ex);
        JOptionPane.showMessageDialog(this, "Error inesperado");
    }
         
       
    }

    private boolean verificarFactura(String facturaNo) {
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM facturas WHERE facnumero = ?")) {
            pstmt.setString(1, facturaNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                return !rs.next();
            }
        } catch (SQLException ex) {
            System.err.println("Error al verificar factura: " + ex.getMessage());
            return false;
        }
    }

    private boolean verificarCliente(String clienteNombre) {
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clientes WHERE clinombre = ?")) {
            pstmt.setString(1, clienteNombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            System.err.println("Error al verificar cliente: " + ex.getMessage());
            return false;
        }
    }

    private void openFacturaCompletaFrame(String factura, String cliente, String fecha) {
        FacturaCompletaJFrame facturaCompletaFrame = new FacturaCompletaJFrame(factura, cliente, fecha);
        facturaCompletaFrame.setVisible(true);
    }
    
    public void mostrarFacturaCompleta(String factura, String cliente, String fecha) {
        openFacturaCompletaFrame(factura, cliente, fecha);
    }
    
    public static void main(String[] args) {
        new FactCrearCabecera();
    }
}
