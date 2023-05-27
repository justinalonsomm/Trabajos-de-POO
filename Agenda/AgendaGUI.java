import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendaGUI {
    private ArrayList<Contacto> listaContactos = new ArrayList<>();
    private ArrayList<Evento> listaEventos = new ArrayList<>();

    private JFrame frame;
    private JButton guardarContactoButton;
    private JButton guardarEventoButton;
    private JButton mostrarDatosButton;

    public AgendaGUI() {
        // Crear la ventana principal
        frame = new JFrame("Agenda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Crear los botones
        guardarContactoButton = new JButton("Guardar Contacto");
        guardarEventoButton = new JButton("Guardar Evento");
        mostrarDatosButton = new JButton("Mostrar Datos");

        // Configurar los botones
        guardarContactoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGuardarContacto();
            }
        });

        guardarEventoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGuardarEvento();
            }
        });

        mostrarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });

        // Agregar los botones al panel principal
        JPanel panel = new JPanel();
        panel.add(guardarContactoButton);
        panel.add(guardarEventoButton);
        panel.add(mostrarDatosButton);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private void abrirVentanaGuardarContacto() {
        JFrame ventanaContacto = new JFrame("Guardar Contacto");
        ventanaContacto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaContacto.setSize(300, 200);
        ventanaContacto.setLayout(new GridLayout(4, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();

        JLabel numeroLabel = new JLabel("Número Telefónico:");
        JTextField numeroField = new JTextField();

        JLabel relacionLabel = new JLabel("Relación:");
        JTextField relacionField = new JTextField();

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String numero = numeroField.getText();
                String relacion = relacionField.getText();

                Contacto contacto = new Contacto(nombre, numero, relacion);
                listaContactos.add(contacto);

                ventanaContacto.dispose();
            }
        });

        ventanaContacto.add(nombreLabel);
        ventanaContacto.add(nombreField);
        ventanaContacto.add(numeroLabel);
        ventanaContacto.add(numeroField);
        ventanaContacto.add(relacionLabel);
        ventanaContacto.add(relacionField);
        ventanaContacto.add(guardarButton);

        ventanaContacto.setVisible(true);
    }

    private void abrirVentanaGuardarEvento() {
        JFrame ventanaEvento = new JFrame("Guardar Evento");
        ventanaEvento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaEvento.setSize(300, 200);
        ventanaEvento.setLayout(new GridLayout(5, 2));

        JLabel tipoLabel = new JLabel("Tipo de Evento:");
        JTextField tipoField = new JTextField();

        JLabel fechaLabel = new JLabel("Fecha:");
        JTextField fechaField = new JTextField();

        JLabel horaLabel = new JLabel("Hora:");
        JTextField horaField = new JTextField();

        JLabel lugarLabel = new JLabel("Lugar:");
        JTextField lugarField = new JTextField();

        JLabel descripcionLabel = new JLabel("Descripción:");
        JTextField descripcionField = new JTextField();

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipo = tipoField.getText();
                String fecha = fechaField.getText();
                String hora = horaField.getText();
                String lugar = lugarField.getText();
                String descripcion = descripcionField.getText();

                Evento evento = new Evento(tipo, fecha, hora, lugar, descripcion);
                listaEventos.add(evento);

                ventanaEvento.dispose();
            }
        });

        ventanaEvento.add(tipoLabel);
        ventanaEvento.add(tipoField);
        ventanaEvento.add(fechaLabel);
        ventanaEvento.add(fechaField);
        ventanaEvento.add(horaLabel);
        ventanaEvento.add(horaField);
        ventanaEvento.add(lugarLabel);
        ventanaEvento.add(lugarField);
        ventanaEvento.add(descripcionLabel);
        ventanaEvento.add(descripcionField);
        ventanaEvento.add(guardarButton);

        ventanaEvento.setVisible(true);
    }

    private void mostrarDatos() {
        JFrame ventanaMostrar = new JFrame("Datos Guardados");
        ventanaMostrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaMostrar.setSize(500, 300);
        ventanaMostrar.setLayout(new GridLayout(2, 1));

        JTextArea contactosTextArea = new JTextArea();
        contactosTextArea.setEditable(false);
        contactosTextArea.append("Contactos:\n");
        for (Contacto contacto : listaContactos) {
            contactosTextArea.append(contacto.toString() + "\n");
        }

        JTextArea eventosTextArea = new JTextArea();
        eventosTextArea.setEditable(false);
        eventosTextArea.append("Eventos:\n");
        for (Evento evento : listaEventos) {
            eventosTextArea.append(evento.toString() + "\n");
        }

        ventanaMostrar.add(new JScrollPane(contactosTextArea));
        ventanaMostrar.add(new JScrollPane(eventosTextArea));

        ventanaMostrar.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AgendaGUI();
            }
        });
    }
}