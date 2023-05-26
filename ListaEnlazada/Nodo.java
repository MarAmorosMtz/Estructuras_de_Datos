package Proyecto.ListaEnlazada;

public class Nodo {
    Nodo siguiente;
    String nombreAlumno;
    int numLista;
    public void setNombreAlumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }
    public void setNumLista(int numLista){
        this.numLista = numLista;
    }
    public String getNombreAlumno(){
        return nombreAlumno;
    }
    public int getNumLista(){
        return numLista;
    }
}
