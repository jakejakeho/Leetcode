package src.com.leetcode.s864;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int testcase1 = solution.shortestPathAllKeys(new String[] {"@.a..", "###.#", "b.A.B"});
        System.out.println("Test case1 " + testcase1);

        int testcase2 = solution.shortestPathAllKeys(new String[] {"@..aA", "..B#.", "....b"});
        System.out.println("Test case2 " + testcase2);

        int testcase3 = solution.shortestPathAllKeys(new String[] {"@Aa"});
        System.out.println("Test case2 " + testcase2);
    }

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int startI = 0;
        int startJ = 0;
        int allKeys = 0;
        boolean[][][] visited = new boolean[m][n][64];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startI = i;
                    startJ = j;
                } else if (c >= 'a' && c <= 'z') {
                    allKeys = (allKeys << 1) + 1;
                }
            }
        }
        System.out.println("startI = " + startI);
        System.out.println("startJ = " + startJ);

        Deque<int[]> bfsQueue = new ArrayDeque<int[]>();
        bfsQueue.offer(new int [] {startI, startJ, 0, 0});

        while (bfsQueue.isEmpty()) {

        }
        return 0;
    }
}