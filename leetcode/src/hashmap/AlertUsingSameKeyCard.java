package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AlertUsingSameKeyCard {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        TreeMap<String, List<Integer>> hm = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> li = hm.getOrDefault(keyName[i], new ArrayList<>());
            String[] time = keyTime[i].split(":");
            int t = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            li.add(t);
            hm.put(keyName[i], li);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> m : hm.entrySet()) {
            Collections.sort(m.getValue());
            int i = 0;
            int j = 0;
            int count = 0;
            while (j < m.getValue().size()) {
                if (m.getValue().get(j) - m.getValue().get(i) <= 60) {
                    count++;
                    j++;
                } else {
                    while (m.getValue().get(j) - m.getValue().get(i) > 60) {
                        i++;
                        count--;
                    }
                    count++;
                    j++;
                }
                if (count >= 3) {
                    ans.add(m.getKey());
                    break;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AlertUsingSameKeyCard obj = new AlertUsingSameKeyCard();
        String[] keyName = { "leslie", "leslie", "leslie", "clare", "clare", "clare", "clare" };
        String[] keyTime = { "13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49" };
        List<String> result = obj.alertNames(keyName, keyTime);
        System.out.println(result); // Output: [Alice]
    }

}
