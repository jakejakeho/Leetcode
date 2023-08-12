package src.com.leetcode.s802;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Integer> safeNodes = new ArrayList<>();
        Boolean[] isCanReachTerminal = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isTerminal(graph[i])) {
                isCanReachTerminal[i] = true;
            }
        }

        boolean[] isSafeNodes = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isCanReachTerminal[i] == null) {
                boolean[] visited = new boolean[graph.length];
                isCanReachTerminal[i] = canReachTerminal(i, graph, visited, isCanReachTerminal);
                //System.out.println("checking node = " + i + " isCanReachTerminal[edge.val] = " +
                // isCanReachTerminal[i]);
            }
            if (Boolean.TRUE.equals(isCanReachTerminal[i])) {
                isSafeNodes[i] = true;
            }
        }
        for (int i = 0; i < isSafeNodes.length; i++) {
            if (isSafeNodes[i]) {safeNodes.add(i);}
        }
        return safeNodes;
    }

    private boolean canReachTerminal(int nodeIndex, int[][] graph, boolean[] visited, Boolean[] isCanReachTerminal) {
        if (isCanReachTerminal[nodeIndex] == null) {
            if (isTerminal(graph[nodeIndex])) {
                isCanReachTerminal[nodeIndex] = true;
                //System.out.println("reached terminal = " + nodeIndex);
                return true;
            }

            boolean isAllEdgesCanReachTerminal = true;
            int[] edges = graph[nodeIndex];
            //System.out.println("checking edges for node " + nodeIndex);
            for (int edge : edges) {
                if (!visited[edge]) {
                    visited[nodeIndex] = true;
                    boolean canReach = canReachTerminal(edge, graph, visited, isCanReachTerminal);
                    if (!canReach) {
                        isAllEdgesCanReachTerminal = false;
                        break;
                    }
                    visited[nodeIndex] = false;
                } else {
                    if (!isTerminal(graph[edge])) {
                        isAllEdgesCanReachTerminal = false;
                        break;
                    }
                }
            }
            isCanReachTerminal[nodeIndex] = isAllEdgesCanReachTerminal;
            return isAllEdgesCanReachTerminal;
        } else {
            return isCanReachTerminal[nodeIndex];
        }
    }

    private boolean isTerminal(int[] edges) {
        return edges.length == 0;
    }
}
