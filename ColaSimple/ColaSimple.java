package Proyecto.ColaSimple;

public class ColaSimple {
    private Nodo inicioCola, finalCola,aux;
    private String blanco = "\u001B[37m", amarillo = "\u001B[33m";
    public ColaSimple(){
        inicioCola = null;
        finalCola = null;
    }
    public boolean isEmpty(){
        if(inicioCola == null){
            return true;
        }else{
            return false;
        }
    }
    public void insertar(String name){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.setNombre(name);
        nuevo_nodo.siguiente = null;
        if(isEmpty()){
            inicioCola = nuevo_nodo;
            finalCola = nuevo_nodo;
        }else{
            finalCola.siguiente = nuevo_nodo;
            finalCola = nuevo_nodo;
        }
    }
    public String extraer(){
        aux = inicioCola; 
        if(!isEmpty()){            
            if(inicioCola == finalCola){
                inicioCola = null;
                finalCola = null;
            }else{                               
                inicioCola = inicioCola.siguiente;
            }
            return aux.getNombre();                      
        }else{
            return null;
        }
    }
    public void mostrarContenido(){
        Nodo recorrido = inicioCola;
        int i = 1;
        while(recorrido != null){            
            System.out.println(amarillo+i+blanco+" "+recorrido.getNombre());
            i++;
            recorrido = recorrido.siguiente;
        }
    }
}
