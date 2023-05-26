public class AckermanRecursivo {
    private static int ackerman(int m, int n){
        if(m==0){
            return n+1;
        }else if(m>0 && n==0){
            return ackerman(m-1, 1);
        }else if(m>0 && n>0){
            return ackerman(m-1, ackerman(m, n-1));
        }else{
            return 1;
        }
    }
    public static void main(String[] args) {
        System.out.println(ackerman(2, 2));
    }
}
