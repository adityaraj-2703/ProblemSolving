package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            if(flag){
                break;
            }
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited);
                    flag = true;
                    break;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int[] dirX = {0,0,1,-1};
            int[] dirY = {1,-1,0,0};
            for(int i=0;i<4;i++){
                int nX = dirX[i]+temp.x;
                int nY = dirY[i]+temp.y;
                if(nX>=0 && nX<grid.length && nY>=0 && nY<grid[0].length){
                    if(visited[nX][nY]){
                        min = Math.min(min,temp.val);
                    }
                    else{
                        if(grid[nX][nY]==0){
                            grid[nX][nY]=1;
                            q.add(new Pair(nX,nY,temp.val+1));
                        }
                        
                    }   
                    
                }
            }
        }
        return min;

    }
    public void dfs(int[][] grid,int i,int j,boolean[][] visited){
        visited[i][j] = true;
        int[] dirX = {0,0,1,-1};
        int[] dirY = {1,-1,0,0};
        for(int k=0;k<4;k++){
            int nX = dirX[k]+i;
            int nY = dirY[k]+j;
            if(nX>=0 && nX<grid.length && nY>=0 && nY<grid[0].length && !visited[nX][nY] && grid[nX][nY]==1){
                dfs(grid,nX,nY,visited);
            }
        }

    }
    class Pair{
        int x;
        int y;
        int val;
        Pair(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        ShortestBridge s = new ShortestBridge();
        System.out.println(s.shortestBridge(grid));
    }

}
