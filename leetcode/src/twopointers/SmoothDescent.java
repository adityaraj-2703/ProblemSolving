package twopointers;

public class SmoothDescent {
     public long getDescentPeriods(int[] prices) {
        int ind=0;
        int sum = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+1==prices[i-1]){
                continue;
            }
            else{
                sum += (i-ind)*(i-ind+1)/2;
                ind = i;
            }
        }
        return sum + (prices.length-ind)*(prices.length-ind+1)/2;
    }
    public static void main(String[] args) {
        int[] prices = {3,2,1,4};
        long res = new SmoothDescent().getDescentPeriods(prices);
        System.out.println(res);
    }

}
