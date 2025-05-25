package src.com.leetcode150.T4_Stack.Q6_CarFleet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    record Car(int position, int speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        int carFleetCount = 0;
        Map<Integer, Integer> positionCarMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            positionCarMap.put(position[i], positionCarMap.getOrDefault(position[i], speed[i]));
        }
        while (!positionCarMap.isEmpty()) {
            Map<Integer, Integer> nextMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : positionCarMap.entrySet()) {
                Integer p = entry.getKey();
                Integer slowestSpeed = entry.getValue();
                if (p >= target) {
                    carFleetCount++;
                } else {
                    nextMap.put(p + slowestSpeed,
                        Math.min(slowestSpeed, nextMap.getOrDefault(p + slowestSpeed, slowestSpeed)));
                }
            }
            positionCarMap = nextMap;
        }
        return carFleetCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.carFleet(12, new int[] {10, 8, 0, 5, 3}, new int[] {2, 4, 1, 1, 3}));
        System.out.println(solution.carFleet(10, new int[] {3}, new int[] {3}));
        System.out.println(solution.carFleet(100, new int[] {0, 2, 4}, new int[] {4, 2, 1}));
    }
}