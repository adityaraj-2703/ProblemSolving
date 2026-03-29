package string;

public class DeleteColumnsToMakeSorted2 {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        if(m<=2){
            return 0;
        }
        int n = strs[0].length();
        boolean[] dir = new boolean[n];
        for(int i=0;i<n;i++){
            if(strs[1].charAt(i)>strs[0].charAt(i)){
                dir[i]  = true;
            }
        }
        int count = 0;
        for(int j=0;j<n;j++){
            for(int i=2;i<m;i++){
                if(dir[j]){
                    if(strs[i].charAt(j)<strs[i-1].charAt(j)){
                        count++;
                        break;
                    }
                }
                if(!dir[j]){
                    if(strs[i].charAt(j)<strs[i-1].charAt(j)){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String[] strs = {"xc","yb","za"};
        int res = new DeleteColumnsToMakeSorted2().minDeletionSize(strs);
        System.out.println(res);
        
    }

}
