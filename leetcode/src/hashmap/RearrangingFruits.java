package hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RearrangingFruits {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> f = new TreeMap<>();
        for(int i=0;i<basket1.length;i++){
            f.put(basket1[i],f.getOrDefault(basket1[i],0)+1);
        }
        for(int i=0;i<basket2.length;i++){
            f.put(basket2[i],f.getOrDefault(basket2[i],0)-1);
        }
        List<Integer> li = new ArrayList<>();
        for(Map.Entry<Integer,Integer> m : f.entrySet()){
            if(m.getValue() %2 !=0){
                return -1;
            }
            for(int i=0;i<Math.abs(m.getValue())/2;i++){
                li.add(m.getKey());
            }
        }
        int sum = 0;
        for(int i=0;i<li.size()/2;i++){
            sum += li.get(i);
        }
        return sum;
        
    }
    public static void main(String[] args) {
        int[] b1 = {4,2,2,2};
        int[] b2 = {1,4,1,2};
        System.out.println(new RearrangingFruits().minCost(b1, b2));

    }

}
