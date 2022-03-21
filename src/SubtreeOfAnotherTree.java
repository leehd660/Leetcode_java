import java.util.ArrayDeque;
import java.util.Deque;

public class SubtreeOfAnotherTree {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean answer = false;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            if (deque.peekFirst().val == subRoot.val) {
                if (checkSame(deque.peekFirst(), subRoot)) {
                    answer = true;
                    break;
                }
            }
            if (deque.peekFirst().left != null) {
                deque.add(deque.peekFirst().left);
            }
            if (deque.peekFirst().right != null) {
                deque.add(deque.peekFirst().right);
            }
            deque.pollFirst();
        }
        return answer;
    }

    static boolean checkSame(TreeNode node, TreeNode subRoot) {
        boolean answer = true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> dequeSub = new ArrayDeque<>();
        deque.add(node);
        dequeSub.add(subRoot);
        while(!dequeSub.isEmpty()) {
            if (deque.peekFirst().val == dequeSub.peekFirst().val) {
                if (deque.peekFirst().left != null && dequeSub.peekFirst().left != null) {
                    deque.add(deque.peekFirst().left);
                    dequeSub.add(dequeSub.peekFirst().left);
                } else if (deque.peekFirst().left == null && dequeSub.peekFirst().left == null) {
                    //pass
                } else {
                    answer = false;
                    break;
                }
                if (deque.peekFirst().right != null && dequeSub.peekFirst().right != null) {
                    deque.add(deque.peekFirst().right);
                    dequeSub.add(dequeSub.peekFirst().right);
                } else if (deque.peekFirst().right == null && dequeSub.peekFirst().right == null) {
                    //pass
                } else {
                    answer = false;
                    break;
                }
            }
            else {
                answer = false;
            }
            deque.pollFirst();
            dequeSub.pollFirst();
        }
        return answer;
    }
}
