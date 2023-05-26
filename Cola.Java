//Implementacion de una cola
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.lang.Thread;
public class Tarea6 {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        Queue<String> cola = new LinkedList<String>();
        int option;
        boolean salir = false;
        do{
            System.out.println("\033[H\033[2J");
            System.out.println("1. Agregar nueva cancion\n2. Remover cancion de la cola\n3. Limpiar la cola de canciones\n4. Ver cola de caciones\n5. Salir");
            System.out.print("Elija su opcion: ");
            option = sc.nextInt();
            switch(option){
                case 1:
                sc.nextLine();
                System.out.print("Nombre de la cancion a agregar a la cola: ");
                cola.add(sc.nextLine());
                System.out.println("Cancion agregada con exito");
                break;
                case 2:
                if(cola.isEmpty() == true){
                    System.out.println("La cola ya está vacía");
                }else{
                    cola.remove();
                    System.out.println("Cancion removida con exito");
                }
                break;
                case 3:
                if(cola.isEmpty() == true){
                    System.out.println("La cola ya está vacía");
                }else{
                    cola.clear();
                    System.out.println("Cola vaciada con exito");
                }
                break;
                case 4:
                if(cola.isEmpty() == true){
                    System.out.println("La cola está vacía");
                }else{
                    System.out.println(cola);
                }
                break;
                case 5:
                salir = true;
                System.out.println("Saliendo...");
                break;
                default:
                System.out.println("Elija una opción valida");
                break;
            }
            try{
                Thread.sleep(2000);
            }catch(Exception e){}
        }while(salir == false);
        sc.close();
    }
}
