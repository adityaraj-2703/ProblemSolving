package array;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 21;
        int a = 0;
        int b = 1;
        for(int i=2;i<=n;i++){
            int c = a+b;
            a = b;
            b = c;
            System.out.print(c+" ");
        }
        //System.out.println(b);
    }

}
