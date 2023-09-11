package src.com.leetcode.s1282;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(new int[] {3, 3, 3, 3, 3, 1, 3}));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> group = map.getOrDefault(groupSize, new ArrayList<>(groupSize));
            group.add(i);
            if (group.size() == groupSize) {
                result.add(group);
                map.put(groupSize, new ArrayList<>());
            } else {
                map.put(groupSize, group);
            }
        }
        return result;
    }
}