package trie;

public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int count=0;
        int ten=0;
        int temp = n;
        while(temp>0){
            temp/=10;
            ten++;
        }
        for(int i=1;i<10;i++){
            count++;
            if(count==k){
                return i;
            }
            int val = i;
            Trie t = new Trie(i);
            for(int j=1;j<ten;j++){
                val = val*(int)Math.pow(10,j);
                if(val>n){
                    break;
                }
                count++;
                if(count==k){
                    return val;
                }
                t.children[0] = new Trie(val);
                int[] ans = buildTrie(t.children[0],count,val,n,k);
                if(ans[1]!=0 && ans[0]==k){
                    return ans[1];
                }
                count=ans[0];
            }
            
        }
        return -1;
        
    }
    public int[] buildTrie(Trie t,int count,int v,int n,int k){
        Trie curr = t;
        int currVal = v;
        int c = count;
        for(int i=1;i<=9;i++){
            int temp = currVal+i;
            if(temp > n){
                break;
            }
            if(curr.children[i]==null){
                    
                curr.children[i] = new Trie(temp);
                curr = curr.children[i];
                c++;
                if(c==k){
                    return new int[]{c,curr.val};
                }
            }
        }
        
        return new int[]{c,0};
        
    }
    class Trie{
        Trie[] children;
        int val;
        Trie(int val){
            this.children = new Trie[10];
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int n = 100;
        int k = 10;
        KthSmallestInLexicographicalOrder j = new KthSmallestInLexicographicalOrder();
        System.out.println(j.findKthNumber(n, k));
    }


}
