package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom3 {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                if(p1.endTime!=p2.endTime){
                    return p1.endTime - p2.endTime;
                }
                return p1.ind - p2.ind;
            }
        });
        for(int i=0;i<n;i++){
            pq.offer(new Pair(i,Integer.MAX_VALUE));
        }
        int time = 0;
        int[] dp = new int[n];
        for(int i=0;i<meetings.length;i++){
            Pair temp = pq.poll();
            dp[temp.ind]++;
            if(temp.endTime>=meetings[i][0]){
                pq.add(new Pair(temp.ind,meetings[i][1]));
            }
            else{
                pq.add(new Pair(temp.ind,temp.endTime + meetings[i][1]-meetings[i][0]));
            }
            

        }
        int max = 0;
        int ans = -1;
        for(int i=0;i<dp.length;i++){
            if(max<dp[i]){
                max = dp[i];
                ans = i;
            }
        }
        return ans;
    }
    class Pair{
        int ind;
        int endTime;
        Pair(int ind,int endTime){
            this.ind = ind;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) {
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        int n = 2;
        MeetingRoom3 m = new MeetingRoom3();
        System.out.println(m.mostBooked(n, meetings));
    }

}
