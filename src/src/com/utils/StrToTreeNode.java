package src.com.utils;


import java.util.LinkedList;
import java.util.Queue;

public class StrToTreeNode {
    public TreeNode createTree(String tree) {
        String[] ss = tree.split(",");
        return createTree(ss);
    }

    public TreeNode createTree(String[] tree) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = constructOne(tree[0]);
        q.add(root);
        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode tn = q.poll();
            if (tn == null) {
                continue;
            }

            if (idx == tree.length) {
                break;
            }
            TreeNode left_ = constructOne(tree[idx]);
            tn.left = left_;
            q.add(left_);
            idx++;
            if (idx == tree.length) {
                break;
            }
            TreeNode right_ = constructOne(tree[idx]);
            idx++;

            tn.right = right_;
            q.add(right_);
        }

        return root;
    }

    private void printNode(TreeNode tn, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }
        sb.append(tn.val);
        System.out.println(sb.toString());
    }

    private TreeNode constructOne(String s) {
        if (s.compareTo("null") == 0) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }
}
