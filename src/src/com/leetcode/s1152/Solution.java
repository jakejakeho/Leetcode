package src.com.leetcode.s1152;

import java.util.*;

class Solution {

    public class Data {
        String userName;
        String website;
        int timestamp;
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            Data d = new Data();
            d.userName = username[i];
            d.website = website[i];
            d.timestamp = timestamp[i];
            data.add(d);
        }

        Collections.sort(data, (a, b) -> a.timestamp - b.timestamp);

        Map<String, List<String>> userMap = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            userMap.computeIfAbsent(data.get(i).userName, k -> new ArrayList<>()).add(data.get(i).website);
        }
        Map<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : userMap.entrySet()) {
            List<String> websites = entry.getValue();
            Set<String> patterns = new HashSet<>();
            for (int i = 0; i < websites.size(); i++) {
                for (int j = i + 1; j < websites.size(); j++) {
                    for (int k = j + 1; k < websites.size(); k++) {
                        patterns.add(websites.get(i) + "_" + websites.get(j) + "_" + websites.get(k));
                    }
                }
            }
            for (String s : patterns)
                countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        String best = "";
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String pattern = entry.getKey();
            Integer c = entry.getValue();
            if (c > count || (c == count && pattern.compareTo(best) < 0)) {
                best = pattern;
                count = c;
            }
        }
        return Arrays.asList(best.split("_"));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mostVisitedPattern(new String[]{"bob", "bob", "bob", "alice", "alice", "alice", "alice", "charlie", "charlie", "charlie"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"}));
        System.out.println(solution.mostVisitedPattern(new String[]{"alice", "alice", "alice", "alice"}, new int[]{1, 2, 3, 4}, new String[]{"a", "b", "c", "d"}));
    }
}