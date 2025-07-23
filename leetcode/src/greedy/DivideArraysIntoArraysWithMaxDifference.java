package greedy;

import java.util.Arrays;

public class DivideArraysIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length/3][3];
        for(int i=0;i<nums.length-2;i+=3){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            ans[i/3][0] = nums[i];
            ans[i/3][1] = nums[i+1];
            ans[i/3][2] = nums[i+2];
            
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,8,7,9,3,5,1};
        DivideArraysIntoArraysWithMaxDifference d = new DivideArraysIntoArraysWithMaxDifference();
        int[][] ans = d.divideArray(arr, 2);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
