package src.com.leetcode150.ArraysHashing.Q6EncodeAndDecodeStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public String encode(List<String> strs) {
        int size = 0;
        for (String str : strs) {
            size += str.length() + 2;
        }
        StringBuilder sb = new StringBuilder(size);
        for (String str : strs) {
            sb.append(str);
            sb.append("``");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        String[] arr = str.split("``");
        return arr.length == 0 ? List.of("") : Arrays.asList(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decode(solution.encode(Arrays.asList("neet", "code", "love", "you"))));
        System.out.println(solution.decode(solution.encode(Arrays.asList("we", "say", ":", "yes"))));
        System.out.println(solution.decode(solution.encode(List.of(""))));
    }
}
