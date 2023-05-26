//Algoritmo que recorre e imprime un vector de forma recursiva 
import java.util.Scanner;
public class Vector { 
    public static void main(String[] args) {         
        Scanner sc = new Scanner(System.in);        
        System.out.print("Indique la longitud que desea tenga el vector: ");
        int[] vector = new int[sc.nextInt()];
        for(int i=0;i<vector.length;i++){
            System.out.print("Elemento "+(i+1)+" del vector: ");
            vector[i] = sc.nextInt();
        }
        System.out.println("Los elementos del vector son:");
        mostrarVector(vector, 0);
        sc.close();         
    }     
    public static void mostrarVector(int[] vector, int indice){
        if (indice != vector.length){
            System.out.print(vector[indice]+", ");
            mostrarVector(vector, indice+1);
        }         
    }     
}
