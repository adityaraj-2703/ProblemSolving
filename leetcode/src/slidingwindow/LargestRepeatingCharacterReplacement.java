package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LargestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int i=0;
        int j=0;
        int res = 0;
        while(i<=j && j<s.length()){
            f[s.charAt(j)-'A']++;
            if((j-i+1) - findMax(f) <=k ){
                res = Math.max(res,j-i+1);
            }
            else{
                f[s.charAt(i)-'A']--;
                i++;
            }
            j++;
        }
        return res;
    }
    public int findMax(int[] f){
        int max = 0;
        for(int i=0;i<26;i++){
            max = Math.max(f[i],max);
        }   
        return max;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        LargestRepeatingCharacterReplacement l = new LargestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement(s, 1));
    }

}
