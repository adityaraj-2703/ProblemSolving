package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        //visited[n-1][0] = true;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(board.length-1,0,1,0));
        while(!q.isEmpty()){
            Info temp = q.poll();
            if(temp.val==n*n){
                return temp.step;
            }
            if(temp.val>n*n || visited[temp.r][temp.c]){
                continue;
            }
            
            visited[temp.r][temp.c] = true;
            for(int i=1;i<=6;i++){
                int x = temp.val+i;
                if(x>n*n){
                    continue;
                }
                int[] coordinates = find(x,n);
                
                if(board[coordinates[0]][coordinates[1]]!=-1){
                    x = board[coordinates[0]][coordinates[1]];
                    coordinates = find(x,n); 
                    
                }
                
                q.add(new Info(coordinates[0],coordinates[1],x,temp.step+1));
                
            }
        }
        return -1;
        
    }
    public int[] find(int x,int n){
        int row = 0;
        int col = 0;
        if(x%n==0){
            row = n-(x/n);
        }
        else{
            row = n-(x/n)-1;
        }
        int right = (n%2) ^ (row%2);
        if(right!=0){
            if(x%n!=0){
                col = (x%n) -1;
            }
            else{
                col = n-1;
            }
            
            
        }
        else{
            if(x%n!=0){
                col = n - (x%n);
            }
            else{
                col = 0;
            }
        }
        int[] res = new int[]{row,col};
        return res;
    }
    class Info{
        int r;
        int c;
        int val;
        int step;
        public Info(int r,int c,int val,int step){
            this.r = r;
            this.c = c;
            this.val = val;
            this.step = step;
        }
    }
    public static void main(String[] args) {
        int[][] board = {
            {2,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
        };
        SnakesAndLadders s = new SnakesAndLadders();
        System.out.println(s.snakesAndLadders(board)); // Output: 4
    }

}
