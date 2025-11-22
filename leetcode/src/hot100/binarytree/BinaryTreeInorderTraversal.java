package hot100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(inorderTraversal(treeNode));
    }

    public static List<Integer> inorderTraversal(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        inorder(treeNode, res);
        return res;
    }

    /**
     * 递归遍历
     */
    public static void inorder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left, list);
        list.add(treeNode.val);
        inorder(treeNode.right, list);
    }

    public static List<Integer> inorder2(TreeNode root, List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()){
            while(root !=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
