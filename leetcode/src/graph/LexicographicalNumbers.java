package graph;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> li = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,li,n);
        }
        
        return li;
    }
    public void dfs(int s,List<Integer> li,int n){
        if(s>n){
            return;
        }
        li.add(s);
        int temp = s;
        for(int i=0;i<=9;i++){
            temp = s*10+i;
            dfs(temp,li,n);
            temp = s;
        }
        
        
    }
    public static void main(String[] args) {
        int n = 13;
        LexicographicalNumbers l = new LexicographicalNumbers();

        List<Integer> li = l.lexicalOrder(n);
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i) + "");
        }
    }

}
