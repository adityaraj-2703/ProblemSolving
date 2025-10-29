package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class BeforeAndAfterPuzzle {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        TreeSet<String> ans = new TreeSet<>();
        Map<String,List<String>> start = new HashMap<>();
        Map<String,Integer> end = new HashMap<>();
        for(int i=0;i<phrases.length;i++){
            String[] temp = phrases[i].split(" ");
            List<String> li = start.getOrDefault(temp[0],new ArrayList<>());
            li.add(phrases[i]);
            start.put(temp[0],li);
            end.put(phrases[i],i);
        }
        for(int i=0;i<phrases.length;i++){
            String[] temp = phrases[i].split(" ");
            if(start.containsKey(temp[temp.length-1]) && end.get(temp[temp.length-1])!=i){
                StringBuilder sb = new StringBuilder(phrases[i]);
                
                List<String> li = start.get(temp[temp.length-1]);
                for(int j=0;j<li.size();j++){
                    int ind = 0;
                    String t = li.get(j);
                    while(ind<t.length() && t.charAt(ind)!=' '){
                        ind++;
                    }
                    while(ind<t.length()){
                        sb.append(t.charAt(ind));
                        ind++;
                    }
                    ans.add(sb.toString());
                }
                
            }
        }
        List<String> ans1 = new ArrayList<>(ans);
        return ans1;
    }
    public static void main(String[] args) {
        BeforeAndAfterPuzzle obj = new BeforeAndAfterPuzzle();
        String[] phrases = {"a","b","a"};
        System.out.println(obj.beforeAndAfterPuzzles(phrases));
    }

}
