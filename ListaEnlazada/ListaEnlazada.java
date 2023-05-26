package Proyecto.ListaEnlazada;

public class ListaEnlazada {
    private Nodo inicioCola, finalCola, aux;
    private String blanco = "\u001B[37m", azul = "\u001B[36m", rojo = "\u001B[31m";
    private int lengt=0;
    public ListaEnlazada(){
        inicioCola = null;
        finalCola = null;
    }
    public boolean isEmpty(){
        if(inicioCola==null){
            return true;
        }else{
            return false;
        }
    }
    public void insertarLast(String nombreAlumno){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setNombreAlumno(nombreAlumno);
        nuevoNodo.siguiente = null;
        if(isEmpty()){
            inicioCola = nuevoNodo;
            finalCola = nuevoNodo;
            nuevoNodo.setNumLista(1);
        }else{
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        lengt++;
        enumerar();
    }
    public void insertarFirst(String nombreAlumno){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setNombreAlumno(nombreAlumno);
        nuevoNodo.setNumLista(1);
        if(isEmpty()){            
            inicioCola = nuevoNodo;
            finalCola = nuevoNodo;
        }else{
            nuevoNodo.siguiente = inicioCola;
            inicioCola = nuevoNodo;
        }
        lengt++;
        enumerar();
    }
    public void insertarAfter(String nombreAlumno, int id){
        Nodo nuevoNodo = new Nodo();
        Nodo puntero = inicioCola;
        int contador = 1;
        nuevoNodo.setNombreAlumno(nombreAlumno);
        while(contador < id && puntero.siguiente != null){
            puntero = puntero.siguiente;
            contador++;
        }
        nuevoNodo.siguiente = puntero.siguiente;
        puntero.siguiente = nuevoNodo;
        lengt++;
        enumerar();
    }
    public void enumerar(){
        Nodo puntero = inicioCola;
        while(puntero.siguiente != null){
            puntero.siguiente.setNumLista(puntero.getNumLista()+1);
            puntero = puntero.siguiente;
        }
    }
    public String eliminarPrimero(){
        aux = inicioCola;
        if(!isEmpty()){
            if(lengt==1){
                inicioCola = null;
                finalCola = null;
            }else{
                inicioCola = inicioCola.siguiente;
                inicioCola.setNumLista(1);
                enumerar();
            }            
            lengt--;
            return String.valueOf(aux.getNumLista()) + " " +aux.getNombreAlumno();
        }else{
            return null;
        }
    }
    public String eliminarUltimo(){
        aux = finalCola;
        if(!isEmpty()){
            if(lengt == 1){
                inicioCola = null;
                finalCola = null;
            }else{
                if(lengt == 2){
                    finalCola = inicioCola;
                    inicioCola.siguiente = null;
                }else{
                    Nodo puntero = inicioCola;
                    while(puntero.siguiente.siguiente != null){
                        puntero = puntero.siguiente;
                    }
                    puntero.siguiente = null;
                    finalCola = puntero;
                    enumerar();
                }
            }            
            lengt--;
            return String.valueOf(aux.getNumLista()) + " " +aux.getNombreAlumno();
        }else{
            return null;
        }        
    }
    public String eliminarIndex(int id){
        Nodo puntero = inicioCola;
        int contador=1;
        if(id==1){                    
            return eliminarPrimero();
        }else{
            while(contador < id-1 && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            aux = puntero.siguiente;
            puntero.siguiente = aux.siguiente;
            enumerar();
            lengt--;
            return String.valueOf(aux.getNumLista()) + " " +aux.getNombreAlumno();
        }
    }
    public String searchByID(int id){
        if(isEmpty()){
            return null;
        }else{
            Nodo puntero = inicioCola;
            while(puntero.getNumLista()!=id && puntero.siguiente != null){
                puntero = puntero.siguiente;
            }
            if(puntero.getNumLista()!=id){
                return rojo+"Registro no hallado!"+blanco;
            }else{
                return String.valueOf(azul+puntero.getNumLista()) + " "+ blanco +puntero.getNombreAlumno();
            }
        }
    }
    public void show(){
        aux = inicioCola;
        while(aux != null){
            System.out.println(azul+aux.getNumLista() +blanco+ " " +aux.getNombreAlumno());
            aux = aux.siguiente;
        }
    }
    public int lengt(){
        return lengt;
    }
    public void clean(){
        aux = inicioCola;
        Nodo puntero;
        if(lengt==1 || lengt == 2){
            inicioCola = null;
            finalCola = null;
        }else{            
            while(aux.siguiente != null){
                puntero = aux;
                aux = aux.siguiente;
                puntero.siguiente = null;
            }
            inicioCola = null;
        }
        lengt = 0;
    }
}
