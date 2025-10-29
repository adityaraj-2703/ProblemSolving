package recursion;

public class WaysToExpressIntegerAsSumOfPower {
    public int numberOfWays(int n, int x) {
        int[] sum = new int[1];
        numberOfWaysUtil(n,x,1,sum);
        return sum[0];
    }
    public void numberOfWaysUtil(int n,int x,int ind,int[] sum){
        if(n==0){
            sum[0]+=1;
            return;
        }
        else if(n<0){
            return;
        }
        else if((int)Math.pow(ind,x)>n){
            return;
        }
        else{
            int temp = n - (int)Math.pow(ind,x);
            numberOfWaysUtil(temp,x,ind+1,sum);
            numberOfWaysUtil(n,x,ind+1,sum);
        }
        
    }

    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        WaysToExpressIntegerAsSumOfPower w = new WaysToExpressIntegerAsSumOfPower();
        System.out.println(w.numberOfWays(n, x));
    }

}
