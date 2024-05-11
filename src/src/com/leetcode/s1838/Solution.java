package src.com.leetcode.s1838;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int maxFrequency = 0;
        long sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while ((long) (right - left + 1) * nums[right] - sum > k) {
                sum -= nums[left];
                left++;
            }
            if ((right - left + 1) > maxFrequency) {
                maxFrequency = right - left + 1;
            }
        }
        return maxFrequency;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(solution.maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(solution.maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(solution.maxFrequency(new int[]{3, 9, 6}, 2));
        System.out.println(solution.maxFrequency(readFile("1.txt"), 100000));
        int[] testcase2 = readFile("2.txt");
        System.out.println(solution.maxFrequency(testcase2, 1));
    }

    public static int[] readFile(String filename) throws IOException {
        Path fileName
                = Path.of("src/src/com/leetcode/s1838/" + filename);
        String str = Files.readString(fileName);
        String[] strArr = str.split(",");
        int[] testcase = new int[strArr.length];
        int i = 0;
        for (String s : strArr) {
            testcase[i++] = Integer.parseInt(s);
        }
        return testcase;
    }
}