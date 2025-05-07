package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");
            int t = Integer.parseInt(s[0]);
            System.out.println(s[1]);

            for (int j = s[1].length() - 1; j >= 0; j--) {
                if (s[1].charAt(j) == '.') {
                    String temp = s[1].substring(j + 1, s[1].length());
                    hm.put(temp, hm.getOrDefault(temp, 0) + t);
                }
                if (j == 0) {
                    hm.put(s[1], hm.getOrDefault(s[1], 0) + t);
                }

            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> m : hm.entrySet()) {
            ans.add(m.getValue() + " " + m.getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        SubdomainVisitCount obj = new SubdomainVisitCount();
        String[] cpdomains = { "9001 discuss.leetcode.com" };
        List<String> result = obj.subdomainVisits(cpdomains);
        System.out.println(result); // Output: [9001 leetcode.com, 9001 discuss.leetcode.com, 9001 com]
    }

}
