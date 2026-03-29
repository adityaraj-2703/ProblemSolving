package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> li = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        lds(nums,li,temp,0,1);
        return li;
    }
    public void lds(int[] nums,List<Integer> li, List<Integer> temp,int i,int last){
        if(i==nums.length){
            if(temp.size()>li.size()){
                li = new ArrayList<>(temp);
                
            }
            return;
        }
        if(nums[i]%last==0){
            temp.add(nums[i]);
            lds(nums,li,temp,i+1,nums[i]);
            temp.remove(temp.size()-1);
        }
        lds(nums,li,temp,i+1,last);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> res = new LargestDivisibleSubset().largestDivisibleSubset(nums);
        System.out.println(res);
    }

}
