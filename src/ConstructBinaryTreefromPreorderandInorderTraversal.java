import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static class TreeNode {
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

    public static void main(String[] args) {
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        System.out.println(buildTree(a,b));
    }

    private static List<Integer> list;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) {
            TreeNode node = new TreeNode(preorder[0]);
            return node;
        }
        else {
            list = new ArrayList<>();
            TreeNode root = new TreeNode(preorder[0]);
            list.add(preorder[0]);
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    if (i == 0) {
                        root.right = recursion(preorder, inorder, i + 1, inorder.length - 1);
                    } else if (i == inorder.length - 1) {
                        root.left = recursion(preorder, inorder, 0, i - 1);
                    } else {
                        root.left = recursion(preorder, inorder, 0, i - 1);
                        root.right = recursion(preorder, inorder, i + 1, inorder.length - 1);
                    }
                    break;
                }
            }
            return root;
        }
    }
    static TreeNode recursion (int[] preorder, int[] inorder, int start, int fin) {
        if (start == fin) {
            TreeNode node = new TreeNode(inorder[start]);
            list.add(inorder[start]);
            return node;
        }
        else {
            TreeNode node = new TreeNode();
            boolean check = false;
            for (int i=0; i<preorder.length; i++) {
                if (!list.contains(preorder[i])) {
                    for (int j = start; j <= fin; j++) {
                        if (preorder[i] == inorder[j]) {
                            node.val = preorder[i];
                            list.add(preorder[i]);
                            node.left = recursion(preorder, inorder, start, j - 1);
                            node.right = recursion(preorder, inorder, j + 1, fin);
                            check = true;
                            break;
                        }
                    }
                    if (check) break;
                }
            }
            if (check) {
                return node;
            }
            else {
                return null;
            }
        }
    }
}
