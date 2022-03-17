import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.


    public String serialize(TreeNode root) {
        String answer = "";
        if (root == null) {
            return answer;
        }
        else {
//            answer += root.val;
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<String> list = new ArrayList<>();
            deque.add(root);
            list.add(String.valueOf(root.val));
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.add(node.left);
                    list.add(String.valueOf(node.left.val));
                }
                else {
                    list.add(" ");
                }
                if (node.right != null) {
                    deque.add(node.right);
                    list.add(String.valueOf(node.right.val));
                }
                else {
                    list.add(" ");
                }
            }
            int size = list.size();
            for (int i=0; i<size; i++) {
                answer += list.get(i);
                if (i!=size-1) {
                    answer += ",";
                }
            }
            System.out.println(answer);
            return answer;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        else {
            String[] arr = data.split(",");
            Deque<TreeNode> deque = new ArrayDeque<>();
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            deque.add(root);
            for (int i=1; i<arr.length; i+=2) {
                TreeNode node = deque.pollFirst();
                if (!arr[i].equals(" ")) {
                    TreeNode node1 = new TreeNode(Integer.parseInt(arr[i]));
                    node.left = node1;
                    deque.add(node1);
                }
                if (!arr[i+1].equals(" ")) {
                    TreeNode node2 = new TreeNode(Integer.parseInt(arr[i+1]));
                    node.right = node2;
                    deque.add(node2);
                }
            }
            return root;
        }
    }
}
