package Proyecto.Arbol;
public class Arbol {
    Nodo raiz;      //Puntero a la raiz
    public int lengt = 0, tamaño=0, altura=0, num=1;
    
    public Arbol(){     //Metodo constructor
        raiz = null;
    }

    public boolean isEmpty(){       //Metodo para saber si el arbol está vacio
        return raiz == null;
    }

    public void add(String palabra, int nivel, int idPadre){        //Metodo para agregar un nuevo nodo tomando como parametros
        if(isEmpty()){                                              //el nivel donde será ingresado y la id de quien será su padre
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.setPalabra(palabra);
            nuevoNodo.setNivel(1);
            raiz = nuevoNodo;
            raiz.setId(1);
            tamaño++;
            altura = 1;
            //enumerar();
        }else{
            add(raiz, palabra, nivel, idPadre);     //Llamada recursiva al metodo " add " con el parametro Nodo como extra
        }
    }

    public void add(Nodo padre, String palabra, int nivel, int idPadre){
        if(padre.getNivel()+1==nivel&&padre.getId()==idPadre){
            padre.newHijo(palabra,padre.getNivel());
            padre.setIdHijos();
            altura = padre.getNivel()+1;
            padre.setFamiliaHijos(padre);
            //hermanosNivel(padre);
            //enumerar();                      
            tamaño++;
        }else{
            if(padre.getNivel()+1==nivel&&padre.hermano!=null){
                add(padre.hermano, palabra, nivel, idPadre);
            }else{
                if(padre.tieneHijo()){
                    add(padre.getHijo(0), palabra, nivel, idPadre);
                }
            }
        }       
    }
    
    public int getAltura(){     //Retorna la altura del arbol
        return altura;
    }

    public int getTamaño(){     //Retorna el tamaño del arbol
        return tamaño;
    }

    public void preorden(){     //Metodo recursivo para el recorrido en preorden
        System.out.println(raiz.getId()+" "+raiz.getPalabra());     //Como primer paso se posiciona en la raiz
        if(raiz.tieneHijo()){
            preorden(raiz);
        }
    }

    public void preorden(Nodo padre){       //Metodo recursivo para el recorrido en preorden, tomando como parametro un Nodo puntero
        if(padre.tieneHijo()){
            System.out.println(padre.getHijo(0).getId()+" "+padre.getHijo(0).getPalabra());
            preorden(padre.getHijo(0));
        }else{
            if(padre.tieneHermano()){
                System.out.println(padre.hermano.getId()+" "+padre.hermano.getPalabra());
                preorden(padre.hermano);
            }else{
                if(padre.padre.tieneHermano()){
                    System.out.println(padre.padre.hermano.getId()+" "+padre.padre.hermano.getPalabra());
                    preorden(padre.padre.hermano);
                }
            }
        }
    }

    public void postorden(){        //Metodo recursivo para el recorrido en postorden
        Nodo aux=raiz;
        while(aux.tieneHijo()){     //Como primer paso busca la hoja más izquierda del arbol
            aux=aux.getHijo(0);
        }
        System.out.println(aux.getId()+" "+aux.getPalabra());
        postorden(aux);
    }

    public void postorden(Nodo padre){      //Metodo recursivo para el recorrido en postorden, tomando como parametro un Nodo puntero
        if(padre.tieneHermano()){
            System.out.println(padre.hermano.getId()+" "+padre.hermano.getPalabra());
            postorden(padre.hermano);
        }else{
            if(padre.padre.tieneHermano()){
                System.out.println(padre.padre.getId()+" "+padre.padre.getPalabra());
                System.out.println(padre.padre.hermano.getHijo(0).getId()+" "+padre.padre.hermano.getHijo(0).getPalabra());
                postorden(padre.padre.hermano.getHijo(0));
            }else{
                System.out.println(padre.padre.getId()+" "+padre.padre.getPalabra());
                System.out.println(padre.padre.padre.getId()+" "+padre.padre.padre.getPalabra());
            }
        }
    }

    public void inorden(){      //Metodo recursivo para el recorrido en inorden
        Nodo aux=raiz;
        while(aux.tieneHijo()){     //Como primer paso busca la hoja más a la izquierda del arbol
            aux=aux.getHijo(0);
        }
        System.out.println(aux.getId()+" "+aux.getPalabra());
        inorden(aux);
    }

    public void inorden(Nodo padre){        //Metodo recursivo para el recorrido en inorden, tomando como parametro un Nodo puntero
        if(padre.tieneHermano()&&padre.padre.getHijo(0)==padre){
            System.out.println(padre.padre.getId()+" "+padre.padre.getPalabra());
            System.out.println(padre.hermano.getId()+" "+padre.hermano.getPalabra());
            inorden(padre.hermano);
        }else{
            if(padre.tieneHermano()){
                System.out.println(padre.hermano.getId()+" "+padre.hermano.getPalabra());
                inorden(padre.hermano);
            }else{
                if(padre.padre.padre.getHijo(0)==padre.padre){
                    System.out.println(padre.padre.padre.getId()+" "+padre.padre.padre.getPalabra());
                    inorden(padre.padre.padre.getHijo(1).getHijo(0));
                }else{
                    if(padre.padre.tieneHermano()){
                        System.out.println(padre.padre.hermano.getHijo(0).getId()+" "+padre.padre.hermano.getPalabra());
                        inorden(padre.padre.hermano.getHijo(0));
                    }
                }
            }
        }
    }

    /*
     * 
     * METODOS NO TERMINADOS Y SIN UTILIZAR EN EL PRODUCTO FINAL
     * 
     */

     //Metodos recursivos para mostrar todos los nodos de un determinado nivel del arbol
    /*public void mostrarNivel(int nivel){
        if(nivel==1){
            System.out.println("1 " + raiz.getPalabra());
        }else{
            mostrarNivel(raiz, nivel);
        }
    }    
    public void mostrarNivel(Nodo padre, int nivel){
        if(padre.getNivel()!=nivel&&padre.tieneHijo()){
            mostrarNivel(padre.getHijo(0), nivel);
        }else{
            if(padre.getNivel()==nivel){
                System.out.println(padre.getId()+" "+padre.getPalabra());
                if(padre.hermano!=null){
                    mostrarNivel(padre.hermano, nivel);
                }else{
                    if(padre.padre.tieneHermano()){
                        if(padre.padre.hermano.tieneHijo()){
                            mostrarNivel(padre.padre.hermano.getHijo(0), nivel);
                        }
                    }
                }
            }
        }
    }*/
    
    //Metodo para asignar una IDGLOBAL a todos los nodos del arbol
    /*public void enumerar(){
        raiz.setIdGlobal(1);
        if(tamaño!=1){   
            enumerar(raiz, 1);
        }
    }

    public void enumerar(Nodo Padre, int acum){        
        if(Padre.tieneHijo()){
            for(int i=0; i<Padre.cantidadHijos();i++){
                Padre.getHijo(i).setIdGlobal(acum+1);
                acum++;
            }
            if(Padre.tieneHermano()){
                enumerar(Padre.hermano, acum);
            }else{
                if(Padre.padre==raiz){
                    enumerar(Padre.getHijo(0), acum);
                }
            }
        }
    }*/
}
