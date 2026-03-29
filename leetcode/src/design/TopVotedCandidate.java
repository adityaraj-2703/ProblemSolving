package design;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
    int[] p;
    int[] time;
    public TopVotedCandidate(int[] persons, int[] time) {
        this.p = persons;
        this.time = time;
    }
    
    public int q(int t) {
        int l=0;
        int r = time.length;
        int ans = 0;
        while(l<=r){
            int m = l + (r-l)/2;
            if(time[m]<=t){
                ans = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        int max = 0;
        int w = -1;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<=ans;i++){
            hm.put(p[i],hm.getOrDefault(p[i],0)+1);
            if(max<=hm.get(p[i])){
                max = hm.get(p[i]);
                w = p[i];
            }

        }
        return w;
    }
    public static void main(String[] args) {
        int[] persons = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
        TopVotedCandidate t = new TopVotedCandidate(persons,times);
        System.out.println(t.q(3));
        System.out.println(t.q(12));
        System.out.println(t.q(25));
        System.out.println(t.q(15));
        System.out.println(t.q(24));
        System.out.println(t.q(8));
    }
}

