package leetcodailyquestions;

import java.util.HashMap;
import java.util.Map;

public class CountNumberofGoodSubarrays_04162025 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        int ans = 0;
        while (j < nums.length) {
            if (hm.containsKey(nums[j]) && count <= k) {
                count++;

            } else {
                hm.put(nums[i], 1);
            }
            if (count == k) {
                ans++;
            }
            if (count > k) {
                hm.remove(nums[i]);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountNumberofGoodSubarrays_04162025 obj = new CountNumberofGoodSubarrays_04162025();
        int[] nums = { 1, 1, 1, 1, 1 };
        int k = 10;
        long result = obj.countGood(nums, k);
        System.out.println("Count of good subarrays: " + result);
    }

}
