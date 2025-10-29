package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            if(isDigit(s.charAt(i))){
                int temp = 0;
                while(isDigit(s.charAt(i))){
                    temp = temp*10 + (s.charAt(i)-'0');
                    i++;
                }
                st.push(temp + "");
            }
            else if(s.charAt(i)=='['){
                // i++;
                // StringBuilder tmp = new StringBuilder();
                // while(isCharacter(s.charAt(i))){
                //     tmp.append(s.charAt(i));
                //     i++;
                // }
                st.push("[");
                i++;
            }
            else if(s.charAt(i)==']'){

                StringBuilder tmp = new StringBuilder();
                while(!st.peek().equals("[")){
                    tmp.append(st.pop());
                }
                tmp = tmp.reverse();
                st.pop();
                int num = Integer.parseInt(st.pop());
                StringBuilder toPush = new StringBuilder();
                for(int j=0;j<num;j++){
                    toPush.append(tmp);
                }
                st.push(toPush.toString());
                i++;
            }
            else{
                st.push(s.charAt(i) + "");
                i++;
            }
        }

        while(st.size()>0){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
    public boolean isDigit(char c){
        return c>='0' && c<='9';
    }
    public boolean isCharacter(char c){
        return c>='a' && c<='z';
    }
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(new DecodeString().decodeString(s));
    }

}
