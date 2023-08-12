package src.com.leetcode.s235;

import src.com.utils.StrToTreeNode;
import src.com.utils.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        StrToTreeNode strToTreeNode = new StrToTreeNode();
        TreeNode root = strToTreeNode.createTree("3,1,4,null,2");
        System.out.println("result = " + solution.lowestCommonAncestor(root, root.left.right, root.right).val);
    }
}
