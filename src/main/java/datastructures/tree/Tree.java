package datastructures.tree;

public class Tree {

 public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    int max_path_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return max_path_sum;
    }

    public int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));
        max_path_sum = Math.max(left + right + root.val, max_path_sum);
        return Math.max(left, right) + root.val;
    }
}
