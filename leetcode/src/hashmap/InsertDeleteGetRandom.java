package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
    Map<Integer,Integer> hm;
    List<Integer> li;
    Random r;
    public InsertDeleteGetRandom() {
        hm = new HashMap<>();
        li = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        li.add(val);
        hm.put(val,li.size());
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }
        int ind = hm.get(val)-1;
        int valLast = li.get(li.size()-1);
        hm.remove(val);
        hm.put(valLast,ind);
        li.set(ind,valLast);
        li.remove(li.size()-1);
        return true;
    }
    
    public int getRandom() {
        return li.get(r.nextInt(li.size()));
    }
    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }

}
