package graph;

public class CoutUnguardedCell {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int i=0;i<guards.length;i++){
            grid[guards[i][0]][guards[i][1]] = 1;
        }
        for(int i=0;i<guards.length;i++){
            grid[walls[i][0]][walls[i][1]] = 2;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    //up
                    int tempi = i;
                    while(tempi>=0 && grid[tempi][j]!=2){
                        grid[tempi][j] = 1;
                        tempi--;
                    }
                    //down
                    tempi = i;
                    while(tempi<m && grid[tempi][j]!=2){
                        grid[tempi][j] = 1;
                        tempi++;
                    }
                    //left
                    int tempj = j;
                    while(tempj>=0 && grid[i][tempj]!=2){
                        grid[i][tempj] = 1;
                        tempj--;
                    }
                    //right
                    tempj = j;
                    while(tempj<n && grid[i][tempj]!=2){
                        grid[i][tempj] = 1;
                        tempj++;
                    }
                }
            }   
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        CoutUnguardedCell c = new CoutUnguardedCell();
        int m = 4;
        int n = 6;
        int[][] guards = {
                {0,0},
                {1,1},
                {2,3}
        };
        int[][] walls = {
                {0,1},
                {2,2},
                {1,4}
        };
        System.out.println(c.countUnguarded(m,n,guards,walls));
    }

}
