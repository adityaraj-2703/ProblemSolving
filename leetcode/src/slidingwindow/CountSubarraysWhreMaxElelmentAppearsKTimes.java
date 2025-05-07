package slidingwindow;

public class CountSubarraysWhreMaxElelmentAppearsKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int i = 0;
        int count = 0;
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == max) {
                count++;
                if (count >= k) {
                    ans += nums.length - j;
                    while (nums[i] != max) {
                        ans += nums.length - j;
                        i++;
                    }
                    i++;
                    count--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubarraysWhreMaxElelmentAppearsKTimes c = new CountSubarraysWhreMaxElelmentAppearsKTimes();
        int[] arr = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println(c.countSubarrays(arr, k));
    }

}
