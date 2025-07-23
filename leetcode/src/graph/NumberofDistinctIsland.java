package graph;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIsland {
    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int total = dfs(grid,i,j,visited);
                    hs.add(total);
                }
            }
        }
        return hs.size();
    }
    public int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]==0){
            return 0;
        }
        visited[i][j] = true;
        return 1 
        + dfs(grid,i+1,j,visited) 
        + dfs(grid,i-1,j,visited) 
        + dfs(grid,i,j+1,visited) 
        + dfs(grid,i,j-1,visited);
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        NumberofDistinctIsland n = new NumberofDistinctIsland();
        System.out.println(n.numDistinctIslands(grid));
    }

}
