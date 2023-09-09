package src.com.lintcode.l919;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Definition of Interval:
 * public class Interval {
 * int start, end;
 * Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */
public class Solution {
    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getEnd() {
            return this.end;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(155, 20));
        System.out.println(solution.minMeetingRooms(intervals));
    }

    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int maxRoosm = 0;
        int currentRoom = 0;
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int i = 0;
        for (Interval interval : intervals) {
            start[i] = interval.start;
            end[i] = interval.end;
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0;
        int endPointer = 0;
        while (startPointer < intervals.size() && endPointer < intervals.size()) {
            if (start[startPointer] < end[endPointer]) {
                // meeting is going on
                currentRoom++;
                maxRoosm = Math.max(currentRoom, maxRoosm);
                startPointer++;
            } else {
                endPointer++;
                currentRoom--;
            }
        }
        return maxRoosm;
    }
}