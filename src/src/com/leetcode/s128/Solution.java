package src.com.leetcode.s128;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], false);
        }

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            if (hashMap.getOrDefault(start, false)) continue;
            while (!hashMap.getOrDefault(start, false) && hashMap.containsKey(start)) {
                start--;
            }
            int smallest = start + 1;
            int loop = smallest;
            int length = 0;
            while (hashMap.containsKey(loop)) {
                hashMap.put(loop, true);
                loop++;
                length++;
            }
            result = Math.max(length, result);
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "";
        try {
            File myObj = new File("C:\\Users\\Jake\\IdeaProjects\\Leetcode\\src\\src\\com\\leetcode\\s128\\testcase.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] nums = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
        Solution solution = new Solution();
        System.out.println("Output: " + solution.longestConsecutive(nums));
    }
}
