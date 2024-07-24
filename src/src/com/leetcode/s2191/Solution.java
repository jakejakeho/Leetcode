package src.com.leetcode.s2191;

import java.util.*;

class Solution {

    public Solution() {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = Math.pow(10, i);
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int j : nums) {
            int num = j;
            int sortScore = 0;
            int digit = 0;
            while (num >= 0) {
                sortScore += (int) (getCache(digit++) * mapping[num % 10]);
                num /= 10;
                if (num == 0) {
                    break;
                }
            }
            list.add(new int[]{j, sortScore});
        }
        list.sort(Comparator.comparing(data -> data[1]));
        int[] result = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i)[0];
        }
        return result;
    }

    double[] cache = new double[32];

    private double getCache(int digit) {
        return cache[digit];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortJumbled(new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, new int[]{991, 338, 38})));
        System.out.println(Arrays.toString(solution.sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{0,1,2,3,4,5,6,7,8,9})));
    }
}