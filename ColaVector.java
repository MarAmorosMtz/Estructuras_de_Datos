public class ColaVector {
    public static int [] cola;
    public static int index=0, i;
    private ColaVector(int size){
        int a = size;
        cola = new int [a];
    }
    private void add(int x){        
        if(index < cola.length && index >= 0){
            cola[index] = x;
            index++;
        }else{
            System.out.println("La cola está llena");
        }
    }
    private void delete(){
        if(index-1 <= cola.length+1 && index-1 > 0){
            index--;
        }else{
            System.out.println("La cola está vacía");
        }
    }
    private int top(){
        if(index-1 <= cola.length && index-1 >= 0){
            return cola[0];
        }else{
            System.out.println("Cola vacía");
            return 0;
        }
    }
    private int last(){
        if(index >= 0){
            return cola[index-1];
        }else{
            System.out.println("Cola vacía");
            return 0;
        }
    }
    private void show(){
        for(i=0;i<=index;i++){
            System.out.println(cola[i]);
        }
    }
    private void clear(){
        index = 0;
    }
    private int length(){
        return cola.length;
    }
    public static void main(String[] args) {
        ColaVector nueva = new ColaVector(5);
        nueva.add(10);
        nueva.add(20);
        nueva.add(30);
        nueva.add(40);
        nueva.add(50);
        System.out.println("Cabeza: " + nueva.top());
        System.out.println("Final: " + nueva.last());
    }
}
