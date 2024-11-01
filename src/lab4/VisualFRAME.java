/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dell
 */
public class VisualFRAME extends JFrame {

    private String palabraIngresada;
    private JLabel labelPalabra;
    private JuegoAhorcadoFijo juegoFijo;
     private JList<String> palabrasList;
    private AdministrarPalabrasSecretas adminPalabras;



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

                    JuegoAhorcadoAzar azar = new JuegoAhorcadoAzar();
                    String secreta = azar.obtenerPalabra();
                    new JuegoFrame(secreta).setVisible(true);

                    VisualFRAME.this.setVisible(false);
            }
        });

        
        
        
                admin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Administrar");
                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);

                JButton seleccionarButton = new JButton("Seleccionar");
                seleccionarButton.setBounds(50, 30, 200, 30); 

                JButton agregarButton = new JButton("Agregar");
                agregarButton.setBounds(50, 70, 200, 30);
                
                JButton volverButton = new JButton("Volver");
                volverButton.setBounds(50, 110, 200, 30); 


                seleccionarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lógica al hacer clic en "Seleccionar"
                  
                
                
                
                    }
                    
                    
                    
                    
                });


            agregarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica al hacer clic en "Agregar"
                    JOptionPane.showMessageDialog(frame, "Agregar clickeado!");
                    
                    
                }
            });
        
        
             volverButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Cierra el mini frame al hacer clic en "Volver"
                    }
                });


            frame.add(seleccionarButton);
            frame.add(agregarButton);
            frame.add(volverButton);


            frame.setVisible(true);

                }
            });
                
                
                

        fijas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                palabraIngresada = JOptionPane.showInputDialog(VisualFRAME.this, "Ingresa una palabra:");

                if (palabraIngresada != null && !palabraIngresada.trim().isEmpty()) {
                    juegoFijo = new JuegoAhorcadoFijo(palabraIngresada);

                    JFrame gameFrame = new JFrame("Juego Ahorcado");
                    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameFrame.setSize(400, 300);
                    gameFrame.setLocationRelativeTo(null);
                    gameFrame.dispose();


                    new JuegoFrame(palabraIngresada).setVisible(true);

                    VisualFRAME.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(VisualFRAME.this, "No ingresaste ninguna palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
