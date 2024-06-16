package facturacion2v;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class FacturaCompletaJFrame extends javax.swing.JFrame {
    private static final String URL = "jdbc:postgresql://localhost:5432/facturacionsql";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456NumDiabl@654321";
    
    public FacturaCompletaJFrame(String factura, String cliente, String fecha) {
        initComponents();   
        jLabelMostrarFACTURAN.setText(factura);
        jLabelMostrarCLIENTE.setText(cliente);
        jLabelMostrarFECHA.setText(fecha);
        cargarProductosEnComboBox();
    }
    
    private void cargarProductosEnComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT PROCODIGO, PRODESCRIPCION FROM PRODUCTOS";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String producto = resultSet.getString("PROCODIGO") + " - " + resultSet.getString("PRODESCRIPCION");
                    model.addElement(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jComboBoxIngresarProducto.setModel(model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelFECHAE = new javax.swing.JLabel();
        jLabelMostrarFACTURAN = new javax.swing.JLabel();
        jLabelFacturaNE = new javax.swing.JLabel();
        jLabelMostrarCLIENTE = new javax.swing.JLabel();
        jLabelCLIENTEE = new javax.swing.JLabel();
        jLabelMostrarFECHA = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelnitems = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelsuma = new javax.swing.JLabel();
        jLabeliva15 = new javax.swing.JLabel();
        jLabeltotal = new javax.swing.JLabel();
        jPanelAgregarProductos = new javax.swing.JPanel();
        jComboBoxIngresarProducto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldIngresarCantidad = new javax.swing.JTextField();
        jButtonAGREGAR = new javax.swing.JButton();
        jComboBoxFormadepago = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButtonGenerarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelFECHAE.setText("FECHA:");

        jLabelMostrarFACTURAN.setText("jLabelMostrarFACTURAN");

        jLabelFacturaNE.setText("FACUTRA N°: ");

        jLabelMostrarCLIENTE.setText("jLabelMostrarCLIENTE");

        jLabelCLIENTEE.setText("CLIENTE:");

        jLabelMostrarFECHA.setText("jLabelMostrarFECHA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacturaNE, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCLIENTEE)
                    .addComponent(jLabelFECHAE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMostrarFACTURAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMostrarFECHA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMostrarCLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFacturaNE)
                    .addComponent(jLabelMostrarFACTURAN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCLIENTEE)
                    .addComponent(jLabelMostrarCLIENTE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFECHAE)
                    .addComponent(jLabelMostrarFECHA))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("AniMe Matrix - MB_EN", 0, 24)); // NOI18N
        jLabel1.setText("LOZADASOFT ");

        jTableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Descripcion", "Uni_Med", "Cantidad", "Val_Uni", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(jTableDetalle);

        jLabel2.setText("Tel: 0963399643");

        jLabel3.setText("Dir: Machala y Fernandez Salvador");

        jLabelnitems.setText(".");

        jLabel4.setText("ITEMS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelnitems)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnitems)
                    .addComponent(jLabel4))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel6.setText("IVA 15%");

        jLabel5.setText("SUMA");

        jLabel7.setText("TOTAL");

        jLabelsuma.setText(".");

        jLabeliva15.setText(".");

        jLabeltotal.setText(".");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelsuma)
                    .addComponent(jLabeliva15)
                    .addComponent(jLabeltotal))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelsuma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabeliva15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabeltotal))
                .addGap(27, 27, 27))
        );

        jPanelAgregarProductos.setBackground(new java.awt.Color(204, 204, 255));

        jComboBoxIngresarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIngresarProductoActionPerformed(evt);
            }
        });

        jLabel8.setText("AGREGAR PRODUCTO");

        jLabel9.setText("Producto:");

        jLabel10.setText("Cantidad:");

        jTextFieldIngresarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIngresarCantidadActionPerformed(evt);
            }
        });

        jButtonAGREGAR.setText("AGREGAR");
        jButtonAGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAGREGARActionPerformed(evt);
            }
        });

        jComboBoxFormadepago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECT", " TARJE", "TRNFE" }));

        jLabel11.setText("Forma de pago:");

        javax.swing.GroupLayout jPanelAgregarProductosLayout = new javax.swing.GroupLayout(jPanelAgregarProductos);
        jPanelAgregarProductos.setLayout(jPanelAgregarProductosLayout);
        jPanelAgregarProductosLayout.setHorizontalGroup(
            jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanelAgregarProductosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAgregarProductosLayout.createSequentialGroup()
                                .addComponent(jComboBoxIngresarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
                            .addGroup(jPanelAgregarProductosLayout.createSequentialGroup()
                                .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIngresarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxFormadepago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAGREGAR)))))
                .addGap(58, 58, 58))
        );
        jPanelAgregarProductosLayout.setVerticalGroup(
            jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgregarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAgregarProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxIngresarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldIngresarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAgregarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxFormadepago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAgregarProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAGREGAR)
                        .addGap(31, 31, 31))))
        );

        jButtonGenerarFactura.setText("GenerarFactura");
        jButtonGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 615, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGenerarFactura, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGenerarFactura))
                    .addComponent(jPanelAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIngresarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIngresarCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIngresarCantidadActionPerformed

    private void jComboBoxIngresarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIngresarProductoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxIngresarProductoActionPerformed

    private void jButtonAGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAGREGARActionPerformed
        // TODO add your handling code here:
        String productoSeleccionado = (String) jComboBoxIngresarProducto.getSelectedItem();
        String[] partes = productoSeleccionado.split(" - ");
        String codigoProducto = partes[0];
        String cantidadTexto = jTextFieldIngresarCantidad.getText();

        if (cantidadTexto.isEmpty()) {
            // Manejar el caso de que no se ingrese una cantidad
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.");
            return;
        }
        
        if (cantidadTexto.isEmpty()) {
            // Manejar el caso de que no se ingrese una cantidad
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.");
            return;
        }
        
        int cantidad = Integer.parseInt(cantidadTexto);

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT PRODESCRIPCION, PROUNIDADMEDIDA, PROPRECIOUM FROM PRODUCTOS WHERE PROCODIGO = '" + codigoProducto + "'";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    String descripcion = resultSet.getString("PRODESCRIPCION");
                    String unidadMedida = resultSet.getString("PROUNIDADMEDIDA");
                    double precioUnitario = resultSet.getDouble("PROPRECIOUM");
                    double subtotal = precioUnitario * cantidad;

                    DefaultTableModel model = (DefaultTableModel) jTableDetalle.getModel();
                    boolean found = false;
                    
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 0).equals(codigoProducto)) {
                            int nuevaCantidad = (int) model.getValueAt(i, 3) + cantidad;
                            double nuevoSubtotal = precioUnitario * nuevaCantidad;
                            model.setValueAt(nuevaCantidad, i, 3);
                            model.setValueAt(nuevoSubtotal, i, 5);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        model.addRow(new Object[]{codigoProducto, descripcion, unidadMedida, cantidad, precioUnitario, subtotal});
                    }
                    
                    actualizarTotales();

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonAGREGARActionPerformed

    private void jButtonGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarFacturaActionPerformed
        // TODO add your handling code here:
        jPanelAgregarProductos.setVisible(false);
        jButtonGenerarFactura.setVisible(false);

        String numeroFactura = jLabelMostrarFACTURAN.getText();
        String nombreCliente = jLabelMostrarCLIENTE.getText(); // Nombre del cliente
        String fechaTexto = jLabelMostrarFECHA.getText(); // Obtener la fecha como cadena
        double subtotal = Double.parseDouble(jLabelsuma.getText().replace(",", "."));
        double iva = Double.parseDouble(jLabeliva15.getText().replace(",", "."));
        double total = Double.parseDouble(jLabeltotal.getText().replace(",", "."));

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Buscar el código de cliente por nombre
            String queryBuscarCliente = "SELECT CLICODIGO FROM CLIENTES WHERE CLINOMBRE = ?";
            try (PreparedStatement psBuscarCliente = connection.prepareStatement(queryBuscarCliente)) {
                psBuscarCliente.setString(1, nombreCliente);
                ResultSet rs = psBuscarCliente.executeQuery();
                if (rs.next()) {
                    String codigoCliente = rs.getString("CLICODIGO");
                    String formaPagoSeleccionada = (String) jComboBoxFormadepago.getSelectedItem(); // Obtener forma de pago seleccionada

                    String queryFactura = "INSERT INTO FACTURAS (FACNUMERO, CLICODIGO, FACFECHA, FACSUBTOTAL,FACDESCUENTO, FACIVA, FACICE, FACFORMAPAGO, FACSTATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(queryFactura)) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date fechaUtil = dateFormat.parse(fechaTexto); // Parsear la cadena de fecha
                        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime()); // Convertir a java.sql.Date

                        preparedStatement.setString(1, numeroFactura);
                        preparedStatement.setString(2, codigoCliente);
                        preparedStatement.setDate(3, fechaSQL); // Establecer la fecha convertida
                        preparedStatement.setDouble(4, subtotal);
                        preparedStatement.setDouble(5, 0); // FACDESCUENTO - valor nulo, se establece como 0
                        preparedStatement.setDouble(6, iva);
                        preparedStatement.setDouble(7, 0); 
                        preparedStatement.setString(8, formaPagoSeleccionada);
                        preparedStatement.setString(9, "ACT");
                        preparedStatement.executeUpdate();
                        } catch (ParseException ex) {
                            Logger.getLogger(FacturaCompletaJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    DefaultTableModel model = (DefaultTableModel) jTableDetalle.getModel();
                    String queryPXF = "INSERT INTO PXF (FACNUMERO, PROCODIGO, PXFCANTIDAD, PXFVALOR, PXFSUBTOTAL, PXFSTATUS) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(queryPXF)) {
                        for (int i = 0; i < model.getRowCount(); i++) {
                            preparedStatement.setString(1, numeroFactura);
                            preparedStatement.setString(2, (String) model.getValueAt(i, 0));
                            preparedStatement.setInt(3, (int) model.getValueAt(i, 3));
                            preparedStatement.setDouble(4, (double) model.getValueAt(i, 4));
                            preparedStatement.setDouble(5, (double) model.getValueAt(i, 5));
                            preparedStatement.setString(6, "ACT");
                            preparedStatement.addBatch();
                        }
                        preparedStatement.executeBatch();
                    }
                // Insertar en FACTURAS con FACICE y FACDESCUENTO

                
                } else {
                    System.out.println("No se encontró el código de cliente para el nombre: " + nombreCliente);
                    // Puedes manejar la situación de cliente no encontrado según tus necesidades
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        capturarYConvertirAPDF();
    }//GEN-LAST:event_jButtonGenerarFacturaActionPerformed
    
 
      private void capturarYConvertirAPDF() {
        try {
            // Capturar la pantalla del JFrame
            BufferedImage image = capturarPantalla(this);

            // Guardar la imagen como archivo temporal
            File tempFile = File.createTempFile("factura_", ".png");
            ImageIO.write(image, "png", tempFile);

            // Convertir la imagen a PDF
            convertirImagenAPDF(tempFile.getAbsolutePath(), "factura.pdf");

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Factura generada como PDF correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar la factura como PDF.");
        }
    }
      
    private BufferedImage capturarPantalla(javax.swing.JFrame frame) {
        try {
            Robot robot = new Robot();
            Rectangle area = new Rectangle(frame.getLocationOnScreen().x, frame.getLocationOnScreen().y,
                    frame.getWidth(), frame.getHeight());
            return robot.createScreenCapture(area);
        } catch (AWTException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void convertirImagenAPDF(String imagePath, String pdfPath) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            BufferedImage image = ImageIO.read(new File(imagePath));
            PDImageXObject pdImage = LosslessFactory.createFromImage(document, image);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImage, 0, 0, PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight());
            contentStream.close();

            document.save(pdfPath);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    private void actualizarTotales() {
        DefaultTableModel model = (DefaultTableModel) jTableDetalle.getModel();
        double suma = 0.0;
        int numeroDeItems = model.getRowCount();


        for (int i = 0; i < model.getRowCount(); i++) {
            suma += (double) model.getValueAt(i, 5);
        }

        double iva = suma * 0.15;
        double total = suma + iva;

        jLabelsuma.setText(String.format("%.2f", suma));
        jLabeliva15.setText(String.format("%.2f", iva));
        jLabeltotal.setText(String.format("%.2f", total));
        jLabelnitems.setText(String.valueOf(numeroDeItems));

    }


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
            java.util.logging.Logger.getLogger(FacturaCompletaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaCompletaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaCompletaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaCompletaJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FactCrearCabecera factCrearCabecera = new FactCrearCabecera();
            factCrearCabecera.mostrarFacturaCompleta("factura", "cliente", "fecha");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAGREGAR;
    private javax.swing.JButton jButtonGenerarFactura;
    private javax.swing.JComboBox<String> jComboBoxFormadepago;
    private javax.swing.JComboBox<String> jComboBoxIngresarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCLIENTEE;
    private javax.swing.JLabel jLabelFECHAE;
    private javax.swing.JLabel jLabelFacturaNE;
    private javax.swing.JLabel jLabelMostrarCLIENTE;
    private javax.swing.JLabel jLabelMostrarFACTURAN;
    private javax.swing.JLabel jLabelMostrarFECHA;
    private javax.swing.JLabel jLabeliva15;
    private javax.swing.JLabel jLabelnitems;
    private javax.swing.JLabel jLabelsuma;
    private javax.swing.JLabel jLabeltotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAgregarProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalle;
    private javax.swing.JTextField jTextFieldIngresarCantidad;
    // End of variables declaration//GEN-END:variables

}
