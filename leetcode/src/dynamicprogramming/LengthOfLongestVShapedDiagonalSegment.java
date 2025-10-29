package dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

public class LengthOfLongestVShapedDiagonalSegment {
    public int lenOfVDiagonal(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int count = bfs(grid,i,j);
                    max = Math.max(count,max);
                }
            }
        }
        return max;
    }
    public int bfs(int[][] grid,int i,int j){
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        // 0->i, 1->j, 2->dir, 3->count, 4->change, 5->last
        q.add(new int[]{i,j,-1,1,0});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            max = Math.max(max,temp[3]);
            int[] dirX = {-1,1,1,-1};
            int[] dirY = {1,1,-1,-1};
            for(int k=0;k<4;k++){
                int nx = temp[0]+dirX[k];
                int ny = temp[1]+dirY[k];
                if(nx<0 || ny<0 || nx==m || ny==n || visited[nx][ny]){
                    continue;
                }
                if(temp[2]==-1){
                    if(grid[nx][ny]==2){
                        q.add(new int[]{nx,ny,k,temp[3]+1,0,2});
                        visited[nx][ny] = true;
                        
                    }
                    continue;
                    
                }
                int last = grid[temp[0]][temp[1]];
                if(temp[4]!=0){
                    if(temp[2]!=k){
                        continue;
                    }
                    if(grid[nx][ny]==2 && last==0){
                        q.add(new int[]{nx,ny,k,temp[3]+1,temp[4]});
                        visited[nx][ny] = true;
                    }
                    else if(grid[nx][ny]==0 && last==2){
                        q.add(new int[]{nx,ny,k,temp[3]+1,temp[4]});
                        visited[nx][ny] = true;
                    }
                    else{
                        continue;
                    }
                }
                if(last==2 && grid[nx][ny]==0){
                    if(temp[2]!=k){
                        if(k==((temp[2]+1)%4)){
                            q.add(new int[]{nx,ny,k,temp[3]+1,1});
                            visited[nx][ny] = true;
                        }
                        
                    }
                    else{
                        q.add(new int[]{nx,ny,k,temp[3]+1,0});
                        visited[nx][ny] = true;
                    }
                }
                else if(last==0 && grid[nx][ny]==2){
                    if(temp[2]!=k){
                        if(k==((temp[2]+1)%4)){
                            q.add(new int[]{nx,ny,k,temp[3]+1,1});
                            visited[nx][ny] = true;
                        }
                    }
                    else{
                        q.add(new int[]{nx,ny,k,temp[3]+1,0});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        LengthOfLongestVShapedDiagonalSegment obj = new LengthOfLongestVShapedDiagonalSegment();
        int[][] grid = {{0,0,1,0},{0,2,2,0}};
        System.out.println(obj.lenOfVDiagonal(grid));
    }

}
