package src.com.leetcode.s981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    public class Pair {
        public String value;
        public Integer key;
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair newPair = new Pair();
        newPair.key = timestamp;
        newPair.value = value;
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(newPair);
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid).key <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return list.get(left).key <= timestamp ? list.get(left).value : "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }
}
