package bitmask;

import java.util.ArrayList;
import java.util.List;

public class ClosestSubsequenceSum {
    public int minAbsDifference(int[] nums, int goal) {
        List<Integer> li1 = find(nums,0,nums.length/2);
        List<Integer> li2 = find(nums,nums.length/2,nums.length);
        for(int i=0;i<li1.size();i++){
            System.out.println(li1.get(i));
        }

        

        return -113489934;
        
    }
    public List<Integer> find(int[] nums,int l,int r){
        List<Integer> li1 = new ArrayList<>();
        System.out.println((r-l) + ":sum of range");
        for(int i=0;i<=(int)Math.pow(2,(r-l));i++){
            int sum = 0;
            for(int j=l;j<r;j++){
                if((i & (1<<(j-l))) > 0){
                    sum+=nums[j];
                    
                }
            }
            
            li1.add(sum);
            
        }
        return li1;
    }
    public static void main(String[] args) {
        ClosestSubsequenceSum obj = new ClosestSubsequenceSum();
        int[] nums = {5, -7, 3, 5, 7};
        System.out.println(obj.minAbsDifference(nums, 10));
    }

}
