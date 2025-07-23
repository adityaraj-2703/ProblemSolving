package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    q.offer(new Pair(i,j,0));
                    grid[i][j] = Integer.MAX_VALUE;
                }
                else if(grid[i][j]==2){
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        Map<Pair,Set<Pair>> hm = new HashMap<>();
        while(!q.isEmpty()){
            Pair temp = q.poll();
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            bfs(temp,visited,grid);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                min = Math.min(min,grid[i][j]);
            }
        }
        return min;
        

    }
    public void bfs(Pair temp,boolean[][] visited,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(temp);
        while(!q.isEmpty()){
            Pair t  = q.poll();
            int[] dirX = {0,0,1,-1};
            int[] dirY = {1,-1,0,0};
            for(int i=0;i<4;i++){
                int nX = dirX[i]+t.a;
                int nY = dirY[i]+t.b;
                if(nX>=0 && nX<m && nY>=0 && nY<n && !visited[nX][nY] && grid[nX][nY]!=Integer.MAX_VALUE){
                    grid[nX][nY] += t.val+1;
                    q.offer(new Pair(nX,nY,t.val+1));
                    visited[nX][nY] = true;
                }
            }
        }
    }
    
    class Pair{
        int a;
        int b;
        int val;
        Pair(int a,int b,int val){
            this.a = a;
            this.b = b;
            this.val = val;
        }
       
    }
    public static void main(String[] args) {
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        System.out.println(s.shortestDistance(grid));
    }

}
