package hashmap;

/*
You and your friends are driving to a Campground to go camping. Only 2 of you have cars, so you will be carpooling. 

Routes to the campground are linear, so each location will only lead to 1 location and there will be no loops or detours. Both cars will leave from their starting locations at the same time. The first car to pass someone's location will pick them up. If both cars arrive at the same time, the person can go in either car.

Roads are provided as a directed list of connected locations with the duration (in minutes) it takes to drive between the locations. 
[Origin, Destination, Duration it takes to drive]

Given a list of roads, a list of starting locations and a list of people/where they live, return a collection of who will be in each car upon arrival to the Campground.
------------------------------------------------------
Bridgewater--(30)-->Caledonia--(15)-->New Grafton--(5)-->Campground
                                       ^
Liverpool---(10)---Milton-----(30)-----^

roads1 = [
    ["Bridgewater", "Caledonia", "30"], <= The road from Bridgewater to Caledonia takes 30 minutes to drive.
    ["Caledonia", "New Grafton", "15"], 
    ["New Grafton", "Campground", "5"], 
    ["Milton", "New Grafton", "30"],
    ["Liverpool", "Milton", "10"]
]
starts1 = ["Bridgewater", "Liverpool"]
people1 = [
    ["Jessie", "Bridgewater"], ["Travis", "Caledonia"], 
    ["Jeremy", "New Grafton"], ["Katie", "Liverpool"]
]

PriorityQueue<Pair>>

Details{
  int carNo;
  String location;
  int totalTime;
}

Car1 path: (from Bridgewater): [Bridgewater(0, Jessie)->Caledonia(30, Travis)->New Grafton(45)->Campground(50)]
Car2 path: (from Liverpool): [Liverpool(0, Katie)->Milton(10)->New Grafton(40, Jeremy)->Campground(45)]

Output (In any order/format):
    [Jessie, Travis], [Katie, Jeremy]
--------------------------------------
Riverport->Chester->Campground
             ^
Halifax------^

roads2 = [["Riverport", "Chester", "40"], ["Chester", "Campground", "60"], ["Halifax", "Chester", "40"]]
starts2 = ["Riverport", "Halifax"]
people2 = [["Colin", "Riverport"], ["Sam", "Chester"], ["Alyssa", "Halifax"]]

Output (In any order/format):
    [Colin, Sam], [Alyssa] OR [Colin], [Alyssa, Sam]
----------------------------------------
Riverport->Bridgewater->Liverpool->Campground

roads3 = [["Riverport", "Bridgewater", "1"], ["Bridgewater", "Liverpool", "1"], ["Liverpool", "Campground", "1"]]
starts3_1 = ["Riverport", "Bridgewater"]
starts3_2 = ["Bridgewater", "Riverport"]
starts3_3 = ["Riverport", "Liverpool"]
people3 = [["Colin", "Riverport"], ["Jessie", "Bridgewater"], ["Sam", "Liverpool"]]

Output (starts3_1/starts3_2):  [Colin], [Jessie, Sam] - (Cars can be in any order)
Output (starts3_3): [Jessie, Colin], [Sam]
----------------------------------------
All Test Cases: (Cars can be in either order)
carpool(roads1, starts1, people1) => [Jessie, Travis], [Katie, Jeremy]
carpool(roads2, starts2, people2) => [Colin, Sam], [Alyssa] OR [Colin], [Alyssa, Sam]
carpool(roads3, starts3_1, people3) => [Colin], [Jessie, Sam]
carpool(roads3, starts3_2, people3) => [Jessie, Sam], [Colin]
carpool(roads3, starts3_3, people3) => [Jessie, Colin], [Sam]
----------------------------------------
Complexity Variable:
n = number of roads
*/

import java.io.*;
import java.util.*;

public class FindDestinationOfPeople_Karat {
    public static void main(String[] argv) {
        String[][] roads1 = {
                { "Bridgewater", "Caledonia", "30" }, { "Caledonia", "New Grafton", "15" },
                { "New Grafton", "Campground", "5" }, { "Milton", "New Grafton", "30" },
                { "Liverpool", "Milton", "10" }
        };
        String[] starts1 = { "Bridgewater", "Liverpool" };
        String[][] people1 = {
                { "Jessie", "Bridgewater" }, { "Travis", "Caledonia" },
                { "Jeremy", "New Grafton" }, { "Katie", "Liverpool" }
        };

        String[][] roads2 = { { "Riverport", "Chester", "40" }, { "Chester", "Campground", "60" },
                { "Halifax", "Chester", "40" } };
        String[] starts2 = { "Riverport", "Halifax" };
        String[][] people2 = { { "Colin", "Riverport" }, { "Sam", "Chester" }, { "Alyssa", "Halifax" } };

        String[][] roads3 = { { "Riverport", "Bridgewater", "1" }, { "Bridgewater", "Liverpool", "1" },
                { "Liverpool", "Campground", "1" } };
        String[] starts3_1 = { "Riverport", "Bridgewater" };
        String[] starts3_2 = { "Bridgewater", "Riverport" };
        String[] starts3_3 = { "Riverport", "Liverpool" };
        String[][] people3 = { { "Colin", "Riverport" }, { "Jessie", "Bridgewater" }, { "Sam", "Liverpool" } };

        // System.out.println(find(products,list1));
        // System.out.println(find(products,list2));
        // System.out.println(find(products,list3));
        // System.out.println(find(products,list4));
        // System.out.println(find(products,list5));
        System.out.println(findD1(roads1, starts1, people1));
        System.out.println(findD1(roads2, starts2, people2));
        System.out.println(findD1(roads3, starts3_1, people3));
        System.out.println(findD1(roads3, starts3_2, people3));
        System.out.println(findD1(roads3, starts3_3, people3));
    }

