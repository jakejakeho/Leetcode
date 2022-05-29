package src.com.leetcode.s128;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data = "";
        try {
            File myObj = new File("/home/jake/IdeaProjects/GoogleIAMComing/src/com/leetcode/s128/testcase.txt");
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
