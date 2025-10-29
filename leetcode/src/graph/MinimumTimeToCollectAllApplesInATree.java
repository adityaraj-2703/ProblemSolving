package graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());

        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(0,visited,adjList,hasApple);
    }
    public int dfs(int i,boolean[] visited,List<List<Integer>> adjList,List<Boolean> hasApple){
        if(visited[i]){
            return 0;
        }
        visited[i] = true;
        int sum = 0;
        for(int k : adjList.get(i)){
            if(visited[k]){
                continue;
            }
            int temp = dfs(k,visited,adjList,hasApple);
            if(temp>0 || hasApple.get(k)){
                sum += 2 + temp;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {0,2},
                {1,4},
                {1,5},
                {2,3},
                {2,6}
        };
        List<Boolean> hasApple = new ArrayList<>();
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);
        System.out.println(new MinimumTimeToCollectAllApplesInATree().minTime(7,edges,hasApple));
    }

}
