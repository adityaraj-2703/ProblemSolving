package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSpecialTriplets {
    public int specialTriplets(int[] nums) {
        Map<Integer,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> li = hm.getOrDefault(nums[i],new ArrayList<>());
            li.add(i);
            hm.put(nums[i],li);
        }
        int sum = 0;
        for(Map.Entry<Integer,List<Integer>> m : hm.entrySet()){
            if(!hm.containsKey(m.getKey()*2)){
                continue;
            }
            List<Integer> li = hm.get(m.getKey()*2);
            for(int f : m.getValue()){
                int left = find(li,f);
                if(left!=-1 && left<li.size()){
                    if(li.get(left)==f){
                        sum += (left-1) * (li.size()-left-1);
                    }
                    else{
                        sum += left * (li.size()-left);
                    }
                    
                }
            }
        }
        return sum;

    }
    public int find(List<Integer> li,int f){
        int l = 0;
        int r = li.size()-1;
        int ans = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            
            if(li.get(m)<=f){
                ans = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return ans==-1?-1:ans+1;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,0};
        int res = new CountSpecialTriplets().specialTriplets(nums);
        System.out.println(res);
    }

}
