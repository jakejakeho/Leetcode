package src.com.leetcode.s108;
import src.com.utils.TreeNode;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
        System.out.println(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root;
        if (mid >= 0 && mid < nums.length) {
            root = new TreeNode(nums[mid]);
        } else {
            return null;
        }
        root.left = recursive(nums, start, mid - 1);
        root.right = recursive(nums, mid + 1, end);
        return root;
    }
}