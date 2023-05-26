//Calcular factorial de un numero mediante la recursividad
import java.util.Scanner;
public class FactorialRecursivo {
    private static int Factorial(int a){
        if(a==0){
            return 1;
        }else{
            return a * Factorial(a-1);
        }
    }
    public static void main(String args[]){
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.print("Calcular el factorial de: ");
        x = sc.nextInt();
        System.out.print(x+"! = " + Factorial(x));
        sc.close();
    }
}
