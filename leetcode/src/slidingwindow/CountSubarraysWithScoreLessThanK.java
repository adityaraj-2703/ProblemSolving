package slidingwindow;

public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int j = 0;
        long sum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum * (i - j + 1) >= k) {
                sum -= nums[j];
                j++;
            }
            count += i - j + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithScoreLessThanK c = new CountSubarraysWithScoreLessThanK();
        int[] arr = { 2, 1, 4, 3, 5 };
        long k = 10;
        System.out.println(c.countSubarrays(arr, k));
    }

}
