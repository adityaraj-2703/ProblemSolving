package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ServersThatHandleMostNumberOfRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] servers = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((n1, n2) -> n1.last - n2.last);
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arrival[i] + load[i], i));
            servers[i]++;
        }
        for (int i = k; i < arrival.length; i++) {
            if (pq.peek().last <= arrival[i]) {
                Pair temp = pq.poll();
                pq.add(new Pair(arrival[i] + load[i], temp.serverNo));
                servers[temp.serverNo]++;
            }
        }

        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < servers.length; i++) {
            if (servers[i] > max) {
                max = servers[i];
                ans = new ArrayList<>();
                ans.add(i);
            } else if (max == servers[i]) {
                ans.add(i);
            }
        }
        return ans;

    }

    class Pair {
        int last;
        int serverNo;

        Pair(int last, int serverNo) {
            this.last = last;
            this.serverNo = serverNo;
        }
    }

    public static void main(String[] args) {
        ServersThatHandleMostNumberOfRequests s = new ServersThatHandleMostNumberOfRequests();
        int k = 3;
        int[] arrival = { 1, 2, 3, 4, 8, 9, 10 };
        int[] load = { 5, 2, 10, 3, 1, 2, 2 };
        List<Integer> al = s.busiestServers(k, arrival, load);
        for (int g : al) {
            System.out.println(g);
        }

    }

}
