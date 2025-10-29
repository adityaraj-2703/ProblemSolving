package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> hm = new HashMap<>();
        int i=0;
        int j=0;
        int max = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(!hm.containsKey(c)){
                if(hm.size()<2){
                    hm.put(c,1);
                    max = Math.max(j-i+1,max);
                }
                else{
                    while(i<=j && hm.size()==2){
                        int temp = hm.get(s.charAt(i));
                        if(temp==1){
                            hm.remove(s.charAt(i));
                        }
                        else{
                            hm.put(s.charAt(i),temp-1);
                        }
                        i++;
                    }
                }
            }
            else{
                max = Math.max(j-i+1,max);
                hm.put(c,hm.get(c)+1);
            }
            j++;
            

        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtMostTwoDistinctChars().lengthOfLongestSubstringTwoDistinct("eceba"));
    }

}
