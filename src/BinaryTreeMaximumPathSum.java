
public class BinaryTreeMaximumPathSum {
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
    private static int answer;
    public int maxPathSum(TreeNode root) {
        answer = root.val;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        else {
            recursion(root);
            return answer;
        }
    }
    static int recursion (TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int leftNum = recursion(root.left);
            int rightNum = recursion(root.right);
            //음수는 버리기
            leftNum = Math.max(leftNum, 0);
            rightNum = Math.max(rightNum, 0);
            answer = Math.max(answer, rightNum+root.val+ leftNum);
            return Math.max(Math.max(leftNum+root.val , rightNum+ root.val),root.val);
        }
    }
}
