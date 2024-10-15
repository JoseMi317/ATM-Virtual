package Frontend.ATMVirtual.MainPage;

import javax.swing.*;

import Backend.Class.Prestamos.Prestamos;
import Frontend.ATMVirtual.PrestamosPage.PrestamosPage;
import Frontend.ATMVirtual.TransaccionesPage.TransaccionesPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class MainPage extends JFrame {

     private static JFrame frame;
    JLabel label1, label2, label3;
    JButton button1, button2, button3;
    private final Preferences prefs;

    public MainPage() {
        prefs = Preferences.userRoot().node("ATM");
        setTitle("Cuenta Bancaria de " + prefs.get("user", ""));
        // Configuraciones de la ventana
        setSize(850, 550); // Tamaño de la ventana
        setLocation(450, 150); // Ubicación de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana

        setLayout(null);

        // Imagen Fondo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/prueba.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 550);
        add(image);

        // Cuadro blanco transparente
        JPanel cuadroPanel = new JPanel();
        cuadroPanel.setLayout(null);
        cuadroPanel.setBounds(160, 100, 500, 300);
        cuadroPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadroPanel.setBackground(new Color(255, 255, 255, 200));
        image.add(cuadroPanel); // Añadir cuadroPanel al fondo (imagen)

        // Etiqueta No. Cuenta
        JLabel noCuentaLabel = new JLabel("No. Cuenta:");
        noCuentaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        noCuentaLabel.setBounds(20, 20, 200, 30);
        cuadroPanel.add(noCuentaLabel);

        // Etiqueta Tipo de Cuenta
        JLabel tipoCuentaLabel = new JLabel("Tipo de Cuenta:");
        tipoCuentaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tipoCuentaLabel.setBounds(20, 70, 200, 30);
        cuadroPanel.add(tipoCuentaLabel);

        // Etiqueta Saldo Actual
        JLabel saldoActual = new JLabel("Saldo actual:");
        saldoActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
        saldoActual.setBounds(20, 130, 200, 30);
        cuadroPanel.add(saldoActual);

        // Botón Realizar Transacción
        JButton button1 = new JButton("Transferir");
        button1.setForeground(Color.white);
        button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button1.setBackground(new Color(48, 44, 44));
        button1.setBounds(250, 250, 200, 40);
        button1.addActionListener(e -> abrirTransacciones());
        cuadroPanel.add(button1);

        // Botón Solicitar Préstamo
        JButton button2 = new JButton("Solicitar Préstamo");
        button2.setForeground(Color.white);
        button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button2.setBackground(new Color(48, 44, 44));
        button2.setBounds(20, 250, 200, 40);
        button2.addActionListener(e -> abrirPrestamos());
        cuadroPanel.add(button2);

        // Botón Salir (en la esquina superior derecha)
        JButton button3 = new JButton("Salir");
        button3.setForeground(Color.red);
        button3.setFont(new Font("Tahoma", Font.PLAIN, 21));
        button3.setBackground(new Color(17, 204, 149));
        button3.setBounds(725, 10, 100, 40);
        image.add(button3);

    }

    private void abrirTransacciones() {
        TransaccionesPage transacciones = new TransaccionesPage();
        transacciones.setVisible(true);  // Mostrar la nueva ventana
        setVisible(false);
    }

    private void abrirPrestamos() {
        PrestamosPage prestamos = new PrestamosPage();
        prestamos.setVisible(true);
        setVisible(false);
    }


    public static void main(String[] args) {

        // Crear la instancia de la ventana
        MainPage ventana = new MainPage();
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
    
}

