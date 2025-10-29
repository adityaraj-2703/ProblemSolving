package matrix;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        boolean dir = true;
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = 0;
        int[] ans = new int[m*n];
        int ind = 0;
        while(ind<ans.length){
            int tempi = i;
            int tempj = j;
            if(dir){
                while(tempi>=0 && tempj<n){
                    ans[ind++] = mat[tempi][tempj];
                    tempi--;
                    tempj++;
                }
                if(tempj==n){
                    i +=1;
                    
                     
                }
                else{
                    j = tempj+1;
                }
                dir = !dir;

            }
            else{
                while(tempj>=0 && tempi<m){
                    ans[ind++] = mat[tempi][tempj];
                    tempi++;
                    tempj--;
                }
                if(tempi==m){
                    j +=1;
                     
                }
                else{
                    i = tempi+1;
                }
                dir = !dir;
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
        new DiagonalTraverse().findDiagonalOrder(mat);
    }

}
