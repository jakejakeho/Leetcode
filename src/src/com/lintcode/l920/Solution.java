package src.com.lintcode.l920;

import java.util.Comparator;
import java.util.List;

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

    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        // Write your code here
        intervals.sort(Comparator.comparing((a) -> a.end));
        Interval lastInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < lastInterval.end) {
                return false;
            }
            lastInterval = intervals.get(i);
        }
        return true;
    }
}