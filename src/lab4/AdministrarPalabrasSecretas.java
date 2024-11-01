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
public class AdministrarPalabrasSecretas {
    public ArrayList<String> adminPalabras; 
    
    public AdministrarPalabrasSecretas(){
    adminPalabras = new ArrayList<>();
    
    } 
    
    public boolean agregarNueva(String palabra){
         if (palabra != null && !palabra.isEmpty()) {
            adminPalabras.add(palabra);
            return true; 
        }
        return false; 
    }
    
    public String selecccionar(){
        if (adminPalabras.isEmpty()) {
            return null; 
        }
        Random random = new Random();
        int index = random.nextInt(adminPalabras.size());
        return adminPalabras.get(index);
        
    }
}
