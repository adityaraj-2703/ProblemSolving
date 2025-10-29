package stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)!='/'){
                sb.append(path.charAt(i));
            }
            else{
                if(sb.toString().equals("..")){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                }
                else{
                    if(sb.length()>0){
                        st.push(sb.toString());
                    }
                    
                }
                sb = new StringBuilder();
            }

        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            
            ans.insert(0,st.pop());
            ans.insert(0,'/');
            
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath(path));
    }

}
