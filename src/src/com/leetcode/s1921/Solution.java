package src.com.leetcode.s1921;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eliminateMaximum(new int[] {1, 3, 4}, new int[] {1, 1, 1}));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int liveMonsters = dist.length;
        PriorityQueue<Double> monsterQueue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            monsterQueue.offer((dist[i] + 0.0) / speed[i]);
        }
        int currentRound = 0;
        while (liveMonsters > 0) {
            Double roundsToReachCity = monsterQueue.poll();
            if (roundsToReachCity != null && roundsToReachCity > currentRound) {
                liveMonsters--;
            } else {
                break;
            }
            currentRound++;
        }
        return dist.length - liveMonsters;
    }
}