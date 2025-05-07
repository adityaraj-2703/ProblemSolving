package prefixsum;

public class CounttheHiddenSequences {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int t = 0;
        for (int i = 0; i < differences.length; i++) {
            t += differences[i];
            min = Math.min(t, min);
            max = Math.max(t, max);
        }
        int left = lower + (-min);
        int right = upper - max;
        if (left >= lower && right <= upper) {
            return right - left + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CounttheHiddenSequences c = new CounttheHiddenSequences();
        int[] differences = { -40 };
        System.out.println(c.numberOfArrays(differences, -46, 53));
    }

}
