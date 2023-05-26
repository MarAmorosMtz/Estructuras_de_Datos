//Una empresa de pilas dobles solicita un programa que pueda meter y strings en una pila doble
package Proyecto.PilaDoble;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) { 
        PilaDoble pila = new PilaDoble();
        Scanner strings = new Scanner(System.in);
        Scanner ints = new Scanner(System.in);
        String clean = "\033[H\033[2J";
        int op;
        boolean salir = false;
        do{
            System.out.println(clean);
            System.out.println("1. Agregar\n2. Eliminar\n3. Mostrar Ultimo\n4. Mostrar todo\n5. Salir");
            System.out.print("Su opción: ");
            op = ints.nextInt();
            switch(op){
                case 1:                    
                    System.out.print("String a apilar: ");
                    pila.insertar(strings.nextLine());                    
                    break;
                case 2:
                    if(pila.esVacia()){
                        System.out.println("La pila está vacía");
                    }else{
                        System.out.println(pila.quitarDato()+" Eliminado");
                    }
                    break;
                case 3:
                    if(pila.esVacia()){
                        System.out.println("La pila está vacía");
                    }else{
                        System.out.println(pila.mostrarUltimo());
                    }
                    break;
                case 4:
                    if(pila.esVacia()){
                        System.out.println("La pila está vacía");
                    }else{
                        pila.mostrarContenido();
                    }
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            try {
                Thread.sleep(2500);
            } catch (Exception e) {     }
        }while(salir == false);
        strings.close();
        ints.close();
    }
}
