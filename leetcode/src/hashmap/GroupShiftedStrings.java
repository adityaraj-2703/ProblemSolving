package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strings.length];
        Arrays.sort(strings);
        for(int i=0;i<strings.length;i++){
            List<String> al = new ArrayList<>();
            al.add(strings[i]);
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            for(int j=i+1;j<strings.length;j++){
                if(visited[j]){
                    continue;
                }
                String a = strings[i];
                String b = strings[j];
                if(a.length()!=b.length()){
                    continue;
                }
                int diff = b.charAt(0)-a.charAt(0);
                if(diff<0){
                    diff = 26-diff;
                }
                int x = 1;
                int y = 1;
                boolean flag = true;
                while(x<strings[i].length()){
                    char c1 = strings[i].charAt(x);
                    char c2 = strings[j].charAt(x);
                    int tempDiff = c2-c1;
                    if(tempDiff<0){
                        tempDiff = 26+tempDiff;
                    }
                    if(diff!=tempDiff){
                        flag = false;
                        break;

                    }
                    x++;
                }
                if(flag){
                    al.add(strings[j]);
                    visited[j] = true;
                }
            }
            ans.add(al);
        }
        return ans;
    }
    public List<List<String>> groupStrings2(String[] strings) {
        Map<Integer,List<String>> hm = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            int temp = hash(strings[i]);
            List<String> al = hm.getOrDefault(temp,new ArrayList<>());
            al.add(strings[i]);
            hm.put(temp,al);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> m : hm.entrySet()){
            ans.add(m.getValue());
        }
        return ans;
    }
    public int hash(String s){
        
        int shift = s.charAt(0)-'a';
        int res = shift;
        for(int i=1;i<s.length();i++){
            int newShift = (s.charAt(i)-'a') - shift;
            res+=newShift;
        }
        res += s.length()*50;
        return res;
    }
    public static void main(String[] args) {
        GroupShiftedStrings obj = new GroupShiftedStrings();
        String[] strings = {"ab","ba"};
        System.out.println(obj.groupStrings2(strings));
    }

}
