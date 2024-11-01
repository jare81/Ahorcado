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
public class JuegoAhorcadoAzar {
    
    private String palabraE;
    private StringBuilder progreso;
    private ArrayList<String> palabras;
    private AdministrarPalabrasSecretas adminPalabras;
    
    
    
    public JuegoAhorcadoAzar(){
      palabraE="";
      progreso = progreso = new StringBuilder("_".repeat(palabraE.length()));
      
      palabras = new ArrayList<>();
        palabras.add("pie");
        palabras.add("cupcake");
        palabras.add("manzana");
        palabras.add("refresco");
        palabras.add("dulces");
        
         adminPalabras = new AdministrarPalabrasSecretas();
    }
    
     public String obtenerPalabra(){
        Random random = new Random();
        int index = random.nextInt(palabras.size());
        return palabraE = palabras.get(index);
        
        
        
    }
    
     public String seleccionar() {
        palabraE = adminPalabras.selecccionar(); 
        progreso = new StringBuilder("_".repeat(palabraE.length())); 
        return palabraE;
    }

     
     
    public char actualizarPalabraActual(char letra){  
      
      
        for (int i = 0; i < palabraE.length(); i++) {
            if (palabraE.charAt(i) == letra) {
                return letra;
            }
        }

        return 0;  
    }
    
    public boolean VerificarLetra(char letra){
        return palabraE.indexOf(letra) != -1;
        
    }
    
    public  boolean Ganador(){
        return progreso.toString().equals(palabraE);
    }
    
    public String obtenerProgreso() {
        return progreso.toString();
    }
   

    
    
    
}
