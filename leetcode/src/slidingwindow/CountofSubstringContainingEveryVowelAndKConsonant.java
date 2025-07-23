package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountofSubstringContainingEveryVowelAndKConsonant {
    public int countOfSubstrings(String word, int k) {
        int i=0;
        int j=0;
        Map<Character,Integer> hm = new HashMap<>();
        int count=0;
        while(j<word.length()){
            if(isVowel(word.charAt(j))){
                hm.put(word.charAt(j),hm.getOrDefault(word.charAt(j), 0)+1);
            }
            else{
                hm.put('k',hm.getOrDefault('k', 0)+1);
            }
            if(hm.getOrDefault('k',0)==k){
                if(hm.size()==6 || (k==0 && hm.size()==5)){
                    count++;
                    int t = -1;
                    if(!isVowel(word.charAt(i))){
                        t = hm.get('k');
                    }
                    else{
                        t = hm.get(word.charAt(i));
                    }
                    if(t==1){
                        hm.remove(word.charAt(i));
                    }
                    else{
                        hm.put(word.charAt(i),t-1);
                    }
                    i++;
                }
                else{
                    j++;
                }
            }
            else if(hm.getOrDefault('k', 0)<k){
                j++;
            }
            else if(hm.getOrDefault('k', 0)>k){
                hm = new HashMap<>();
                hm.put('k',1);
                i=j;
                j++;
            }
            else{
                j++;
            }
            
            
            
        }
        if((hm.size()==6 && hm.get('k')==k) || (k==0 && hm.size()==5)){
            count++;
        }
        return count;
    }
    public boolean isVowel(char c){
        return c =='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k = 1;
        CountofSubstringContainingEveryVowelAndKConsonant c = new CountofSubstringContainingEveryVowelAndKConsonant();
        System.out.println(c.countOfSubstrings(word, k));
    }

}
