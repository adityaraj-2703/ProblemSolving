package binaryexpo;

public class Pown {
    public double myPow(double x, int n) {
        return binaryExp(x,n);
    }
    public double binaryExp(double x,int n){
        if(Math.abs(n)<=1){
            return x;
        }
        if(n%2==0){
            if(n<0){
                double temp = 1/x * 1/x;
                return binaryExp(temp,-n/2);
            }
            else{
                double temp = x*x;
                return binaryExp(temp,n/2);
            }
        }
        else{
           return x * binaryExp(x,n-1);
        }
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -200000000;
        System.out.println(new Pown().binaryExp(x, n));
    }

}
