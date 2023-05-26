package Proyecto.Arbol;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean salir=false;
        int op;
        String wait;
        String clean = "\033[H\033[2J";     //Secuencia de escape para limpiar el texto de la consola
        Scanner sc = new Scanner(System.in);        //Creacion de un objeto de la clase scanner para la lectura de datos
        Scanner strings = new Scanner(System.in);
        Arbol arbol = new Arbol();      //Creacion de un objeto de la clase arbol
        // Llenado de el arbol
        arbol.add("Animales", 1, 1);
        arbol.add("Mamifero", 2, 1);
        arbol.add("Reptil", 2, 1);
        arbol.add("Insecto", 2, 1);
        arbol.add("Perro", 3, 1);
        arbol.add("Gato", 3, 1);
        arbol.add("Delfin", 3, 1);
        arbol.add("Cocodrillo", 3, 2);
        arbol.add("Serpiente", 3, 2);
        arbol.add("Tortuga", 3, 2);
        arbol.add("Abeja", 3, 3);
        arbol.add("Libelula", 3, 3);
        arbol.add("Hormiga", 3, 3);
        //Estructura repetitiva do-while para no terminar la ejecucion si no hasta que el usuario lo indique
        do{
            System.out.println(clean);
            //Menu de opciones
            System.out.println("1. Inorden\n2. Preorden\n3. Postorden\n4. Ver tamaño\n5. Ver Altura\n6. Salir");
            System.out.print("Elija su opcion: ");
            op = sc.nextInt();
            System.out.println(clean);
            switch(op){
                case 1:
                    System.out.println("--- Recorrido en Inorden ---");
                    arbol.inorden();
                    break;
                case 2:
                    System.out.println("--- Recorrido en Preorden ---");
                    arbol.preorden();
                    break;
                case 3:
                    System.out.println("--- Recorrido en Postorden ---");
                    arbol.postorden();
                    break;
                case 4:
                    System.out.println("El tamaño del arbol es: "+arbol.getTamaño());
                    break;
                case 5:
                    System.out.println("La altura del arbol es: "+arbol.getAltura());
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            if(salir==false){
                System.out.print("Precione [ Enter ] para continuar ");
                wait = strings.nextLine();
            }
        }while(salir==false);
        sc.close();
        strings.close();
    }
}
