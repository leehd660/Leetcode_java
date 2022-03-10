import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    private static List<List<Integer>> answer;

    public List<List<Integer>> levelOrder(TreeNode root) {
        answer = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            BFS(deque);
        }
        return answer;
    }

    static void BFS(Deque<TreeNode> deque) {
        if (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                list.add(node.val);
            }
            answer.add(list);
            BFS(deque);
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
