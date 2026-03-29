package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrageStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        Map<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair m1, Pair m2){
                return m2.f - m1.f;
            }
        });
        for(Map.Entry<Character,Integer> m : hm.entrySet()){
            Pair p = new Pair(m.getKey(),m.getValue(),-1);
            pq.add(p);
        }
        StringBuilder sb = new StringBuilder();
        Queue<Pair> q = new LinkedList<>();
        while(!pq.isEmpty()){
            Pair p  = pq.poll();
            sb.append(p.c);
            if( p.f-1 >0){
                q.add(new Pair(p.c,p.f-1,sb.length()-1));
            }
            if(!q.isEmpty()){
                if(sb.length() - q.peek().ind >=k){
                    Pair temp = q.poll();
                    pq.add(temp);
                }
            }
            

        }
        if(sb.length()!=s.length()){
            return "";
        }
        return sb.toString();
    }
    class Pair{
        char c;
        int f;
        int ind;
        Pair(char c,int f,int ind){
            this.c = c;
            this.f = f;
            this.ind = ind;
        }
    }
    public static void main(String[] args) {
        RearrageStringKDistanceApart obj = new RearrageStringKDistanceApart();
        System.out.println(obj.rearrangeString("aabbcc", 3));
    }

}
