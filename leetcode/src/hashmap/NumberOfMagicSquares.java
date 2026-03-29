package hashmap;

import java.util.HashSet;
import java.util.Set;

public class NumberOfMagicSquares {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                Set<Integer> hs = new HashSet<>();
                hs.add(grid[i][j]);
                hs.add(grid[i][j+1]);
                hs.add(grid[i][j+2]);
                hs.add(grid[i+1][j]);
                hs.add(grid[i+1][j+1]);
                hs.add(grid[i+1][j+2]);
                hs.add(grid[i+2][j]);
                hs.add(grid[i+2][j+1]);
                hs.add(grid[i+2][j+2]);

                int a1 = grid[i][j]+grid[i][j+1]+grid[i][j+2];
                int a2 = grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
                int a3 = grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];

                int b1 = grid[i][j]+grid[i+1][j]+grid[i+2][j];
                int b2 = grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
                int b3 = grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];

                int c1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                int c2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];

                if(a1==a2 && a2==a3 && a3==b1 && b1==b2 && b2==b3 && b3==c1 && c1==c2 && hs.size()==9){
                    count++;
                }

            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {4,3,8,4},
            {9,5,1,9},
            {2,7,6,2}
        };
        int res = new NumberOfMagicSquares().numMagicSquaresInside(grid);
        System.out.println(res);
        
    }

}
