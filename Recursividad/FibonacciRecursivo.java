//Sucesion de Fibonacci de manera recursiva
import java.util.Scanner;
public class FibonacciRecursivo {
    public static int Fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Cual termino de la sucesion desea ver?: ");
        x = sc.nextInt();
        System.out.print("Termino "+x+": "+Fibonacci(x));
        sc.close();
    }
}
