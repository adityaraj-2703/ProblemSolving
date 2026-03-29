package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountMentions {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<numberOfUsers;i++){
            hm.put(i,0);
        }
        int[] ans = new int[numberOfUsers];
        for(int i=0;i<events.size();i++){
            List<String> li = events.get(i);
            if(li.get(0).equals("MESSAGE")){
                List<Integer> al = new ArrayList<>();
                if(li.get(2).equals("ALL")){
                    for(int j=0;j<numberOfUsers;j++){
                        al.add(j);
                    }
                }
                else if(li.get(2).equals("HERE")){
                    for(int j=0;j<numberOfUsers;j++){
                        if(hm.get(j)<=Integer.parseInt(li.get(1))){
                            al.add(j);
                        }
                    }
                }
                else{
                    String[] str = li.get(2).split(" ");
                    for(int j=0;j<str.length;j++){
                        int temp = Integer.parseInt(str[j].substring(2,str[j].length()));
                        if(hm.get(temp)<=Integer.parseInt(li.get(1))){
                            al.add(temp);
                        }
                    }
                }
                addAll(ans,al);
                
                
            }
            else{
                int temp = Integer.parseInt(li.get(2));
                int ts = Integer.parseInt(li.get(1));
                hm.put(temp,ts+60);
            }
        }
        return ans;
    }
    public void addAll(int[] ans,List<Integer> li){
        for(int i=0;i<li.size();i++){
            ans[li.get(i)]++;
        }
    }
    public static void main(String[] args) {
        List<List<String>> events = new ArrayList<>();
        List<String> e1 = new ArrayList<>();
        e1.add("MESSAGE");
        e1.add("2");
        e1.add("HERE");
        events.add(e1);
        List<String> e2 = new ArrayList<>();
        e2.add("OFFLINE");
        e2.add("2");
        e2.add("1");
        events.add(e2);
        List<String> e3 = new ArrayList<>();
        e3.add("OFFLINE");
        e3.add("1");
        e3.add("0");
        events.add(e3);
        List<String> e4 = new ArrayList<>();
        e4.add("MESSAGE");
        e4.add("61");
        e4.add("HERE");
        events.add(e4);
        int numberOfUsers = 3;
        int[] res = new CountMentions().countMentions(numberOfUsers, events);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }

}
