package matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;;
        int n = grid[0].length;
        for(int k=m-1;k>=0;k--){
            int i = k;
            int j = 0;
            List<Integer> li = new ArrayList<>();
            while(i<m && j<n){
                li.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(li,(a,b)->b-a);
            i=k;
            j=0;
            int ind = 0;
            while(i<m && j<n){
                grid[i][j] = li.get(ind++);
                System.out.print(grid[i][j]+" ");
                i++;
                j++;
            }
            System.out.println("first part done");
        }
        for(int k=n-1;k>=1;k--){
            int i = 0;
            int j = k;
            List<Integer> li = new ArrayList<>();
            while(i<m && j<n){
                li.add(grid[i][j]);
                
                i++;
                j++;
            }
            Collections.sort(li);
            i=0;
            j=k;
            int ind = 0;
            while(i<m && j<n){
                grid[i][j] = li.get(ind++);
                System.out.print(grid[i][j]+" ");
                i++;
                j++;
            }
            System.out.println();
        }
        return grid;
    }
    public static void main(String[] args) {
        SortMatrixByDiagonals obj = new SortMatrixByDiagonals();
        int[][] grid = {{1,7,3},{9,8,2},{4,5,6}};
        obj.sortMatrix(grid);
    }

}
