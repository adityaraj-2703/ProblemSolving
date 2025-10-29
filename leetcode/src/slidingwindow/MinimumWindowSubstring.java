package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character,Integer> hm1 = new HashMap<>();
        Map<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm1.put(t.charAt(i),hm1.getOrDefault(t.charAt(i),0)+1);
        }
        int min = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        String ans = "";
        while(i<s.length() && j<s.length()){
            if(check(hm1,hm2)){
                if(min>j-i+1){
                    min = j-i+1;
                    ans = s.substring(i,j);
                }
                int temp = hm2.get(s.charAt(i));
                if(temp>1){
                    hm2.put(s.charAt(i),temp-1);
                }
                else{
                    hm2.remove(s.charAt(i));
                }
                i++;

            }
            else{
                hm2.put(s.charAt(j),hm2.getOrDefault(s.charAt(j),0)+1);
                j++;
            }
            
        }
        while(i<s.length() && check(hm1,hm2)){
            if(min>j-i+1){
                    min = j-i+1;
                    ans = s.substring(i,j);
                }
                int temp = hm2.get(s.charAt(i));
                if(temp>1){
                    hm2.put(s.charAt(i),temp-1);
                }
                else{
                    hm2.remove(s.charAt(i));
                }
                i++;
        }
        if(min>j-i){
            min = j-i;
            ans = s.substring(i-1,j);
        }
        return ans;
    }
    public boolean check(Map<Character,Integer> hm1,Map<Character,Integer> hm2){
        for(Map.Entry<Character,Integer> m : hm1.entrySet()){
            if(!hm2.containsKey(m.getKey()) || hm2.get(m.getKey())<m.getValue()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

}
