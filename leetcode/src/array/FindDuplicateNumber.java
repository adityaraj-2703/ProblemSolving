package array;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int nI = Math.abs(nums[i])-1;
            if(nums[nI]<0){
                return nums[i];
            }
            nums[nI]*=-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        FindDuplicateNumber obj = new FindDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums));
    }

}
