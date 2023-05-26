/*Creacion y uso de una pila mediante arraylist, con metodos set  y get (la verdad no encuentro la utilidad en esto, jamás se usaría así en un
entorno real; para eso ya existe la clase Stack con sus metodos y todo y sería mejor que nos pusiera a usar eso pero weno)*/
import java.util.ArrayList;
public class PilaSetGet {
    public static int index=0;
    public static ArrayList<Integer> pila =new ArrayList<Integer>();
    private PilaSetGet(){}
    private void setElement(Integer a){
        Integer x = a;       //Set :)
        pila.add(x);
        index++;
    }
    private void Pop(){
        if(!pila.isEmpty()){
            pila.remove(index-1);
            index--;
        }else{
            System.out.println("La pila está vacía");
        }
    }
    private boolean isEmpty(){
        return pila.isEmpty();        
    }
    private int getSize(){      //Get :)
        return pila.size();
    }
    private void getTop(){       //Get :)
        if(pila.isEmpty()){
            System.out.println("La pila está vacía");
        }else{
            System.out.println(pila.get(index-1));
        }
    }
    private void flush(){
        pila.clear();
    }
    public static void main(String[] args) { 
        PilaSetGet stack = new PilaSetGet();
        stack.setElement(3);        //apilo un 3
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
        stack.setElement(1);        //apilo un 1
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
        stack.setElement(5);        //apilo un 5
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
        stack.Pop();        // Retiro el 5
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
        stack.setElement(10);        //apilo un 10
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
        stack.flush();      //vaciado de la pila
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
        stack.Pop();        // intento desapilar en una pila vacía
        System.out.print("Top: ");
        stack.getTop();
        System.out.println("Size: "+stack.getSize());
        System.out.println("Empty: "+stack.isEmpty());
        System.out.println("----------------------------------------------------------");
    }
}
