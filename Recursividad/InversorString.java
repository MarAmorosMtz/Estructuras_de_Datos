//Algoritmo que invierte una palabra y la imprime
import java.util.Scanner;
public class InversorString { 
    public static void main(String[] args) {         
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba la palbra a invertir: ");
        String palabra = sc.nextLine();
        System.out.println("Palabra al derecho: "+palabra);
        System.out.println("Palabra al reves: "+invertirPalabra(palabra, palabra.length()-1));         
         sc.close();
    }
     
     public static String invertirPalabra(String palabra, int longitud){         
        if(longitud==0){
            return palabra.charAt(longitud)+"";
        }else{
            return palabra.charAt(longitud) + (invertirPalabra(palabra, longitud-1));
        }         
    }     
}
