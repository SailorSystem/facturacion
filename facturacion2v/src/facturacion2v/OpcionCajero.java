
package facturacion2v;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OpcionCajero extends JFrame{
    public OpcionCajero() {
        // Crear el frame
        setTitle("Gestión de Facturas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        setLocationRelativeTo(null);

        // Crear el label
        JLabel preguntaLabel = new JLabel("¿Qué desea hacer?");
        preguntaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(preguntaLabel);

        // Crear los botones
        JButton verFacturasBtn = new JButton("Ver Facturas");
        verFacturasBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton crearFacturaBtn = new JButton("Crear Factura");
        crearFacturaBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Agregar los botones al frame
        add(verFacturasBtn);
        add(crearFacturaBtn);

        // Definir las acciones para los botones
        verFacturasBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instanciar y mostrar el JFrame para "Ver Facturas"
                FactReadJFrame facturasReadFrame = new FactReadJFrame();
                facturasReadFrame.setVisible(true);
                dispose(); 
            }
        });

        crearFacturaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instanciar y mostrar el JFrame para "Crear Factura"
                FactCrearCabecera facturaCreateCabeceraFrame = new FactCrearCabecera();
                facturaCreateCabeceraFrame.setVisible(true);
                
                
               dispose(); 

            }
        });
        
        // Hacer el frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OpcionCajero();
            }
        });
    }
    
}
