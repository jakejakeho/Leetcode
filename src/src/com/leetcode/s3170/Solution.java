package src.com.leetcode.s3170;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

    public class Data {

        char c;

        int index;

        public Data(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public String clearStars(String s) {
        Stack<Data>[] stacks = new Stack[26];
        for (int i = 0; i < 26; i++) {
            stacks[i] = new Stack<>();
        }
        char[] sArr = s.toCharArray();
        Set<Integer> deleteSet = new HashSet<>();
        for (int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            if (c != '*') {
                stacks[c - 'a'].push(new Data(c, i));
            } else {
                for (int j = 0; j < stacks.length; j++) {
                    if (!stacks[j].isEmpty()) {
                        deleteSet.add(stacks[j].pop().index);
                        break;
                    }
                }
            }
        }

        int deleted = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*')
                continue;
            if (deleted < deleteSet.size() && deleteSet.contains(i)) {
                deleted++;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clearStars("aaba*"));
        System.out.println(solution.clearStars("abc"));
    }
}