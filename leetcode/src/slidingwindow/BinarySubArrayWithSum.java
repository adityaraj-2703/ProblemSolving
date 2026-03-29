package slidingwindow;

public class BinarySubArrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int i=0;
        int j=0;
        int count = 0;
        while(j<nums.length){
            sum += nums[j];
            while(sum>=goal && i<=j){
                count++;
                sum-=nums[i++];
            }
            j++;
        }
        return count;
        
    }
    public static void main(String[] args) {
        BinarySubArrayWithSum b = new BinarySubArrayWithSum();
        System.out.println(b.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));

        
    }

}
