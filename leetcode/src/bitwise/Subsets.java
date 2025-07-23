package bitwise;

import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> al = new LinkedList<>();
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> temp = new LinkedList<>();
            for(int j=0;j<nums.length;j++){
                System.out.println(2&2);
                if((i & (1<<j)) != 0){
                    temp.add(nums[j]);
                }
            }
            al.add(temp);
        }
        return al;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Subsets().subsets(nums));
    }
}
