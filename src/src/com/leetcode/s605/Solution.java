package src.com.leetcode.s605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] last3Flower = new int[3];
        int indexSkipCheck = 1;
        int indexReplace = 2;

        for (int i = 1; i < Math.min(flowerbed.length,3); i++) {
            last3Flower[i] = flowerbed[i - 1];
        }
        for (int i = 0; i < flowerbed.length; i++) {
            last3Flower[indexReplace] = (i + 1) < flowerbed.length ? flowerbed[i + 1] : 0;
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                if (j != indexSkipCheck) {
                    sum += last3Flower[j];
                }
            }

            if (sum == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                last3Flower[indexSkipCheck] = 1;
                if (n > 0)
                    n--;
                if (n == 0) {
                    break;
                }
            }
            indexSkipCheck = (indexSkipCheck + 1) % 3;
            indexReplace = (indexReplace + 1) % 3;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
