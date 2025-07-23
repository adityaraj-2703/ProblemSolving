package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountNumberOfBalancedPermutations {
    public int countBalancedPermutations(String num) {
        Set<String> al = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[num.length()];
        int count = 0;
        find(num, al, sb, visited);
        for (String s : al) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < s.length(); j += 2) {
                sum1 += (s.charAt(j) - '0');
                if (j + 1 < s.length()) {
                    sum2 += (s.charAt(j + 1) - '0');
                }

            }
            if (sum1 == sum2) {
                count++;
            }
        }
        return count;
    }

    public void find(String num, Set<String> al, StringBuilder sb, boolean[] visited) {

        if (sb.length() == num.length()) {
            al.add(sb.toString());
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(num.charAt(i));
            find(num, al, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        CountNumberOfBalancedPermutations c = new CountNumberOfBalancedPermutations();
        String num = "112";
        int ans = c.countBalancedPermutations(num);
        System.out.println(ans);
    }

}
