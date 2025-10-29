package array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int count = 0;
        while(i<nums.length && nums[i]!=val){
            i++;
        }
        int j = i;
        while(i<nums.length && j<nums.length){
            if(nums[j]==val){
                j++;
                count++;
            }
            else{
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int count = new RemoveElement().removeElement(arr,2);
        System.out.println(count);
    }
}
