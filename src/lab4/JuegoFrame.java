/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.LineBorder;

public class JuegoFrame extends JFrame {
    private String palabraSecreta;
    private StringBuilder progreso;
    private int intentosRestantes = 6; 
    private JLabel labelPalabra;
    private JTextField campoLetra;
    private JLabel labelIntentos;
    private JLabel labelMensaje;
    private JTextArea areaMuñeco; 

    private final String[] muñecoAhorcado = {
        "  -----  \n" +
        "  |   |  \n" +
        "      |  \n" +
        "      |  \n" +
        "      |  \n" +
        "      |  \n" +
        "=========\n",

        "  -----  \n" +
        "  |   |  \n" +
        "  O   |  \n" +
        "      |  \n" +
        "      |  \n" +
        "      |  \n" +
        "=========\n",

        "  -----  \n" +
        "  |   |  \n" +
        "  O   |  \n" +
        "  |   |  \n" +
        "      |  \n" +
        "      |  \n" +
        "=========\n",

        "  -----  \n" +
        "  |   |  \n" +
        "  O   |  \n" +
        " /|   |  \n" +
        "      |  \n" +
        "      |  \n" +
        "=========\n",

        "  -----  \n" +
        "  |   |  \n" +
        "  O   |  \n" +
        " /|\\  |  \n" +
        "      |  \n" +
        "      |  \n" +
        "=========\n",

        "  -----  \n" +
        "  |   |  \n" +
        "  O   |  \n" +
        " /|\\  |  \n" +
        " /    |  \n" +
        "      |  \n" +
        "=========\n",

        "  -----  \n" +
        "  |   |  \n" +
        "  O   |  \n" +
        " /|\\  |  \n" +
        " / \\  |  \n" +
        "      |  \n" +
        "=========\n"
    };

    public JuegoFrame(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.progreso = new StringBuilder("_".repeat(palabraSecreta.length()));
        this.intentosRestantes = 6; 
        
        setTitle("Juego del Ahorcado");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        

        campoLetra = new JTextField(70);
        campoLetra.setFont(new Font("Arial", Font.PLAIN, 24)); 

        campoLetra.setBorder(new LineBorder(Color.BLACK, 2)); 
        panelSuperior.add(campoLetra);
        
        labelPalabra = new JLabel(progreso.toString());
        labelPalabra.setFont(new Font("Arial", Font.BOLD, 24));
        labelPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        panelSuperior.add(labelPalabra);
        

        labelIntentos = new JLabel("Intentos restantes: " + intentosRestantes);
        panelSuperior.add(labelIntentos);

        labelMensaje = new JLabel("");
        labelMensaje.setForeground(Color.RED);
        panelSuperior.add(labelMensaje);


        JButton botonEnviar = new JButton("Enviar letra");
        panelSuperior.add(botonEnviar);
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLetra();
            }
        });
        
        JButton botonVolver = new JButton("Volver");
        panelSuperior.add(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JuegoFrame.this.setVisible(false);
                new VisualFRAME().setVisible(true);
            }
        });


        areaMuñeco = new JTextArea();
        areaMuñeco.setFont(new Font("Monospaced", Font.PLAIN, 30));
        areaMuñeco.setEditable(false);
        areaMuñeco.setText(muñecoAhorcado[0]); 
        areaMuñeco.setBackground(getBackground());

        add(panelSuperior, BorderLayout.NORTH);
        add(areaMuñeco, BorderLayout.CENTER);
        
        setVisible(true);
    }

    private void procesarLetra() {
        String letra = campoLetra.getText();
        if (letra.length() != 1) {
            JOptionPane.showMessageDialog(this, "Ingresa solo una letra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        char letraIngresada = letra.charAt(0);
        boolean letraEncontrada = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letraIngresada) {
                progreso.setCharAt(i, letraIngresada);
                letraEncontrada = true;
            }
        }

        if (!letraEncontrada) {
            intentosRestantes--;
            labelMensaje.setText("Letra incorrecta.");
            areaMuñeco.setText(muñecoAhorcado[6 - intentosRestantes]); 
        } else {
            labelMensaje.setText("¡Bien hecho!");
        }

        labelPalabra.setText(progreso.toString());
        labelIntentos.setText("Intentos restantes: " + intentosRestantes);

        if (progreso.toString().equals(palabraSecreta)) {
            labelMensaje.setText("¡Has ganado! La palabra era: " + palabraSecreta);
        } else if (intentosRestantes == 0) {
            labelMensaje.setText("¡Has perdido! La palabra era: " + palabraSecreta);
        }

        campoLetra.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JuegoFrame("");
        });
    }
}
