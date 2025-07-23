package stack;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        s.trim();
        int i=0;
        boolean flag = false;
        if(s.charAt(0)=='-'){
            flag = true;
            i++;
        }
        Stack<String> st = new Stack<>();
        while(i<s.length()){
            if(s.charAt(i)==' '){
                i++;
                continue;
            }
            
            else if(Character.isDigit(s.charAt(i))){
                int temp = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    temp = temp*10+(s.charAt(i)-'0');
                    i++;
                }
                if(!st.isEmpty() && (st.peek().equals("/")||st.peek().equals("*"))){
                    String op = st.pop();
                    int a = Integer.parseInt(st.pop());
                    if(op.equals("/")){
                        st.push(a/temp+"");
                    }
                    else{
                        st.push(a*temp+"");
                    }
                }
                else{
                    st.push(temp+"");
                }

            }
            else{
                st.push(s.charAt(i)+"");
                i++;
            }
        }
        int res = 0;
        while(st.size()>2){
            int a = Integer.parseInt(st.pop());
            String op = st.pop();
            res = (op.equals("-"))?res-a:res+a;
        }
        if(flag){
            return res - Integer.parseInt(st.peek());
        }
        return res+Integer.parseInt(st.peek());

    }
    public static void main(String[] args) {
        String s = "3+5 / 2";
        BasicCalculator2 b = new BasicCalculator2();
        System.out.println(b.calculate(s));
    }

}
