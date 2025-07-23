package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInaDirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<colors.length();i++){
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[colors.length()];
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            inDegree[edges[i][1]]++;
        }
        Queue<Pair> q = new LinkedList<>();
        int[][] dp = new int[colors.length()][26];
        int count=0;
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                q.add(new Pair(i,i));
                dp[i][colors.charAt(i)-'a']=1;
                count++;
            }
        }
        while(!q.isEmpty()){
            Pair temp = q.poll();
            for(int k : adjList.get(temp.ind)){
                inDegree[k]--;
                dp[temp.origin][k] = Math.max(dp[temp.origin][k]++,1);
                if(inDegree[k]==0){
                    q.add(new Pair(k,temp.origin));
                    count++;
                }
            }
        }
        if(count!=colors.length()){
            return -1;
        }
        int max = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                max= Math.max(dp[i][j],max);
            }
        }
        return max;



    }
    class Pair{
        int ind;
        int origin;;
        Pair(int ind,int origin){
            this.ind = ind;
            this.origin = origin;
        }
    }
    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        LargestColorValueInaDirectedGraph l = new LargestColorValueInaDirectedGraph();
        System.out.println(l.largestPathValue(colors, edges));
    }

}
