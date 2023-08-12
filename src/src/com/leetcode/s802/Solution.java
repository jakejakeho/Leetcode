package src.com.leetcode.s802;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eventualSafeNodes(new int[][] {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
        System.out.println(solution.eventualSafeNodes(new int[][] {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
        //System.out.println(solution.eventualSafeNodes(new int[][] {{}, {0, 2, 3, 4}, {3}, {4}, {}}));
        //System.out.println(solution.eventualSafeNodes(new int[][] {{}, {2}, {3, 4}, {4}, {}}));
        //System.out.println(solution.eventualSafeNodes(
        //    new int[][] {{4, 9}, {3, 5, 7}, {0, 3, 4, 5, 6, 8}, {7, 8, 9}, {5, 6, 7, 8}, {6, 7, 8, 9}, {7, 9}, {8, 9},
        //        {9}, {}}));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = findSafeNodes(graph);
        return new ArrayList<>(safeNodes);
    }

    private List<Integer> findSafeNodes(int[][] graph) {
        Boolean[] isCanReachTerminal = new Boolean[graph.length];

        int count = 0;
        for (int i = graph.length - 1; i >= 0; i--) {
            isCanReachTerminal[i] = canReachTerminal(i, graph, isCanReachTerminal);
            if (isCanReachTerminal[i]) count++;
        }
        List<Integer> safeNodes = new ArrayList<>(count);
        for (int i = 0; i < graph.length; i++)  {
            if (isCanReachTerminal[i]) {safeNodes.add(i);}
        }
        return safeNodes;
    }

    private boolean canReachTerminal(int nodeIndex, int[][] graph, Boolean[] isCanReachTerminal) {
        if (Objects.isNull(isCanReachTerminal[nodeIndex])) {
            //System.out.println("checking edges for node " + nodeIndex);
            isCanReachTerminal[nodeIndex] = false;
            for (int edge : graph[nodeIndex]) {
                if (Boolean.FALSE.equals(isCanReachTerminal[edge]) || !canReachTerminal(edge, graph,
                    isCanReachTerminal)) {
                    return isCanReachTerminal[nodeIndex];
                }
            }
            isCanReachTerminal[nodeIndex] = true;
        }
        return isCanReachTerminal[nodeIndex];
    }
}
