package stack;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int i=0;
        while(i<path.length()){
            if(path.charAt(i)=='/' ){
                i++;
                while(i<path.length() && path.charAt(i)=='/'){
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                while(i<path.length() && path.charAt(i)!='/' ){
                    sb.append(path.charAt(i));
                    i++;
                }
                //i++;
                if(sb.toString().equals("..")){
                    st.pop();
                }
                else{
                    st.push(sb.toString());
                }
            }
            
        }
        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){
            if(!st.peek().equals(".")){
                
                ans.insert(0, st.pop());
                ans.insert(0,"/");
            }
            
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath(path));
    }

}
