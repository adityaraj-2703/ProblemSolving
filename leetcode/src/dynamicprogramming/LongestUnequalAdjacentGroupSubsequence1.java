package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestUnequalAdjacentGroupSubsequence1 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int[] dp = new int[groups.length];
        dp[0] = 1;
        for (int i = 1; i < groups.length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] == 1 && groups[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else if (groups[i] == 0 && groups[j] == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        List<String> ans = new ArrayList<>();

        for (int i = dp.length - 1; i > 0; i--) {
            if (dp[i - 1] < dp[i]) {
                ans.add(words[i]);
            }
        }
        if (dp[0] < dp[1]) {
            ans.add(words[0]);
        }
        Collections.reverse(ans);
        return ans;

    }

    public static void main(String[] args) {
        LongestUnequalAdjacentGroupSubsequence1 l = new LongestUnequalAdjacentGroupSubsequence1();
        String[] words = { "a", "b", "c", "d" };
        int[] groups = { 1, 0, 1, 1 };
        List<String> ans = l.getLongestSubsequence(words, groups);
        System.out.println(ans);
    }

}
