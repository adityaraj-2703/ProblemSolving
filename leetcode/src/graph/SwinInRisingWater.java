package graph;

public class SwinInRisingWater {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int l = 0;
        int r = n*n;
        int ans = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(possible(grid,m)){
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
    public boolean possible(int[][] grid,int m){
        boolean[][] visited = new boolean[grid.length][grid.length];
        return dfs(grid,m,visited,0,0);
    }
    public boolean dfs(int[][] grid,int m,boolean[][] visited,int i,int j){
        int n = grid.length;
        if(i==m-1 && j==n-1){
            return true;
        }
        visited[i][j] = true;
        int[] dirX = {0,0,1,-1};
        int[] dirY = {1,-1,0,0};
        for(int k=0;k<4;k++){
            int nX = dirX[k] + i;
            int nY = dirY[k] + j;
            if(nX>=0 && nX<n && nY>=0 && nY<n && !visited[nX][nY]){
                if(grid[nX][nY]<=m){
                    if(dfs(grid,m,visited,nX,nY)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0,2},
                {1,3}
        };
        SwinInRisingWater s = new SwinInRisingWater();
        System.out.println(s.swimInWater(grid));
    }

}
