package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
            int temp = dominoes[i][0] * 10 + dominoes[i][1];

            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
            if (m.getValue() > 1) {
                sum += ((m.getValue() - 1) * (m.getValue())) / 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] dominoes = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
        NumberOfEquivalentDominoPairs n = new NumberOfEquivalentDominoPairs();
        System.out.println(n.numEquivDominoPairs(dominoes));
    }

}
