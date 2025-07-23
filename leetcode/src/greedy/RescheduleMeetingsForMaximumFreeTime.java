package greedy;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsForMaximumFreeTime {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int start = 0;
        int n = startTime.length;
        List<Integer> gaps = new ArrayList<>();
        if(startTime[0]!=0){
            gaps.add(startTime[0]-start);
            
        }
        start = endTime[0];
        for(int i=1;i<n;i++){
            gaps.add(startTime[i]-start);
            start = endTime[i];
        }
        gaps.add(eventTime - start);
        int sum = 0;
        for(int i=0;i<k+1;i++){
            sum+=gaps.get(i);
        }
        int max = sum;
        int ind=0;
        for(int i=k;i<=n;i++){
            sum-=gaps.get(ind);
            sum+=gaps.get(ind);
            max = Math.max(max,sum);
        }
        return max;
        
    }
    public static void main(String[] args) {
        int[] st = {0,2,9};
        int[] en = {1,4,10};
        int etime = 10;
        int k = 1;
        RescheduleMeetingsForMaximumFreeTime r = new RescheduleMeetingsForMaximumFreeTime();
        System.out.println(r.maxFreeTime(etime, k, st, en));
    }

}
