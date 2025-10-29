package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {
        Pair p = new Pair(-1,new HashSet<>());
        dfs(s,p,0,0,0,new StringBuilder());
        return new ArrayList<>(p.hs);
    }
    public void dfs(String s, Pair p,int op,int cl,int ind,StringBuilder sb){
        if(ind==s.length()){
            if(op==cl){
                if(p.length<sb.length()){
                    Pair temp = new Pair(sb.length(),new HashSet<>());
                    temp.hs.add(new String(sb.toString()));
                    p = temp;
                }
                else if(p.length==sb.length()){
                    p.hs.add(new String(sb.toString()));
                }
            }
            return;
        }
        if(s.charAt(ind)=='('){
            sb.append('(');
            dfs(s,p,op+1,cl,ind+1,sb);
            sb.deleteCharAt(sb.length()-1);
            dfs(s,p,op,cl,ind+1,sb);
        }
        else if(s.charAt(ind)==')'){
            
            if(cl<op){
                sb.append(')');
                dfs(s,p,op,cl+1,ind+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                dfs(s,p,op,cl,ind+1,sb);
            }
            
        }
        else{
            sb.append(s.charAt(ind));
            dfs(s,p,op,cl,ind+1,sb);
        }
    }
    class Pair{
        int length;
        Set<String> hs;
        Pair(int length,Set<String> hs){
            this.length = length;
            this.hs = hs;
        }
    }
    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(new RemoveInvalidParantheses().removeInvalidParentheses(s));
    }

}
