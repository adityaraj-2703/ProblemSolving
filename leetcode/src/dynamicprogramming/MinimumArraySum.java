package dynamicprogramming;

public class MinimumArraySum {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        return find(nums,k,op1,op2,0);
    }
    public int find(int[] nums, int k, int op1, int op2,int i){
        if(i==nums.length){
            return 0;
        }
        int option1 = Integer.MAX_VALUE,
        option2=Integer.MAX_VALUE,
        option3=Integer.MAX_VALUE,
        option4=Integer.MAX_VALUE,
        option5=Integer.MAX_VALUE;
        option1 = nums[i] + find(nums,k,op1,op2,i+1);
        if(op1>0){
            option2 = (int)Math.ceil(nums[i]/2) + find(nums,k,op1-1,op2,i+1);
        }
        if(nums[i]>k && op2>0){
            option3 = nums[i]-k + find(nums,k,op1,op2-1,i+1);
        }
        if(op1>0 && op2>0){
            int temp1 = (int)Math.ceil(nums[i]/2);
            if(temp1>k){
                option4 = (temp1 - k) + find(nums,k,op1-1,op2-1,i+1);
            }
            int temp2 = nums[i]-k;
            if(temp2>0){
                option5 = (int)Math.ceil(temp2/2) + find(nums,k,op1-1,op2-1,i+1);
            }
            
        }
        return Math.min(option1,Math.min(option2,Math.min(option3,Math.min(option4,option5))));
        
    }
    public static void main(String[] args) {
        int[] nums = {2,8,3,19,3};
        int k = 3;
        int op1 = 1;
        int op2 = 1;
        int res = new MinimumArraySum().minArraySum(nums,k,op1,op2);
        System.out.println(res);
    }

}
