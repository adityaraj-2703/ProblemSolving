package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LexicographicalMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        char[] c = s.toCharArray();
        Map<Character,Stack<Integer>> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='*'){
                Stack<Integer> st = hm.getOrDefault(s.charAt(i),new Stack<>());
                st.push(i);
                hm.put(s.charAt(i),st);
            }
            else{
                for(int j=0;j<26;j++){
                    if(hm.get((char)(j+97))!=null && !hm.get((char)(j+97)).isEmpty()){
                        int t = hm.get((char)(j+97)).pop();
                        c[t] = '*';
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c.length;i++){
            if(c[i]!='*'){
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "d*";
        LexicographicalMinimumStringAfterRemovingStars l = new LexicographicalMinimumStringAfterRemovingStars();
        System.out.println(l.clearStars(s));
    }
}
