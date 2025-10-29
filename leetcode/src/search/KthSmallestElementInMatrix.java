package search;

public class KthSmallestElementInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m-1][n-1];
        while(l<=r){
            int mid = l + (r-l)/2;
            int total = find(mid,matrix);
            if(total<k){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return l;
    }
    public int find(int mid,int[][] matrix){
        int sum  = 0;
        for(int i=0;i<matrix.length;i++){
            int l=0;
            int r = matrix[0].length-1;
            int ind = -1;
            while(l<=r){
                int m = l + (r-l)/2;
                if(matrix[i][m]<=mid){
                    ind = m;
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
            sum += ind+1;

        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };
        int k = 8;
        System.out.println(new KthSmallestElementInMatrix().kthSmallest(matrix, k));
    }

}
