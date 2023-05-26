/* El chekos requiere de un sistema para gestionar la lista de espera para usar las mesas de billar.
Hay infinitas mesas disponibles. Las mesas sólo se pueden ocupar 1 unidad de tiempo determinada por lo que siempre
la mesa que lleve más tiempo en uso será la más proxima a desocuparse. 
¿Cómo puede haber un numero infinito de mesas disponibles? ¿Donde entra tanta gente? ¿Cuando a factoria? bueno esas son preguntas
que no tienen relevancia para este problema */
package Proyecto.ColaSimple;
import java.util.Scanner;
import java.lang.Thread;
public class Main {
    public static void main(String[] args) {
        ColaSimple cola = new ColaSimple();
        Scanner sc = new Scanner(System.in);
        int opcion, i=0;
        boolean salir = false;
        String clean = "\033[H\033[2J", rojo = "\u001B[31m", verde = "\u001B[32m", blanco = "\u001B[37m", azul = "\u001B[36m", amarillo = "\u001B[33m";
        System.out.println(clean);
        System.out.println(azul+"¡Bienvenido!\n"+blanco);
        System.out.print("Cargando ");
        try {
            while(i<4){
                System.out.print(". ");
                i++;
                Thread.sleep(1000);
            }           
        } catch (Exception e) {        }
        do{
            System.out.println(clean);
            System.out.println(verde+"*** Chekos ***\n"+blanco);
            System.out.println("----Menú de opciones----");
            System.out.println(amarillo+"1."+blanco+" Agregar nuevo cliente\n"+amarillo+"2."+blanco+" Desocupar Mesa\n"+
                                amarillo+"3."+blanco+" Mostrar Estado Actual\n"+amarillo+"4."+blanco+" Terminar");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    System.out.print(clean);
                    System.out.println("----Agregar nuevo cliente----");
                    System.out.print("Primer nombre del cliente: ");
                    cola.insertar(sc.nextLine());
                    System.out.println(verde+"Cliente agregado con éxito!"+blanco);
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
                case 2:
                    System.out.print(clean);
                    System.out.println("----Desocupar Mesa----");
                    if(!cola.isEmpty()){
                        System.out.println(cola.extraer()+verde+" - Desocupada con éxito!"+blanco);
                    }else{
                        System.out.println(rojo+"El Chekos está vacío"+blanco);
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
                case 3:
                    System.out.print(clean);
                    System.out.println("----Mesas en uso----");
                    if(cola.isEmpty()){
                        System.out.println(rojo+"El Chekos está vacío"+blanco);
                    }else{
                        cola.mostrarContenido();
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
                case 4:
                    salir = true;
                    System.out.print(rojo+"Saliendo"+blanco);
                    i=0;
                    try {
                        while(i<4){
                            System.out.print(rojo+". "+blanco);
                            i++;
                            Thread.sleep(1000);
                        }
                        System.out.println(clean);
                    } catch (Exception e) {        }
                    break;
                default:
                    System.out.print(clean);
                    System.out.println(rojo+"****Opcion inválida****"+blanco);
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
            }
        }while(!salir);
        sc.close();
    }
}
