/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dell
 */
public class VisualFRAME extends JFrame {

    private AdministrarPalabrasSecretas adminP = new AdministrarPalabrasSecretas();
    public JuegoAhorcadoAzar juego = new JuegoAhorcadoAzar(adminP); 
    private String palabraIngresada;
    private JLabel labelPalabra;
    private JuegoAhorcadoFijo juegoFijo;

    public VisualFRAME() {
        
        setTitle("Ventana con Botones Centrados");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 70));

        JButton azar = new JButton("Jugar con palabras al azar");
        
        JButton fijas = new JButton("Jugar con palabras fijas");
        JButton admin = new JButton("Administrar palabras secretas");

        azar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        azar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame gameFrame = new JFrame("Juego Ahorcado");
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setSize(400, 300);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.dispose();

                
                String secreta = juego.obtenerPalabra();
                new JuegoFrame(secreta).setVisible(true);

                VisualFRAME.this.setVisible(false);
            }
        });

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        fijas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                palabraIngresada = JOptionPane.showInputDialog(VisualFRAME.this, "Ingresa una palabra:");

                if (palabraIngresada != null && !palabraIngresada.trim().isEmpty()) {
                    juegoFijo = new JuegoAhorcadoFijo(palabraIngresada);

                    new JuegoFrame(palabraIngresada).setVisible(true);

                    VisualFRAME.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(VisualFRAME.this, "No ingresaste ninguna palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame adminFrame = new JFrame("Ingresar o Escoger palabras");
                adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                adminFrame.setSize(400, 300);
                adminFrame.setLocationRelativeTo(null);

                JButton agregar = new JButton("Agregar Palabra");
                JButton escoger = new JButton("Escoger Palabra");
                JButton volver = new JButton("Volver");

                agregar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JTextField textField = new JTextField(20);
                        int option = JOptionPane.showConfirmDialog(null, textField, "Ingrese Palabra", JOptionPane.OK_CANCEL_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            String input = textField.getText().toLowerCase();
                            adminP.agregarNueva(input);
                          
                            

                        }
                    }
                });

               
               
              escoger.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    ArrayList<String> palabras = juego.ListaPalabras();
                    String[] lista = palabras.toArray(new String[0]);

                    JList<String> list = new JList<>(lista);
                    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    list.setVisibleRowCount(5);

                    JScrollPane scrollPane = new JScrollPane(list);

                    int option = JOptionPane.showConfirmDialog(null, scrollPane, "Escoger Palabra", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (option == JOptionPane.OK_OPTION) {
                        String palabraSeleccionada = list.getSelectedValue();

                        if (palabraSeleccionada != null) {
                            juego.setPalabraE(palabraSeleccionada);
                            new JuegoFrame(palabraSeleccionada).setVisible(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, selecciona una palabra antes de continuar.");
                        }
                    }
                }
            });

                volver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        adminFrame.setVisible(false);
                        VisualFRAME.this.setVisible(true);
                    }
                });

                adminFrame.setLayout(new BoxLayout(adminFrame.getContentPane(), BoxLayout.Y_AXIS));
                adminFrame.add(agregar);
                adminFrame.add(escoger);
                adminFrame.add(volver);

                agregar.setAlignmentX(Component.CENTER_ALIGNMENT);
                escoger.setAlignmentX(Component.CENTER_ALIGNMENT);
                volver.setAlignmentX(Component.CENTER_ALIGNMENT);

                adminFrame.setVisible(true);
                VisualFRAME.this.setVisible(false);
            }
        });

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel.add(azar);
        panel.add(fijas);
        panel.add(admin);
        add(panel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VisualFRAME ventana = new VisualFRAME();
            ventana.setVisible(true);
        });
    }

}
