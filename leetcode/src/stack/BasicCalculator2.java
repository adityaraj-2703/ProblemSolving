package stack;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        s = s.trim();
        if(s==null || s.length()==0) return 0;
        int num = 0;
        int last = 0;
        int res = 0;
        char op = '+';
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr>='0' && curr<='9'){
                num = num*10+(curr-'0');
            }
            if(curr!=' ' || i==s.length()-1){
                if(op=='+' || op=='-'){
                    res += last;
                    last = (op=='+')?num:-num;
                }
                else if(op=='*'){
                    last = last*num;
                }
                else if(op=='/'){
                    last = last / num;
                }
                op = curr;
                num = 0;
            }
        }
        res += last;
        return res;
    }
    public static void main(String[] args) {
        String s = "3+2*2";
        BasicCalculator2 b = new BasicCalculator2();
        System.out.println(b.calculate(s));
    }

}
