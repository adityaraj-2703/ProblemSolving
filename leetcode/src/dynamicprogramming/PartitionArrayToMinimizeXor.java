package dynamicprogramming;

public class PartitionArrayToMinimizeXor {
    public static int minXor(int[] nums, int k) {
        
        int[] min = new int[2];
        min[0] = Integer.MAX_VALUE;
        min[1] = nums[0];
        return dp(nums,k,1,min,nums[0]);
    }
    public static int dp(int[] nums,int k,int i,int[] min,int curr){
        if(i==nums.length){
            min[0] = Math.min(min[0],min[1]);
            return min[0];
        }
        if(k==1){
            while(i<nums.length){
                curr ^=nums[i];
                i++;
            }
            min[1] = Math.max(min[1],curr);
            min[0] = Math.min(min[0],min[1]);
            return min[0];
        }
        return Math.min(dp(nums,k-1,i+1,min,curr),dp(nums,k,i+1,min,curr^nums[i]));
        
    }
    public static void main(String[] args) {
        int[] arr = {2,3,3,2};
        System.out.println(PartitionArrayToMinimizeXor.minXor(arr, 2));

    }

}
