package stack;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        int total = 0;
        String h = x>y?"ab":"ba";
        String l = x>y?"ba":"ab";

        String str = removeSubString(s,h);
        int count = (s.length()-str.length())/2;

        total += count*Math.max(x,y);

        String str1 = removeSubString(str,l);
        int count1 = (str.length()-str1.length())/2;

        total += count1*Math.min(x,y);
        return total;
    }

    public String removeSubString(String s,String pair){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==pair.charAt(1) && !st.isEmpty() && st.peek()==pair.charAt(0)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "cdbcbbaaabab";
        System.out.println(new MaximumScoreFromRemovingSubstrings().maximumGain(str, 4, 5));
    }
}