    public static List<Set<String>> findD1(String[][] road, String[] start, String[][] people) {
        Map<String, String> hm = new HashMap<>();
        for (int i = 0; i < people.length; i++) {
            hm.put(people[i][1], people[i][0]);
        }
        Map<String, Pair> root = new HashMap<>();
        for (int i = 0; i < road.length; i++) {
            root.put(road[i][0], new Pair(road[i][1], Integer.parseInt(road[i][2])));
        }
        Set<String> l1 = new HashSet<>();
        Set<String> l2 = new HashSet<>();
        String start1 = start[0];
        Map<String, Integer> hm1 = new HashMap<>();
        int time = 0;
        while (!start1.equals("Campground")) {
            int l = hm1.getOrDefault(start1, Integer.MAX_VALUE);
            if (l > time && root.containsKey(start1)) {
                l1.add(hm.get(start1));

                start1 = root.get(start1).des;
                time += root.get(start1).time;
                hm1.put(hm.get(start1), time);
            }

        }
        String start2 = start[1];
        time = 0;
        while (!start2.equals("Campground")) {
            int l = hm1.getOrDefault(start1, Integer.MAX_VALUE);
            if (l > time && root.containsKey(start2)) {
                l1.remove(hm.get(start2));
                l2.add(hm.get(start2));
                start2 = root.get(start2).des;
                time += root.get(start2).time;
                hm1.put(hm.get(start2), time);
            }
        }
        List<Set<String>> ans = new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        return ans;

    }

    public static List<List<String>> findD(String[][] road, String[] start, String[][] people) {
        Map<String, String> hm = new HashMap<>();
        for (int i = 0; i < people.length; i++) {
            hm.put(people[i][1], people[i][0]);
        }
        Map<String, Pair> root = new HashMap<>();
        for (int i = 0; i < road.length; i++) {
            root.put(road[i][0], new Pair(road[i][1], Integer.parseInt(road[i][2])));
        }

        PriorityQueue<Details> pq = new PriorityQueue<>((n1, n2) -> n1.totalTime - n2.totalTime);
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        if (hm.get(start[0]) != null) {
            l1.add(hm.get(start[0]));
            hm.remove(start[0]);
            pq.add(new Details(1, start[0], 0));
        }
        if (hm.get(start[1]) != null) {
            l2.add(hm.get(start[1]));
            hm.remove(start[1]);
            pq.add(new Details(2, start[1], 0));
        }
        while (!pq.isEmpty()) {
            Details d = pq.poll();
            String nextLoc = root.get(d.location).des;
            if (nextLoc.equals("Campground")) {
                continue;
            }
            int ti = root.get(d.location).time;
            if (hm.get(nextLoc) != null) {
                if (d.carNo == 1) {
                    l1.add(hm.get(nextLoc));
                    hm.remove(nextLoc);
                    pq.add(new Details(1, nextLoc, d.totalTime + ti));
                } else {
                    l2.add(hm.get(nextLoc));
                    hm.remove(nextLoc);
                    pq.add(new Details(2, nextLoc, d.totalTime + ti));
                }
            } else {
                pq.add(new Details(d.carNo, nextLoc, d.totalTime + ti));
            }
        }
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.get(i));
        }
        List<List<String>> ans = new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        return ans;

    }

    static class Pair {
        String des;
        int time;

        Pair(String des, int time) {
            this.des = des;
            this.time = time;
        }
    }

    static class Details {
        int carNo;
        String location;
        int totalTime;

        Details(int carNo, String location, int totalTime) {
            this.carNo = carNo;
            this.location = location;
            this.totalTime = totalTime;
        }
    }

    public static int find(String[][] products, String[] list) {
        Map<String, String> hm = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            hm.put(products[i][0], products[i][1]);

        }
        String dep = hm.get(list[0]);
        int count = 1;
        for (int i = 1; i < list.length; i++) {
            if (!dep.equals(hm.get(list[i]))) {
                count++;
                dep = hm.get(list[i]);
            }

        }
        int count1 = 0;
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < list.length; i++) {
            if (!hs.contains(hm.get(list[i]))) {
                count1++;
            }
            hs.add(hm.get(list[i]));

        }
        return count - count1;

    }
}
