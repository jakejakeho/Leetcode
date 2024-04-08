package src.com.leetcode.s617;
import src.com.utils.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.right = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);
        System.out.println(solution.mergeTrees(t1, t2));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recursive(root1, root2);
    }

    private TreeNode recursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = recursive(root1.left, root2.left);
        root.right = recursive(root1.right, root2.right);
        return root;
    }
}