// Algoritmo que convierte numero decimal a numero binario
import java.util.Scanner;
public class toBinarie {
    private static void toBin(int n){
        if(n<2){
            System.out.print(n);
            return;
        }else{
            toBin(n/2);
            System.out.print(n%2);
            return;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Decimal a convertir: ");
        x = sc.nextInt();
        toBin(x);
        sc.close();
    }
}
