package dynamicprogramming;

public class CountNumberOfUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 1;
        }
        dp[1] = 10;

        for (int i = 2; i <= n; i++) {
            int m = 9;
            int counter = 9;
            for (int j = 2; j <= i; j++) {
                m *= counter;
                counter--;
            }
            dp[i] = m;
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        CountNumberOfUniqueDigits c = new CountNumberOfUniqueDigits();
        System.out.println(c.countNumbersWithUniqueDigits(n));
    }

}
