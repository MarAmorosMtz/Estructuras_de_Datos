import java.util.LinkedList;
public class ColaLinkedList {
    public static LinkedList<String> lista = new LinkedList<String>();
    public static int index = 0;
    private ColaLinkedList(){}
    private void add(String n){
        lista.add(n);
        index++;
    }
    private void delete(){
        if(lista.isEmpty()){
            System.out.println("La cola está vacía");
        }else{
            lista.removeLast();
        }
    }
    private String top(){
        return lista.getFirst();
    }
    private String last(){
        return lista.getLast();
    }
    public static void main(String[] args) {
        ColaLinkedList cola = new ColaLinkedList();
        cola.add("Alex");
        cola.add("Mar");
        cola.add("Sicario");
        cola.add("Jordy");
        cola.add("Estrella");
        System.out.println("Cabeza: "+cola.top());
        System.out.println("Final: "+cola.last());
    }
}
