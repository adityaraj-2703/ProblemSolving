package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                }
                
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            bfs(p,dp,grid);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j] + ", ");
                min = Math.min(min,dp[i][j]);
            }
            System.out.println();
        }
        return min;
    }
    public void bfs(Pair p,int[][] dp,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        visited[p.x][p.y] = true;
        q.add(p);
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int[] dirX = {0,0,1,-1};
            int[] dirY = {1,-1,0,0};
            for(int i=0;i<4;i++){
                int nX = dirX[i] + temp.x;
                int nY = dirY[i] + temp.y;
                if(nX>=0 && nX<m && nY>=0 && nY<n && !visited[nX][nY]){
                    dp[nX][nY] += temp.dist + 1;
                    visited[nX][nY] = true;
                    q.add(new Pair(nX,nY,temp.dist+1));
                }
            }

        }
    }
    class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };
        System.out.println(new BestMeetingPoint().minTotalDistance(grid));
    }

}
