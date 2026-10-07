import java.awt.*;
import javax.swing.*;

public class JPCInterfaz extends JFrame{
    
    JTextField campoOrden;
    JTextField campoCantidad;
    JTextField campoIngredientes;
    JTextField campoTamano;

    JComboBox<String> comboMasa;
    JComboBox<String> comboSalsa;

    JTextArea areaResultado;

    JButton botonPreparar;
    JButton botonLimpiar;

    Cocina cocina;

    public JPCInterfaz() {

        cocina = new Cocina();

        setTitle("Jack Pizza Chef");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("JACK PIZZA CHEF", SwingConstants.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 28));

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel panelDatos = new JPanel();

        panelDatos.setLayout(new GridLayout(6, 2, 10, 10));

        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos de la Orden"));

        panelDatos.add(new JLabel("Numero de Orden:"));
        campoOrden = new JTextField();
        panelDatos.add(campoOrden);

        panelDatos.add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField();
        panelDatos.add(campoCantidad);

        panelDatos.add(new JLabel("Masa:"));
        comboMasa = new JComboBox<>();

        comboMasa.addItem("Delgada");
        comboMasa.addItem("Gruesa");
        comboMasa.addItem("Integral");

        panelDatos.add(comboMasa);

        panelDatos.add(new JLabel("Salsa:"));

        comboSalsa = new JComboBox<>();

        comboSalsa.addItem("Tomate");
        comboSalsa.addItem("BBQ");
        comboSalsa.addItem("Blanca");
        
        panelDatos.add(comboSalsa);

        panelDatos.add(new JLabel("Ingredientes:"));

        campoIngredientes = new JTextField();

        panelDatos.add(campoIngredientes);

        panelDatos.add(new JLabel("Tamaño (pulgadas):"));

        campoTamano = new JTextField();

        panelDatos.add(campoTamano);

        panelPrincipal.add(panelDatos, BorderLayout.CENTER);


        JPanel panelInferior = new JPanel();

        panelInferior.setLayout(

            new BorderLayout(5, 5)

        );


        areaResultado = new JTextArea();

        areaResultado.setEditable(false);

        areaResultado.setBorder(

            BorderFactory.createTitledBorder(

                "Proceso de la cocina"

            )

        );

        JScrollPane scroll = new JScrollPane(areaResultado);

        panelInferior.add(

            scroll,

            BorderLayout.CENTER

        );


        JPanel panelBotones = new JPanel();

        botonPreparar = new JButton("Preparar pizzas");

        botonLimpiar = new JButton("Limpiar");

        panelBotones.add(botonPreparar);

        panelBotones.add(botonLimpiar);

        panelInferior.add(

            panelBotones,

            BorderLayout.SOUTH

        );

        panelPrincipal.add(

            panelInferior,

            BorderLayout.SOUTH

        );


        botonPreparar.addActionListener(e -> prepararOrden());


        botonLimpiar.addActionListener(e -> limpiar());


        add(panelPrincipal);

    }


    public void prepararOrden() {

        try {

            int numeroOrden =

                Integer.parseInt(campoOrden.getText());

            int cantidad =

                Integer.parseInt(campoCantidad.getText());

            int tamaño =

                Integer.parseInt(campoTamano.getText());

            String masa =

                (String) comboMasa.getSelectedItem();

            String salsa =

                (String) comboSalsa.getSelectedItem();

            String ingredientes =

                campoIngredientes.getText();


            Orden orden = new Orden(

                numeroOrden,

                ingredientes,

                cantidad

            );


            areaResultado.setText("");

            areaResultado.append(

                "===== ORDEN =====\n"

            );

            areaResultado.append(

                "Número: " + numeroOrden + "\n"

            );

            areaResultado.append(

                "Cantidad: " + cantidad + "\n"

            );

            areaResultado.append(

                "Masa: " + masa + "\n"

            );

            areaResultado.append(

                "Salsa: " + salsa + "\n"

            );

            areaResultado.append(

                "Ingredientes: " + ingredientes + "\n"

            );

            areaResultado.append(

                "Tamaño: " + tamaño + "\"\n\n"

            );

            cocina.recibirOrden(orden);


            for (int i = 1; i <= cantidad; i++) {

                areaResultado.append(

                    "===== PIZZA #" + i + " =====\n"

                );

                Pizza pizza = new Pizza(

                    masa,

                    salsa,

                    ingredientes,

                    tamaño

                );

                pizza.hacerMasa();

                areaResultado.append(

                    "Haciendo masa: " + masa + "\n"

                );

                pizza.agregarSalsa();

                areaResultado.append(

                    "Agregando salsa: " + salsa + "\n"

                );

                pizza.agregarToppings();

                areaResultado.append(

                    "Agregando: " + ingredientes + "\n"

                );

                pizza.cocinar();

                areaResultado.append(

                    "Cocinando a 420 grados...\n"

                );

                areaResultado.append(

                    "Pizza terminada.\n\n"

                );

            }

            cocina.terminarOrden();

            areaResultado.append(

                "===== ORDEN TERMINADA =====\n"

            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(

                this,

                "Ingrese números válidos en cantidad, orden y tamaño.",

                "Error",

                JOptionPane.ERROR_MESSAGE

            );

        }

    }


    public void limpiar() {
        
        campoOrden.setText("");
        campoCantidad.setText("");
        campoIngredientes.setText("");
        campoTamano.setText("");
        areaResultado.setText("");
        comboMasa.setSelectedIndex(0);
        comboSalsa.setSelectedIndex(0);

    }

    public static void main(String[] args) {

        JPCInterfaz ventana = new JPCInterfaz();

        ventana.setVisible(true);

    }

}