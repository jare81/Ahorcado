/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author Dell
 */
public class JuegoAhorcadoFijo {
    private String palabraSecreta;
    private StringBuilder palabraActual;
    private int intentos;
    
    public JuegoAhorcadoFijo(String palabra_secreta){
        this.palabraSecreta = palabra_secreta;
         this.palabraActual = new StringBuilder("_".repeat(palabra_secreta.length()));
         this.intentos = 6;
    }
    
    public char actualizarPalabraActual(char letra){
       /* String letter = Integer.toString(letra);
        if(palabra_secreta.contains(letter)){
            return letra;
        }else{
            return 0;
        }*/
        if(VerificarLetra(letra)==true){
          for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                return letra;
            }
            }


            }
        return 0; 
        
    }
    
    public boolean VerificarLetra(char letra){
       
       /* if(palabra_secreta.contains(Integer.toString(letra))){
            return true;
        }return false;*/
       
       return palabraSecreta.indexOf(letra) != -1;
    }
    
     public String obtenerProgreso() {
        return palabraActual.toString();
    }
    
    public boolean Ganador(){
      return obtenerProgreso().equals(palabraSecreta);
        
    }
   
    

    public String obtenerPalabraSecreta() {
        return palabraSecreta;
    }
    
    
}
