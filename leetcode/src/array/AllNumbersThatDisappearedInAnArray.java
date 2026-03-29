package array;

import java.util.ArrayList;
import java.util.List;

public class AllNumbersThatDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            


        }
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                li.add(i+1);
            }
        }
        return li;
    }
    public static void main(String[] args) {
        AllNumbersThatDisappearedInAnArray obj = new AllNumbersThatDisappearedInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(obj.findDisappearedNumbers(nums));
    }

}
