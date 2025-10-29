package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpPrimeTeleportation {
    public int minJumps(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            hm.put(nums[i],i);
        }
        Map<Integer,Set<Integer>> adjMap = new HashMap<>();
        boolean[] prime = new boolean[max+1];
        prime[0] = true;
        prime[1] = true;
        for(int i=2;i<prime.length;i++){
            if(prime[i]){
                continue;
            }
            for(int j=2;i*j<=max;j++){
                prime[i*j] = true;
                if(hm.containsKey(i)){
                    Set<Integer> temphs = adjMap.getOrDefault(i,new HashSet<>());
                    if(hm.containsKey(i*j)){
                        temphs.add(hm.get(i*j));
                    }
                    adjMap.put(i,temphs);
                }
            }
        }
        for(Map.Entry<Integer,Set<Integer>> m : adjMap.entrySet()){
            System.out.println(m.getKey() + " - " + m.getValue());
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            if(tmp.ind==nums.length-1){
                return tmp.jump;
            }
            if(tmp.ind-1>=0){
                q.add(new Pair(tmp.ind-1,tmp.jump+1));
            }
            if(tmp.ind+1<nums.length){
                q.add(new Pair(tmp.ind+1,tmp.jump+1));
            }
            if(adjMap.containsKey(nums[tmp.ind])){
                for(int j : adjMap.get(nums[tmp.ind])){
                    q.add(new Pair(j,tmp.jump+1));
                    adjMap.remove(j);
                }
            }
        }
        return -1;

        
    }
    class Pair{
        int ind;
        int jump;
        Pair(int ind,int jump){
            this.ind = ind;
            this.jump = jump;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,9};
        System.out.println(new MinimumJumpPrimeTeleportation().minJumps(arr));
    }

}
