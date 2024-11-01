/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author Laura Sabillon
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    private String palabraSecreta;
    private StringBuilder palabraActual;
    
    public JuegoAhorcadoFijo(String palabra_secreta){
        this.palabraSecreta = palabra_secreta;
        palabraActual = new StringBuilder("_".repeat(palabra_secreta.length()));
    }

    public char actualizarPalabraActual(char letra) {
        if (VerificarLetra(letra)) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    return letra;
                }
            }
        }
        return 0;
    }

    public boolean VerificarLetra(char letra){
       return palabraSecreta.indexOf(letra) != -1;
    }
    
     public String obtenerProgreso() {
        return palabraActual.toString();
    }
    
    public boolean Ganador(){
      return obtenerProgreso().equals(palabraSecreta);
        
    }
}
