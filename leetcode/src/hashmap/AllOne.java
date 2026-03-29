package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    Map<String,Integer> hm;
    Map<Integer,Set<String>> f;
    int max = -1;
    int min = -1;
    public AllOne() {
        hm = new HashMap<>();
        f = new HashMap<>();
    }
    
    public void inc(String key) {
        if(!hm.containsKey(key)){
            hm.put(key,1);
            Set<String> hs = f.getOrDefault(1,new HashSet<>());
            hs.add(key);
            f.put(1,hs);
            
            min = 1;
            if(max<1){
                max=1;
            }
            return;
        }
        int val = hm.get(key);
        hm.put(key,val+1);
        Set<String> hs = f.get(val);
        hs.remove(key);
        if(hs.size()>0){
            f.put(val,hs);
        }
        else{
            f.remove(val);
        }
        Set<String> newHs = f.getOrDefault(val+1,new HashSet<>());
        newHs.add(key);
        f.put(val+1,newHs);

        max = Math.max(max,val+1);

    }
    
    public void dec(String key) {
        int val = hm.get(key);
        hm.put(key,val-1);
        Set<String> hs = f.get(val);
        hs.remove(key);
        if(hs.size()>0){
            f.put(val,hs);
        }
        else{
            f.remove(val);
        }
        Set<String> newHs = f.getOrDefault(val-1,new HashSet<>());
        newHs.add(key);
        f.put(val-1,newHs);

        min = Math.min(min,val-1);
    }

    public String getMaxKey() {
        if(f.get(max).size()>0){
            return f.get(max).iterator().next();
        }
        return "";
    }
    
    public String getMinKey() {
        if(f.get(min)!=null && f.get(min).size()>0){
            return f.get(min).iterator().next();
        }
        return "";
        
    }
    
    
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}

