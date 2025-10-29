package search;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int i=0;i<weights.length;i++){
            r += weights[i];
        }
        int ans = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(check(weights,days,m)){
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
    public boolean check(int[] weights,int days,int m){
        int count = 1;
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>m){
                return false;
            }
            sum += weights[i];
            
            if(sum>=m){
                count++;
                sum=weights[i];
            }
            
        }
        return count<=days;
    }
    public static void main(String[] args) {
        int[] weights = {10,50,100,100,50,100,100,100};
        int days = 5;
        System.out.println(new ShipWithinDays().shipWithinDays(weights, days));
    }

}
