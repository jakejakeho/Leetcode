package src.com.leetcode.s1061;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Set<Character>> map = new HashMap<>();
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for (int i = 0; i < s1Arr.length; i++) {
            boolean s1Exist = map.containsKey(s1Arr[i]);
            boolean s2Exist = map.containsKey(s2Arr[i]);
            Set<Character> set;
            if (!s1Exist && !s2Exist) {
                set = new HashSet<>();
            } else if (s1Exist && s2Exist) {
                Set<Character> set1 = map.get(s1Arr[i]);
                Set<Character> set2 = map.get(s2Arr[i]);
                if (set1 != set2) {
                    set1.addAll(map.get(s2Arr[i]));
                    for (Character c : set2) {
                        map.put(c, set1);
                    }
                }
                set = set1;
            } else if (s1Exist) {
                set = map.get(s1Arr[i]);
            } else {
                set = map.get(s2Arr[i]);
            }
            set.add(s1Arr[i]);
            set.add(s2Arr[i]);
            map.put(s1Arr[i], set);
            map.put(s2Arr[i], set);
        }

        Map<Character, Character> sortedMap = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            Character c = entry.getKey();
            Set<Character> set = entry.getValue();
            Character smallest = 'z';
            for (Character s : set) {
                if (s < smallest) {
                    smallest = s;
                }
            }
            sortedMap.put(c, smallest);
        }

        StringBuilder stringBuilder = new StringBuilder(baseStr.length());
        char[] baseStrArr = baseStr.toCharArray();
        for (int i = 0; i < baseStrArr.length; i++) {
            if (sortedMap.containsKey(baseStrArr[i])) {
                stringBuilder.append(sortedMap.get(baseStrArr[i]));
            } else {
                stringBuilder.append(baseStrArr[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestEquivalentString("parker", "morris", "parser"));
        System.out.println(solution.smallestEquivalentString("hello", "world", "hold"));
        System.out.println(solution.smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }
}