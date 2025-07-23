package graph;

import java.util.LinkedList;
import java.util.Queue;

public class LongestSubsequenceRepeatedKTimes {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] f = new int[26];
        for(int i=0;i<s.length();i++){
            f[s.charAt(i)-'a']++;
        }
        Queue<StringBuilder> q = new LinkedList<>();
        q.add(new StringBuilder());
        String res = "";
        while(!q.isEmpty()){
            StringBuilder temp = q.poll();
            res = temp.toString();
            for(int i=0;i<26;i++){
                if(f[i]>=k){
                    StringBuilder tempStr = new StringBuilder(temp);
                    tempStr.append((char)(i+97));
                    if(check(s,tempStr.toString(),k)){
                        q.add(tempStr);
                    }
                    
                }
            }
        }
        return res;
    }
    public boolean check(String str,String substr,int k){
        int i=0;
        int j=0;
        int count=0;
        while(i<str.length()){
            if(str.charAt(i)==substr.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
            if(j==substr.length()){
                j=0;
                count++;
                if(count==k){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "letsleetcode";
        int k = 2;
        LongestSubsequenceRepeatedKTimes l = new LongestSubsequenceRepeatedKTimes();
        System.out.println(l.longestSubsequenceRepeatedK(s, k));
    }

}
