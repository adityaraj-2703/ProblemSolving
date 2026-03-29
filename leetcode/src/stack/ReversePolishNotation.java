package stack;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(isOp(tokens[i])){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                if(tokens[i].equals("+")){
                    st.push(a+b + "");
                }
                else if(tokens[i].equals("-")){
                    st.push(b-a + "");
                }
                else if(tokens[i].equals("*")){
                    st.push(a*b + "");
                }
                else if(tokens[i].equals("/")){
                    st.push(b/a + "");
                }
                
            }
            else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.peek());
    }
    public boolean isOp(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        int res = new ReversePolishNotation().evalRPN(tokens);
        System.out.println(res);
    }

}
