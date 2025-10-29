package graph;

public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        while(check(board)){
            for(int i=m-1;i>=0;i--){
                for(int j=0;j<n;j++){
                    if(board[i][j]==0){
                        continue;
                    }
                    boolean ch = false;
                    //up
                    if((i-1)>=0 && (i-2)>=0 && board[i-1][j]==board[i][j] && board[i-2][j]==board[i][j]){                   ch = true;
                        dfs(i-1,j,board[i][j],board,1);
                        
                    }
                    //left
                    if((j+1)<n && (j+2)<n && board[i][j+1]==board[i][j] && board[i][j+2]==board[i][j]){                
                        ch = true;
                        dfs(i,j+1,board[i][j],board,2);
                        
                    }
                    if(ch){
                        board[i][j] = 0;
                    }
                    
                    
                }
            }
            adjust(board);
        }
        return board;
    }
    public void dfs(int i,int j,int val,int[][] board,int dir){
        if(dir==1){
            if(i<0 || board[i][j]!=val){
                return;
            }
            board[i][j] = 0;
            dfs(i-1,j,val,board,dir);
        }
        else if(dir==2){
            if(j==board[0].length || board[i][j]!=val){
                return;
            }
            board[i][j] = 0;
            dfs(i,j+1,val,board,dir);
        }
        
        
    }
    public void adjust(int[][] board){

        int m = board.length;
        for(int j=0;j<board[0].length;j++){
            
            int ind = m-1;
            for(int i=m-1;i>=0;i--){
                if(board[i][j]!=0){
                    board[ind][j] = board[i][j];
                    ind--;
                }
            }
            for(int i=ind;i>=0;i--){
                board[i][j] = 0;
            }
            
        }
        
    }
    public boolean check(int[][] board){
        int m = board.length;
        int n = board[0].length;
        for(int i=m-1;i>=0;i--){
                for(int j=0;j<n;j++){
                    if(board[i][j]==0){
                        continue;
                    }
                    //up
                    if((i-1)>=0 && (i-2)>=0 && board[i-1][j]==board[i][j] && board[i-2][j]==board[i][j]){
                        return true;
                    }
                    //down
                    if((i+1)<m && (i+2)<m && board[i+1][j]==board[i][j] && board[i+2][j]==board[i][j]){
                        return true;
                    }
                    //left
                    if((j-1)>=0 && (j-2)>=0 && board[i][j-1]==board[i][j] && board[i][j-2]==board[i][j]){
                        return true;
                    }
                    //right
                    if((j+1)<n && (j+2)<n && board[i][j+1]==board[i][j] && board[i][j+2]==board[i][j]){
                        return true;
                    }
                    
                }
        }
        return false;
    }
    public static void main(String[] args) {
        
        int[][] board = {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        CandyCrush cc = new CandyCrush();
        int[][] res = cc.candyCrush(board);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }

}
