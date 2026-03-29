package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsOfString {
    public List<Integer> findAnagrams(String s, String p) {
        int i=0;
        int j=0;
        int[] f1 = new int[26];
        for(int k=0;k<p.length();k++){
            f1[p.charAt(k)-'a']++;
        }
        List<Integer> li = new ArrayList<>();
        int[] f2 = new int[26];
        while(j<s.length()){
            f2[s.charAt(j)-'a']++;
            if(check(f1,f2)){
                int a = i;
                while(check(f1,f2)){
                    a = i;
                    i++;
                    f2[s.charAt(i)-'a']--;
                }
                li.add(a);
            }
            j++;
        }
        return li;

    }
    public boolean check(int[] f1,int[] f2){
        for(int i=0;i<26;i++){
            if(f1[i]<f2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        FindAllAnagramsOfString obj = new FindAllAnagramsOfString();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));  
    }

}
