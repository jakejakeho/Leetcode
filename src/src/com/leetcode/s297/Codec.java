package src.com.leetcode.s297;

import src.com.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        List<String> result = new ArrayList<>();
        String left = serialize(root.left);
        String right = serialize(root.right);
        result.add(String.valueOf(root.val));
        result.add(left);
        result.add(right);
        String resultStr = String.join(",", result);
        return resultStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> result = List.of(data.split(","));
        List<Integer> list = new ArrayList<>();
        list.add(0);
        TreeNode root = deserialize(result, list);
        return root;
    }

    public TreeNode deserialize(List<String> result, List<Integer> list) {
        String token = result.get(list.get(0));
        if (token.equals("N")) {
            list.set(0, list.get(0) + 1);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        list.set(0, list.get(0) + 1);
        root.left = deserialize(result, list);
        root.right = deserialize(result, list);
        return root;
    }
}