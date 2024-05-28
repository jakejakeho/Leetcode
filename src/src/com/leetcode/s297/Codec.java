package src.com.leetcode.s297;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                } else {
                    sb.append(node.val)
                      .append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null && !Objects.equals(arr[index], "null")) {
                    node.left = new TreeNode(Integer.parseInt(arr[index]));
                    queue.offer(node.left);
                }
                index++;
                if (node != null && !Objects.equals(arr[index], "null")) {
                    node.right = new TreeNode(Integer.parseInt(arr[index]));
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec ser = new Codec();
        Codec desr = new Codec();
        String serResult = ser.serialize(root);
        System.out.println(serResult);
        TreeNode ans = desr.deserialize(serResult);
        System.out.println(ans);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));