

public class MaximunDepthOfBT {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftNum = 0;
            int rightNum = 0;
            if (root.left != null) {
                leftNum = maxDepth(root.left);
            }
            else {
                leftNum=0;
            }
            if (root.right != null) {
                rightNum = maxDepth(root.right);
            }
            else {
                rightNum = 0;
            }
            return Math.max(leftNum, rightNum)+1;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}