package prefixsum;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 1; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            } else if (flowerbed[i - 1] == 1) {
                continue;
            } else if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                continue;
            } else {
                count++;
            }
        }
        return count >= n;

    }

    public static void main(String[] args) {
        int[] f = { 1, 0, 0, 0, 1 };
        CanPlaceFlowers c = new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(f, 2));

    }

}
