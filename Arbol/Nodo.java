package Proyecto.Arbol;

import java.util.ArrayList;         //Importacion de Arraylist, ocupado para almacenar los hijos de cada nodo

public class Nodo {
    String palabra;     //Contenido del nodo
    Nodo padre, hermano;        //Punteros de cada Nodo
    int id, nivel, idGlobal;        //Identificadores o Keys del Nodo

    ArrayList<Nodo> hijos = new ArrayList<Nodo>();  //Creacion del arreglo donde se almacenaran los Nodos Hijo de cada Nodo

    public void newHijo(String palabra, int nivel){     //Construccion y almacenamiento de nuevos Nodos Hijo
        Nodo hijo = new Nodo();
        hijo.setPalabra(palabra);
        hijo.setId(hijos.size()+1);
        hijo.setNivel(nivel+1);
        hijo.hermano=null;
        hijos.add(hijo);
    }

    public void setIdHijos(){       //Asignacion de Id a cada Nodo hijo de un solo padre, esta id es independiente al resto del arbol
        for(int i=0;hijos.size()>i;i++){            
                hijos.get(i).setId(i+1);
        }
    }

    public void setFamiliaHijos(Nodo Padre){        //Asignacion de los punteros Padre y Hermano
        for(int i=0;hijos.size()>i;i++){
            hijos.get(i).padre = Padre;
            if(i<hijos.size()-1){
                hijos.get(i).hermano=hijos.get(i+1);
            }
        }
    }

    public boolean tieneHijo(){     //Metodo para conocer si el Nodo tiene Nodos Hijo
        return !hijos.isEmpty();
    }

    public Nodo getHijo(int idHijo){
        return hijos.get(idHijo);
    }

    public int cantidadHijos(){     //Metodo para conocer la cantidad de Nodos
        return hijos.size();
    }

    public void setNivel(int nivel){        //Metodo que asigna el nivel en el que se encuentra el nodo, se calcula sumando 1 al nivel de su Nodo padre
        this.nivel = nivel;
    }

    public void setPalabra(String palabra){
        this.palabra = palabra;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getPalabra(){
        return palabra;
    }

    public int getId(){
        return id;
    }

    public int getNivel(){
        return nivel;
    }

    public int getIdGlobal(){
        return idGlobal;
    }

    public boolean tieneHermano(){      //Metodo para conocer si el Nodo tiene Nodo Hermano
        return hermano!=null;
    }

    public Nodo getUltimoHijo(){        //[ Sin uso ] Metodo para concer el ultimo Nodo hijo ingresado en el Nodo
        return hijos.get(hijos.size()-1);
    }

    public void setIdGlobal(int idGlobal){      //[ Sin uso ] Set-er de la IDGLOBAL del Nodo, marcaria su posicion en el arbol
        this.idGlobal = idGlobal;
    }
}
