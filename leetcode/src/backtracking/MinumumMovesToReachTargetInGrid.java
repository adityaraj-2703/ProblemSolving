package backtracking;

public class MinumumMovesToReachTargetInGrid {
    public int minMoves(int sx, int sy, int tx, int ty) {
        int temp = minMovesUtil(sx,sy,tx,ty,0);
        return temp==Integer.MAX_VALUE?-1:temp;
    }
    public int minMovesUtil(int sx,int sy,int tx,int ty,int min){
        if(sx==tx && sy==ty){
            return min;
        }
        if(sx==sy){
            return Integer.MAX_VALUE;
        }
        if(sx>tx || sy>ty){
            return Integer.MAX_VALUE;
        }
        int temp = Math.max(sx,sy);
        return Math.min(minMovesUtil(sx+temp,sy,tx,ty,min+1),minMovesUtil(sx,sy+temp,tx,ty,min+1));
    }
    public static void main(String[] args) {
        int sx = 0;
        int sy = 1;
        int tx = 2;
        int ty = 3;
        MinumumMovesToReachTargetInGrid m = new MinumumMovesToReachTargetInGrid();
        System.out.println((m.minMoves(sx, sy, tx, ty)));
    }

}
