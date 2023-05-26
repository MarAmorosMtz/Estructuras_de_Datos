package Proyecto.PilaDoble;

public class PilaDoble {
    Nodo finalPila;
    int longitud=0;
    String Lista = "";
    public PilaDoble(){
        finalPila = null;
    }
    public boolean esVacia(){
        return finalPila==null;
    }
    public void insertar(String libro){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setLibro(libro);
        nuevoNodo.siguiente = finalPila;
        finalPila = nuevoNodo;
        longitud++;
    }
    public String quitarDato(){
        String nombre = finalPila.getLibro();
        finalPila = finalPila.siguiente;
        longitud--;
        return nombre;
    }
    public String mostrarUltimo(){
        return finalPila.getLibro();
    }
    public void mostrarContenido(){
        Nodo auxiliar = finalPila;
        while(auxiliar != null){
            Lista += auxiliar.getLibro()+"\n";
            auxiliar = auxiliar.siguiente;
        }
        System.out.print(Lista);
        Lista="";
    }
    public int mostrarLongitud(){
        return longitud;
    }
    
}
