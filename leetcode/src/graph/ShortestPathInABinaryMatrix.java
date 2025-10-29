package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        if(grid[0][0]!=0){
            return -1;
        }
        dp[0][0] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int[] dirX={1,-1,0,0,1,-1,1,-1};
            int[] dirY={0,0,1,-1,-1,1,1,-1};
            for(int i=0;i<8;i++){
                int nX = p.x + dirX[i];
                int nY = p.y + dirY[i];
                if(nX>=0 && nX<n && nY>=0 && nY<n && grid[nX][nY]==0 && dp[nX][nY]>(p.dist+1)){
                    dp[nX][nY]=p.dist+1;
                    q.add(new Pair(nX,nY,dp[nX][nY]));
                }
                
            }
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j] + " , ");
            }
            System.out.println();
        }
       
        int x = n-1;
        int y = n-1;
        StringBuilder path = new StringBuilder();
        path.append(x+":" +y +",");
        while(x>0 && y>0){
            int[] dirX={1,-1,0,0,1,-1,1,-1};
            int[] dirY={0,0,1,-1,-1,1,1,-1};
            for(int i=0;i<8;i++){
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && dp[nx][ny]!=Integer.MAX_VALUE && dp[nx][ny]+1 == dp[x][y]){
                    path.append(nx+":" +ny +",");
                    x = nx;
                    y = ny;
                    break;
                }
            }
            
        }
        System.out.println(path);
        return dp[n-1][n-1]==Integer.MAX_VALUE?-1:dp[n-1][n-1];
        
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
            {0,0,0},
            {1,1,0},
            {1,1,0}
        };
        System.out.println(new ShortestPathInABinaryMatrix().shortestPathBinaryMatrix(grid));
    }


}
