package hashmap;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Integer,Character> hm = new HashMap<>();
        for(int i=0;i<order.length();i++){
            hm.put(i+1,order.charAt(i));
        }
        int[] f = new int[26];
        for(int i=0;i<s.length();i++){
            f[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=order.length();i++){
            int temp = f[hm.get(i)-'a'];
            while(temp>0){
                sb.append(hm.get(i));
                temp--;
            }
            f[hm.get(i)-'a'] = 0;
        }
        for(int i=0;i<26;i++){
            if(f[i]!=0){
                sb.append((char) (i+97));
            }
            
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        CustomSortString obj = new CustomSortString();
        String order = "cba";
        String s = "abcd";
        System.out.println(obj.customSortString(order, s));
    }
}
