package src.com.leetcode.s1514;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProbability(3, new int[][]{{0,1}, {1,2}, {0,2}}, new double[]{0.5, 0.5, 0.2},
            0, 2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] probability = new double[n];
        probability[start] = 1.0;
        for (int j = 0; j < n - 1; j++) {
            boolean hasUpdate = false;
            for (int i = 0; i < edges.length; i++) {
                double edgeProb = succProb[i];
                int edgeStart = edges[i][0];
                int edgeEnd = edges[i][1];
                double edgeEndProb = probability[edgeStart] * edgeProb;
                if (edgeEndProb > probability[edgeEnd]) {
                    probability[edgeEnd] = edgeEndProb;
                    hasUpdate = true;
                }

                double edgeStartProb = probability[edgeEnd] * edgeProb;
                if (edgeStartProb > probability[edgeStart]) {
                    probability[edgeStart] = edgeStartProb;
                    hasUpdate = true;
                }
            }
            if (!hasUpdate) {
                break;
            }
        }
        return probability[end];
    }
}