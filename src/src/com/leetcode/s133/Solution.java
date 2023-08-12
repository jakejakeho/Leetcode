package src.com.leetcode.s133;

import java.util.*;

public class Solution {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Solution solution = new Solution();
        Node clone = solution.cloneGraph(node1);
        System.out.println(clone.val);
    }

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> newHashMap = new HashMap<>();
        Node clone = dfs(node, newHashMap);
        return clone;
    }

    private Node dfs(Node node, HashMap<Integer, Node> newHashMap) {
        if (node == null) {
            return null;
        }
        if (newHashMap.containsKey(node.val)) {
            return newHashMap.get(node.val);
        } else {
            Node copy = new Node(node.val);
            newHashMap.put(node.val, copy);
            for (Node neighbor: node.neighbors) {
                copy.neighbors.add(dfs(neighbor, newHashMap));
            }
            return copy;
        }
    }
}
