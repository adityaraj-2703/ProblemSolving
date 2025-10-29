package matrix;

public class ReverseSubmatrix {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int s = x;
        int e = x + k -1;
        for(int i=x;i<x+k-1;i++){
            for(int j=y;j<y+k;j++){
                if(s==e){
                    break;
                }
                int temp = grid[i][j];
                grid[i][j] = grid[i+k-1][j];
                grid[i+k-1][j] = temp;
            }
            s++;
            e--;
            
        }
        return grid;
    }
    public static void main(String[] args) {
        int[][] grid = {
           {6,16,14},{1,2,19},{14,17,15},{18,7,6},{14,12,5}
        };
        int x = 2;
        int y = 1;
        int k = 2;
        ReverseSubmatrix rs = new ReverseSubmatrix();
        int[][] result = rs.reverseSubmatrix(grid, x, y, k);
        for(int[] row : result) {
            for(int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
