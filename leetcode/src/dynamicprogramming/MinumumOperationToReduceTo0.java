package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class MinumumOperationToReduceTo0 {
    public int minOperations(int n) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        Set<Integer> hs = new HashSet<>();
        hs.add(0);
        for(int i=0;i<10;i++){
            if(1<<i == n){
                return 0;
            }
            hs.add(1<<i);
        }
        backtrack(n,min,0,hs);
        return min[0];
    }
    public void backtrack(int n,int[] min,int s,Set<Integer> hs){
        if(n<0 || n>100000){
            return;
        }
        if(hs.contains(n)){
            min[0] = Math.min(min[0],s);
            return;
        }
        for(int i=1;i<31;i++){
            int temp = 1<<i;
            int subN = n - temp;
            int addN = n + temp;
            backtrack(subN,min,s+1,hs);
            backtrack(addN,min,s+1,hs);
        }
    }
    public static void main(String[] args) {
        MinumumOperationToReduceTo0 m = new MinumumOperationToReduceTo0();
        System.out.println(m.minOperations(39));
    }

}
