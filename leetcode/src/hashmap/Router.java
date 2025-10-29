package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Router {
    Map<Integer,Set<Integer>> srcToDest = new HashMap<>();
    Map<Integer,Set<Integer>> destToTs = new HashMap<>();
    Queue<Packet> pq = new LinkedList<>();
    int limit;
    public Router(int memoryLimit) {
        this.limit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Set<Integer> hs1 = srcToDest.getOrDefault(source,new HashSet<>());
        if(!hs1.isEmpty() && hs1.contains(destination)){
            Set<Integer> hs = destToTs.getOrDefault(destination,null);
            if(hs!=null && hs.contains(timestamp)){
                return false;
                
            }
        }
        if(pq.size()==limit){
            pq.poll();
        }
        pq.add(new Packet(source,destination,timestamp));
        hs1.add(destination);
        srcToDest.put(source,hs1);
        Set<Integer> hs = destToTs.getOrDefault(destination,new HashSet<>());
        hs.add(timestamp);
        destToTs.put(destination, hs);
        return true;

    }
    
    public int[] forwardPacket() {
        if(pq.isEmpty()){
            return new int[0];
        }
        Packet p = pq.poll();
        return new int[]{p.src,p.dest,p.ts};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> al = new ArrayList<>(destToTs.get(destination));
        if(al.size()==0){
            return 0;
        }
        Collections.sort(al);
        int l=0;
        int r = al.size()-1;
        int st = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(al.get(m)>=startTime){
                st = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        l=0;
        r = al.size()-1;
        int en = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(al.get(m)<=endTime){
                en = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return en-st+1;
    }
    public static void main(String[] args) {
        Router obj = new Router(4);
        System.out.println(obj.addPacket(4,2,1));
        System.out.println(obj.addPacket(3,2,1));
        
        // int[] param_2 = obj.forwardPacket();
        // for(int i=0;i<param_2.length;i++){
        //     System.out.print(param_2[i]+" ");
        // }
        //System.out.println(obj.addPacket(5,2,110));
        
        System.out.println(obj.getCount(2,1,1));
    }
}


class Packet{
    int src;
    int dest;
    int ts;
    Packet(int src,int dest,int ts){
        this.src = src;
        this.dest = dest;
        this.ts = ts;
    }
}
