/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dell
 */
//EXTIENDE DE JUEGOAHORACADOBASE
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    private AdministrarPalabrasSecretas ad; 
    private String palabraE;
    private StringBuilder progreso;

    public JuegoAhorcadoAzar(AdministrarPalabrasSecretas adminPalabras) {
        this.ad = adminPalabras; 
        palabraE = "";
        progreso = new StringBuilder("_".repeat(palabraE.length()));

          if (ad.adminPalabras.isEmpty()) {
            ad.adminPalabras.add("cupcake");
            ad.adminPalabras.add("cake");
            ad.adminPalabras.add("sugar");
            ad.adminPalabras.add("red");
            ad.adminPalabras.add("cinammon");
        }

        

    }
    public String obtenerPalabra(){
        ArrayList<String> palabrasActualizadas = ListaPalabras();  
        Random random = new Random();
        int index = random.nextInt(palabrasActualizadas.size());
        return palabraE = palabrasActualizadas.get(index);
}

    public char actualizarPalabraActual(char letra) {  
        for (int indice = 0; indice < palabraE.length(); indice++) {
            if (palabraE.charAt(indice) == letra) {
                return letra;
            }
        }
        return 0;  
    }

    public boolean VerificarLetra(char letra) {
        return palabraE.indexOf(letra) != -1;
    }

    public boolean Ganador() {
        return progreso.toString().equals(palabraE);
    }

    public String obtenerProgreso() {
        return progreso.toString();
    }
   
    public void jugar() {
        super.jugar();
    }
    
    public void setPalabraE(String palabraE){
        this.palabraE=palabraE;
    }

     public ArrayList<String> ListaPalabras() {
        return ad.adminPalabras;
    }
    
}