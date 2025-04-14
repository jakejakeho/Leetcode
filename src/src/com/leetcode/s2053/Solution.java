package src.com.leetcode.s2053;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> stringCountMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            stringCountMap.put(arr[i], stringCountMap.getOrDefault(arr[i], 0) + 1);
        }

        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stringCountMap.get(arr[i]) == 1) {
                n++;
            }
            if (n == k) {
                return arr[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthDistinct(new String[] {"d", "b", "c", "b", "c", "a"}, 2));
        System.out.println(solution.kthDistinct(new String[] {"aaa", "aa", "a"}, 1));
        System.out.println(solution.kthDistinct(new String[] {"a", "b", "a"}, 3));
    }
}