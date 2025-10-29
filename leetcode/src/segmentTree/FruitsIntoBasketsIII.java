package segmentTree;

public class FruitsIntoBasketsIII {
    private int[] segmentTree;
    private int n;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        segmentTree = new int[4*n];
        build(baskets,0,n-1,0);
        int count = 0;
        for(int i=0;i<fruits.length;i++){
            if(check(fruits[i],0,n-1,0)==-1){
                count++;
            }
        }
        return count;
    }

    private void build(int[] baskets,int low, int high,int ind){
        if(low==high){
            segmentTree[ind] = baskets[low];
        }
        else{
            int m = (low + high) / 2;
            build(baskets,low,m,ind*2+1);
            build(baskets,m+1,high,ind*2+2);
            segmentTree[ind] = Math.max(segmentTree[2*ind+1],segmentTree[2*ind+2]);
        }
        
    }

    private int check(int fruit,int low,int high,int ind){
        if(segmentTree[ind]<fruit){
            return -1;
        }
        if(low==high){
            segmentTree[ind] = -1;
            return 1;
        }
        int m = (low + high) / 2;
        int res = 0;
        if(segmentTree[2*ind+1]>=fruit){
            res = check(fruit,low,m,2*ind+1);
        }
        else{
            res = check(fruit,m+1,high,2*ind+2);
        }
        segmentTree[ind] = Math.max(segmentTree[2*ind+1],segmentTree[2*ind+2]);
        return res;
    }
    public static void main(String[] args) {
        int[] fruits = {41,43,94};
        int[] baskets = {39,10,47};
        FruitsIntoBasketsIII f = new FruitsIntoBasketsIII();
        System.out.println(f.numOfUnplacedFruits(fruits, baskets));
    }

}
