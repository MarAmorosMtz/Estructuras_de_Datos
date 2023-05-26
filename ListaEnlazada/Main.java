/*La profesora Primavera solicita un programa que le ayude a gestionar la lista de sus alumnos de 3er semestre.
 Debido a la complejidad de la carrera y la alta demanda de personal en el mcDonals constantemente hay que eliminar
 alumnos de la lista asi como tambien insertar nuevos alumnos que deseen tomar las clases. */
package Proyecto.ListaEnlazada;
import java.util.Scanner;
import java.lang.Thread;
public class Main {
    public static void main(String[] args) {
        Scanner ints = new Scanner(System.in);
        Scanner strings = new Scanner(System.in);
        String clean = "\033[H\033[2J", rojo = "\u001B[31m", verde = "\u001B[32m", blanco = "\u001B[37m", azul = "\u001B[36m", amarillo = "\u001B[33m", nombre;
        boolean salir = false, added=true;
        int opcion, i=0, opcion2, numeroLista, opcion3;
        ListaEnlazada lista = new ListaEnlazada();
        System.out.println(clean);
        System.out.println(amarillo+"¡Bienvenida!\n"+blanco);
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
            System.out.println(verde+"*** Estructura de Datos ***\n"+blanco);
            System.out.println("----Menú de opciones----");           
            System.out.println(azul+"1."+blanco+" Agregar nuevo alumno\n"+azul+"2."+blanco+" Eliminar alumno\n"
                            +azul+"3."+blanco+" Mostrar lista\n"+azul+"4. "+blanco+"Buscar\n"+azul+"5. "+blanco+"Vaciar lista\n"+azul+"6. "+blanco+"Salir");
            System.out.print("Seleccione su opcion: ");
            opcion = ints.nextInt();
            switch(opcion){
                case 1:
                    System.out.println(clean);
                    System.out.println("----Opciones de Agregado----");
                    System.out.println(azul+"1."+blanco+" Agregar al inicio\n"+azul+"2. "+blanco+"Agregar al final\n"+azul+
                                        "3. "+blanco+"Agregar en posicion especifica"+azul+"\n4. "+blanco+"Regresar");
                    System.out.print("Seleccione su opcion: ");
                    opcion2 = ints.nextInt();
                    switch(opcion2){
                        case 1:
                            System.out.print("Nombre del nuevo alumno: ");                            
                            nombre = strings.nextLine();
                            lista.insertarFirst(nombre);
                            System.out.println(verde+"Alumno agregado con éxito!"+blanco);
                            try {
                                Thread.sleep(2500);
                            } catch (Exception e) {     }
                            break;
                        case 2:
                            if(!lista.isEmpty()){
                                System.out.print("Nombre del nuevo alumno: ");
                                nombre = strings.nextLine();
                                lista.insertarLast(nombre);
                            }else{
                                System.out.print("Nombre del nuevo alumno: ");
                                nombre = strings.nextLine();
                                lista.insertarFirst(nombre);
                            }
                            System.out.println(verde+"Alumno agregado con éxito!"+blanco);
                            try {
                                Thread.sleep(2500);
                            } catch (Exception e) {     }
                            break;
                        case 3:
                            if(lista.isEmpty()){
                                System.out.print("Nombre del nuevo alumno: ");
                                nombre = strings.nextLine();
                                lista.insertarFirst(nombre);
                            }else{
                                if(lista.lengt()==1){
                                    System.out.println(clean);
                                    lista.show();
                                    System.out.println("--------------------------------------");
                                    System.out.println("1. Agregar antes\n2. Agregar despues\n3. Regresar");
                                    System.out.print("Su opcion: ");
                                    opcion3 = ints.nextInt();
                                    switch (opcion3) {
                                        case 1:
                                            System.out.print("Nombre del nuevo alumno: ");
                                            nombre = strings.nextLine();
                                            lista.insertarFirst(nombre);                                         
                                            break;
                                        case 2:
                                            System.out.print("Nombre del nuevo alumno: ");
                                            nombre = strings.nextLine();
                                            lista.insertarLast(nombre);
                                            break;
                                        case 3:
                                            added = false;
                                            break;                                  
                                        default:
                                            System.out.println(rojo+"Opcion invalida!"+blanco);
                                            break;
                                    }
                                }else{
                                    System.out.println(clean);
                                    lista.show();
                                    System.out.println("--------------------------------------");
                                    System.out.print("Después de quien desea ingresarlo (Num. Lista): ");
                                    numeroLista = ints.nextInt();                                   
                                    if(numeroLista<=lista.lengt()&&numeroLista>0){                                        
                                        System.out.print("Nombre del nuevo alumno: ");
                                        nombre = strings.nextLine();
                                        lista.insertarAfter(nombre, numeroLista);
                                    }else{
                                        if(numeroLista>lista.lengt()){
                                            System.out.print("Nombre del nuevo alumno (Será ingresado al final de la lista): ");
                                            nombre = strings.nextLine();
                                            lista.insertarLast(nombre);
                                        }else{
                                            if(numeroLista<=0){
                                                System.out.print("Nombre del nuevo alumno (Será ingresado al inicio de la lista): ");
                                                nombre = strings.nextLine();
                                                lista.insertarFirst(nombre);
                                            }
                                        }
                                    }
                                }
                            }
                            if(added){
                                System.out.println(verde+"Alumno agregado con éxito!"+blanco);
                            }
                            added=true;
                            try {
                                Thread.sleep(2500);
                            } catch (Exception e) {     }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println(rojo+"Opcion invalida!"+blanco);
                            try {
                                Thread.sleep(2500);
                            } catch (Exception e) {     }                            
                            break;
                    }
                    break;
                case 2:
                    System.out.println(clean);
                    System.out.println("----Opciones de Elminado----");
                    System.out.println(azul+"1."+blanco+" Eliminar el primero\n"+azul+"2. "+blanco+"Eliminar el ultimo\n"+azul+
                                    "3. "+blanco+"Eliminar posicion especifica\n"+azul+"4. "+blanco+"Regresar");
                    System.out.print("Seleccione su opcion: ");
                    opcion2 = ints.nextInt();
                    switch(opcion2){
                        case 1:
                            if(!lista.isEmpty()){
                                System.out.println(lista.eliminarPrimero()+verde+" - Eliminado con éxito!"+blanco);                           
                            }else{
                                System.out.print(rojo+"La lista esta vacia!"+blanco);
                            }
                            break;
                        case 2:
                            if(!lista.isEmpty()){
                                System.out.println(lista.eliminarUltimo()+verde+" - Eliminado con éxito!"+blanco);
                            }else{
                                System.out.print(rojo+"La lista esta vacia!"+blanco);
                            }
                            break;
                        case 3:
                            System.out.println(clean);
                            if(!lista.isEmpty()){
                                lista.show();
                                System.out.println("--------------------------------------");
                                System.out.print("Numero de lista a eliminar: ");
                                numeroLista = ints.nextInt();
                                if(numeroLista<=lista.lengt()&&numeroLista>0){
                                    System.out.println(lista.eliminarIndex(numeroLista)+verde+" - Eliminado con éxito!"+blanco);
                                }else{
                                    if(numeroLista>lista.lengt()){
                                        System.out.println(lista.eliminarUltimo()+verde+" - Eliminado con éxito!"+blanco);
                                    }else{
                                        if(numeroLista<=0){
                                            System.out.println(lista.eliminarPrimero()+verde+" - Eliminado con éxito!"+blanco); 
                                        }
                                    }
                                }
                            }else{
                                System.out.print(rojo+"La lista esta vacia!"+blanco);
                            }                              
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println(rojo+"Opcion invalida!");                            
                            break;                           
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
                case 3:
                    System.out.println(clean);
                    if(!lista.isEmpty()){
                        System.out.println(verde+"****** Lista de Alumnos ******");
                        lista.show();
                    }else{
                        System.out.print(rojo+"La lista esta vacia!"+blanco);
                    }
                    try {
                        Thread.sleep(3500);
                    } catch (Exception e) {     }
                    break;
                case 4:                    
                    if(!lista.isEmpty()){
                        System.out.println(clean);
                        System.out.print("Numero de lista a buscar: ");
                        numeroLista = ints.nextInt();
                        System.out.println(lista.searchByID(numeroLista));                        
                    }else{
                        System.out.println(clean);
                        System.out.println(rojo+"La lista está vacía"+blanco);
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
                case 5:
                    System.out.println(clean);
                    if(lista.isEmpty()){                        
                        System.out.println(rojo+"La lista está vacía"+blanco);
                    }else{
                        lista.clean();
                        System.out.print(verde+"Lista vaciada con exito"+blanco);
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {     }
                    break;
                case 6:
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
                    System.out.println(rojo+"Opcion invalida!"+blanco);
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {     }
                    break;                                    
            }
        }while(salir == false);
        ints.close();
        strings.close();
    }
}