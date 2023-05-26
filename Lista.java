import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
public class Lista{
        public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        String [] nombres = {"Marco","Marisol","Roberto"};
        List<String> listaNombres = Arrays.asList(nombres);
        List<String> listaAutos = new ArrayList<>();
        listaAutos.add("Mercedes Benz");
        List <String> elementos = new ArrayList<>(listaAutos);
        elementos.addAll(listaNombres);
        for (String str : elementos) {
            System.out.println(str);
        }
        ListIterator<String> iterador = listaNombres.listIterator();
        while (iterador.hasNext()){
            System.out.println(iterador.next());
        }
        listaNombres.remove(0);
        listaNombres.remove("Roberto");
        listaNombres.clear();
    }
}