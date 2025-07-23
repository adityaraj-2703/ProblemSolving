package greedy;

import java.util.Arrays;

public class MinimumDeletionsToMakeStringKSpecial {
    public int minimumDeletions(String word, int k) {
        int[] f = new int[26];
        for(int i=0;i<word.length();i++){
            f[word.charAt(i)-'a']++;
        }
        Arrays.sort(f);
        int i = 0;
        while(i<f.length && f[i]==0){
            i++;
        }
        int i1 = i;
        int j = 25;
        int ans = 0;
        int tot = 0;
        while(i<=j){
            if(f[j]-f[i]<=k){
                break;
            }
            ans = Math.min(f[j]-f[i]-k,f[i]);
            tot+=ans;
            i++;
        }
        int j1 = 25;
        int ans1 = 0;
        int tot1 = 0;
        while(i1<=j1){
            if(f[j1]-f[i1]<=k){
                break;
            }
            ans1 = f[j1]-f[i1]-k;
            tot1+=ans1;
            j1--;
        }
        return Math.min(tot1,tot);
    }
    public static void main(String[] args) {
        String s = "klllurlrrul";
        int k = 1;
        MinimumDeletionsToMakeStringKSpecial m = new MinimumDeletionsToMakeStringKSpecial();
        System.out.println(m.minimumDeletions(s, k));
    }

}
