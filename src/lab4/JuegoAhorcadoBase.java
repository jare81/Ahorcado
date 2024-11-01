/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import javax.swing.JOptionPane;


/**
 *
 * @author Laura Sabillon
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado {
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;

    public String inicializarPalabraSecreta(){
        return "_".repeat(palabraSecreta.length());
    }

    public void jugar() {
        while (intentos > 0 && !Ganador()) {
            if (Ganador()) {
                JOptionPane.showMessageDialog(null, "¡Has ganado! La palabra era: " + palabraSecreta);
            } else {
                JOptionPane.showMessageDialog(null, "¡Has perdido! La palabra era: " + palabraSecreta);
            }
        }
    }
    
    public abstract char actualizarPalabraActual(char letra);
    
    public abstract boolean VerificarLetra(char letra);
    
    public abstract boolean Ganador();
}
