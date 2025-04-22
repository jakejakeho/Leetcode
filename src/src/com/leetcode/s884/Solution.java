package src.com.leetcode.s884;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> s1Map = new HashMap<>();
        Map<String, Integer> s2Map = new HashMap<>();
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        for (int i = 0; i < s1Arr.length; i++) {
            String w1 = s1Arr[i];
            s1Map.put(w1, s1Map.getOrDefault(w1, 0) + 1);
        }

        for (int i = 0; i < s2Arr.length; i++) {
            String w2 = s2Arr[i];
            s2Map.put(w2, s2Map.getOrDefault(w2, 0) + 1);
        }
        List<String> unCommonWordList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : s1Map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1 && s2Map.getOrDefault(key, 0) == 0) {
                unCommonWordList.add(key);
            }
        }

        for (Map.Entry<String, Integer> entry : s2Map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1 && s1Map.getOrDefault(key, 0) == 0) {
                unCommonWordList.add(key);
            }
        }

        String[] unCommonWordArr = new String[unCommonWordList.size()];
        for (int i = 0; i < unCommonWordList.size(); i++) {
            unCommonWordArr[i] = unCommonWordList.get(i);
        }
        return unCommonWordArr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            Arrays.toString(solution.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(solution.uncommonFromSentences("apple apple", "banana")));
    }
}