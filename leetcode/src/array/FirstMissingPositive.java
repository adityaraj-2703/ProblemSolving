package array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]<=0 || nums[i]>=nums.length || nums[i]==(i+1)){
                i++;
                continue;
            }
            else{
                int temp = nums[i];
                int temp1 = nums[nums[i]-1];
                nums[i] = temp1;
                nums[temp-1] = temp;
            }


        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

}
