package string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        List<List<Character>> li = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            li.add(new ArrayList<>());
        }
        int ind = 0;
        int r = 0;
        int dir = 1;
        while(ind<s.length()){
            li.get(r).add(s.charAt(ind++));
            if(r==numRows-1){
                dir = -dir;
                
            }
            else if(r==0){
                dir = 1;
            }
            r += dir;
            
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<li.size();i++){
            for(int j=0;j<li.get(i).size();j++){
                sb.append(li.get(i).get(j));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        String s = "AB";
        int numRows = 1;
        System.out.println(z.convert(s, numRows));
    }

}
