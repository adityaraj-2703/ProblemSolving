package prefixsum;

public class MaximumSideLengthofSquare {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = mat[0][0];
        for(int i=1;i<m;i++){
            sum[i][0]=sum[i-1][0]+mat[i][0];
        }
        for(int i=1;i<n;i++){
            sum[0][i]=sum[0][i-1]+mat[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x = i;
                int y = j;
                while(x<m && y<n){
                    if(sum[x][y]-sum[i][j]<=threshold){
                        max = Math.max(max,x-i+1);
                    }
                    else{
                        break;
                    }
                    x++;
                    y++;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumSideLengthofSquare m = new MaximumSideLengthofSquare();
        System.out.println(m.maxSideLength(new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}}, 4));
    }

}
