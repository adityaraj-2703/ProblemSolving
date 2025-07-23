package dynamicprogramming;

public class GuessNumberHigherOrLower2 {
    public int getMoneyAmount(int n) {
        return getMoneyAmountUtil(1, n, 0);
    }

    public int getMoneyAmountUtil(int l, int h, int sum) {
        if (l > h) {
            return sum;
        }
        if (l == h) {
            return 0;
        }
        int max = 0;
        int m = (l + h) / 2;
        max = Math.max(getMoneyAmountUtil(l, m - 1, sum + m), Math.max(getMoneyAmountUtil(l, m - 1, sum + m), max));
        return max;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower2 g = new GuessNumberHigherOrLower2();
        int n = 10;
        System.out.println(g.getMoneyAmount(n));
    }

}
