package src.com.leetcode.s2370;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Solution {
    public int longestIdealString(String s, int k) {
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
            int num = c - 'a';
            int max = 0;

            int left = Math.max(num - k, 0);
            int right = Math.min(num + k, cache.length - 1);

            for (int i = left; i <= right; i++) {
                max = Math.max(max, cache[i]);
            }
            cache[num] = 1 + max;
        }
        int result = 0;
        for (int length : cache) {
            result = Math.max(result, length);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Path filePath = Path.of("src/src/com/leetcode/s2370/testcase.txt");
        String content = Files.readString(filePath);
        System.out.println(solution.longestIdealString(content, 5));
    }
}