package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int i=0;
        int j=0;
        Map<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        while(j<nums.length){
            if(hm.containsKey(nums[j])){
                max = Math.max(sum,max);
                int k = hm.get(nums[j]);
                while(i<nums.length && i<=k){
                    sum-=nums[i];
                    i++;
                }
                sum += nums[j];
                hm.put(nums[j],j);
            }
            else{
                sum+=nums[j];
                hm.put(nums[j],j);
            }
            j++;
        }
        max = Math.max(sum,max);
        return max;

    }
    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        System.out.println( new MaximumErasureValue().maximumUniqueSubarray(nums));
    }

}
