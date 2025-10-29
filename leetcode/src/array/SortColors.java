package array;

public class SortColors {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int k=0;
        while(i<j && k<nums.length){
            if(nums[k]==2){
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
            }
            else if(nums[k]==0){
                nums[k] = nums[i];
                nums[i] = 0;
                i++;
                k++;
            }
            else{
                k++;
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new SortColors().sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        
    }
}
