package facturacion2v;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgregarCliente extends JFrame {
    // Componentes de la interfaz gráfica
    private JTextField txtCodigo, txtNombre, txtIdentificacion, txtDireccion, txtTelefono, txtCelular, txtEmail, txtTipo, txtStatus;
    private JButton btnGuardar;

    public AgregarCliente() {
        // Configuración inicial del formulario
        setTitle("Ingreso de Clientes");
        setSize(300, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Creación y adición de componentes
        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtIdentificacion = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCelular = new JTextField();
        txtEmail = new JTextField();
        txtTipo = new JTextField();
        txtStatus = new JTextField();
        btnGuardar = new JButton("Guardar Cliente");

        add(new JLabel("Código:"));
        add(txtCodigo);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Identificación:"));
        add(txtIdentificacion);
        add(new JLabel("Dirección:"));
        add(txtDireccion);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(new JLabel("Celular:"));
        add(txtCelular);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Tipo:"));
        add(txtTipo);
        add(new JLabel("Status:"));
        add(txtStatus);
        add(btnGuardar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });

        setVisible(true);
    }

    private void guardarCliente() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String identificacion = txtIdentificacion.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String celular = txtCelular.getText();
        String email = txtEmail.getText();
        String tipo = txtTipo.getText();
        String status = txtStatus.getText();

        // Aquí debes reemplazar con tus datos de conexión
        String url = "jdbc:postgresql://localhost:5432/facturacionsql";
        String usuario = "postgres";
        String contraseña = "123456NumDiabl@654321";

        String sql = "INSERT INTO CLIENTES (CLICODIGO, CLINOMBRE, CLIIDENTIFICACION, CLIDIRECCION, CLITELEFONO, CLICELULAR, CLIEMAIL, CLITIPO, CLISTATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codigo);
            pstmt.setString(2, nombre);
            pstmt.setString(3, identificacion);
            pstmt.setString(4, direccion);
            pstmt.setString(5, telefono);
            pstmt.setString(6, celular);
            pstmt.setString(7, email);
            pstmt.setString(8, tipo);
            pstmt.setString(9, status);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente guardado con éxito.");
            dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new AgregarCliente();
    }
}
