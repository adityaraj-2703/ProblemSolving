package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LongCorridor {
    public int numberOfWays(String corridor) {
        int count = 0;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                count++;
            }
            if(count==2){
                count=0;
                li.add(i);
            }
        }
        if(count!=0){
            return 0;
        }
        int tot = 1;
        for(int i=0;i<li.size()-1;i++){
            int st = li.get(i)+1;
            int c = 1;
            while(st<corridor.length()&& corridor.charAt(st)=='P'){
                c++;
                st++;
            }
            tot = tot*c;
        }
        return tot;
    }
    public static void main(String[] args) {
        String corridor = "SSPPSPSSSPSPSPP";
        int res = new LongCorridor().numberOfWays(corridor);
        System.out.println(res);
    }

}
