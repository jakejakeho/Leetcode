package src.com.leetcode.s1870;
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("example 1 = " + solution.minSpeedOnTime(new int[] {1, 3, 2}, 6));
        System.out.println("example 2 = " + solution.minSpeedOnTime(new int[] {1, 3, 2}, 2.7));
        System.out.println("example 3 = " + solution.minSpeedOnTime(new int[] {1, 3, 2}, 1.9));
        System.out.println("example 4 = " + solution.minSpeedOnTime(new int[] {1, 1, 10000}, 2.01));
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        // binary search
        int right = 10000000;
        int left = 1;
        int minSpeed = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValidSpeed(dist, hour, mid)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    public boolean isValidSpeed(int[] dist, double hour, int speed) {
        double timeRequired = 0.0;
        for (int i = 0; i < dist.length; i++) {
            int dis = dist[i];
            double timeNeeded = 0.0;
            if (i != dist.length - 1) {
                timeNeeded = Math.ceil((dis + 0.0) / (speed + 0.0));
            } else {
                timeNeeded = (dis + 0.0) / (speed + 0.0);
            }
            timeRequired += timeNeeded;
        }
        return timeRequired <= hour;
    }
}