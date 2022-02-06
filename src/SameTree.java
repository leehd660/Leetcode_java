import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean answer = true;
        Deque<TreeNode> dequeP = new ArrayDeque<>();
        Deque<TreeNode> dequeQ = new ArrayDeque<>();
        if (p==null && q==null) {
            answer = true;
        }
        else if ((p!=null && q==null) || (p==null && q!=null)) {
            answer = false;
        }
        else {
            dequeP.add(p);
            dequeQ.add(q);
            if (p.val == q.val) {
                while (!dequeP.isEmpty() && !dequeQ.isEmpty()) {
                    TreeNode nodeP = dequeP.pollFirst();
                    TreeNode nodeQ = dequeQ.pollFirst();
                    if (nodeP.left != null && nodeQ.left != null && nodeP.left.val == nodeQ.left.val) {
                        dequeP.add(nodeP.left);
                        dequeQ.add(nodeQ.left);
                    } else if (nodeP.left == null && nodeQ.left == null) {
                        answer = true;
                    } else {
                        answer = false;
                        break;
                    }
                    if (nodeP.right != null && nodeQ.right != null && nodeP.right.val == nodeQ.right.val) {
                        dequeP.add(nodeP.right);
                        dequeQ.add(nodeQ.right);
                    } else if (nodeP.right == null && nodeQ.right == null) {
                        answer = true;
                    } else {
                        answer = false;
                        break;
                    }
                }
                if (answer && dequeP.isEmpty() && dequeQ.isEmpty()) {
                    answer = true;
                } else {
                    answer = false;
                }
            } else {
                answer = false;
            }
        }
        return answer;
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
