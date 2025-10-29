package array;

public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i=0;
        int j=0;
        int[] ans = new int[m*n];
        int ind = 0;
        boolean dir = true;
        while(i<m && j<n){
            ans[ind++] = mat[i][j];
            int tempi = -1;
            int tempj = -1;
            if(dir){
                tempi = i - 1;
                tempj = j + 1;
            }
            else{
                tempi = i + 1;
                tempj = j - 1;
            }
            if(tempi<0 || tempj<0 || tempi==m || tempj==n){
                if(dir){
                    if(j==n-1){
                        i += 1;
                    }
                    else{
                        j += 1;
                    }
                }
                else{
                    if(i==n-1){
                        j += 1;
                    }
                    else{
                        i += 1;
                    }
                }
                dir = !dir;
            }
            else{
                i = tempi;
                j = tempj;
            }
        }


        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] res = new DiagonalTraversal().findDiagonalOrder(mat);
        for(int t : res){
            System.out.print(t + ", ");
        }
    }

}
