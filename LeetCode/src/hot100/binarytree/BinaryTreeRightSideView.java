package hot100.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199 二叉搜索树的右视图
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(rightSideView(treeNode));

    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode poll;
        int size ;
        while (!queue.isEmpty()){
            size = queue.size();
            // 每一层中的最后一个，单独处理
            for(int i=0 ;i<size-1 ;i++){
                poll = queue.poll();
                if(poll.left!=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
            }
            poll = queue.poll();
            if(poll.left!=null) queue.add(poll.left);
            if(poll.right!=null) queue.add(poll.right);
            res.add(poll.val);
        }
        return res;
    }
}
