package search;

import java.util.Arrays;

public class MaximumCapacirtyWithinBudget {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] m = new int[costs.length][2];
        for(int i=0;i<n;i++){
            m[i][0] = costs[i];
            m[i][1] = capacity[i];
        }
        Arrays.sort(m,(a,b)->a[0]-b[0]);
        int[] pre = new int[n];
        pre[0] = m[0][1];
        for(int i=1;i<n;i++){
            pre[i] = Math.max(pre[i-1],m[i][1]);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int cap = m[i][1];
            if(m[i][0]<budget){
                max = Math.max(max,cap);
            }
            else{
                break;
            }
            int b = budget-m[i][0];
            int l = 0;
            int r = i-1;
            int ind = -1;
            while(l<=r){
                int mid = r - (r-l)/2;
                if(m[mid][0]<b){
                    ind = mid;
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
            if(ind!=-1){
                max = Math.max(max,cap+pre[ind]);
            }
            
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumCapacirtyWithinBudget m = new MaximumCapacirtyWithinBudget();
        System.out.println(m.maxCapacity(new int[]{4,8,5,3}, new int[]{1,5,2,7}, 8));
    }

}
