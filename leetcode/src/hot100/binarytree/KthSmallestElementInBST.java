package hot100.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * num 230 二叉搜索树中第k小的元素
 */
public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        System.out.println(kthSmallest(treeNode, 2));

    }

    private static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
