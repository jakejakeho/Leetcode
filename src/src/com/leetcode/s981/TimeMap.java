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
        List<Pair> timestampList = map.getOrDefault(key, new ArrayList<>());
        Pair newPair = new Pair();
        newPair.key = timestamp;
        newPair.value = value;
        timestampList.add(newPair);
        map.put(key, timestampList);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> timestamps = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = timestamps.size() - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            int midTimestamp = timestamps.get(mid).key;
            if (midTimestamp <= timestamp) {
                left = mid;
            }  else {
                right = mid - 1;
            }
        }
        return timestamps.get(left).key <= timestamp ? timestamps.get(left).value : "";
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
