import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        else {
            TreeNode answer = root;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                if (deque.peekFirst().left != null && deque.peekFirst().right != null) {
                    deque.add(deque.peekFirst().left);
                    deque.add(deque.peekFirst().right);
                    TreeNode keepNode = deque.peekFirst().left;
                    deque.peekFirst().left = deque.peekFirst().right;
                    deque.peekFirst().right = keepNode;
                }
                else if (deque.peekFirst().left != null && deque.peekFirst().right == null) {
                    deque.add(deque.peekFirst().left);
                    deque.peekFirst().right = deque.peekFirst().left;
                    deque.peekFirst().left = null;
                }
                else if (deque.peekFirst().left == null && deque.peekFirst().right != null) {
                    deque.add(deque.peekFirst().right);
                    deque.peekFirst().left = deque.peekFirst().right;
                    deque.peekFirst().right = null;
                }
                deque.pollFirst();
            }
            return root;
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
