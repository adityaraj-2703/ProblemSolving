package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwapsToSortByDigitSum {
    public int minSwaps(int[] nums) {
        int[][] arr = new int[nums.length][3];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = check(nums[i]);
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        boolean[] visited = new boolean[nums.length];
        int swaps = 0;

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || arr[i][2] == i)
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    public int check(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumSwapsToSortByDigitSum m = new MinimumSwapsToSortByDigitSum();
        int[] nums = { 346675656, 436516098, 372126778, 781771807 };
        int ans = m.minSwaps(nums);
        System.out.println(ans);
    }

}
