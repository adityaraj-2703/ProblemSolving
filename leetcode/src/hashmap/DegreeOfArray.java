package hashmap;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Pair> hm = new HashMap<>();
        int max =0 ;
        int len = -1;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                Pair p = hm.get(nums[i]);
                p.en = i;
                p.f +=1;
            }
            else{
                Pair p = new Pair(i,i,1);
                hm.put(nums[i],p);
            }
            Pair p1 = hm.get(nums[i]);
            if(max<p1.f){
                max = p1.f;
                len = p1.en-p1.st+1;
            }
        }
        return len;
    }
    class Pair{
        int st;
        int en;
        int f;
        Pair(int st,int en,int f){
            this.st = st;
            this.en = en;
            this.f = f;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        int res = new DegreeOfArray().findShortestSubArray(nums);
        System.out.println(res);
    }

}
