package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionString {

    public static List<String> partitionString(String s) {
        HashSet<String> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(hs.contains(sb.toString())){
                //ans.add(sb.toString());
            }
            else{
                ans.add(sb.toString());
                hs.add(sb.toString());
                sb = new StringBuilder();
                
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abbccccd";
        System.out.println(PartitionString.partitionString(s));
    }
}
