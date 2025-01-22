package hot100.binarytree;

/**
 * num 226 翻转二叉树
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        //treeNode.left.left = new TreeNode(4);
        //treeNode.left.right = new TreeNode(5);
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(treeNode));
        System.out.println(BinaryTreeInorderTraversal.inorderTraversal(invertTree(treeNode)));
    }

   public static TreeNode invertTree(TreeNode root) {
       if (root == null) {
           return null;
       }
       TreeNode left = invertTree(root.left);
       TreeNode right = invertTree(root.right);
       root.left = right;
       root.right = left;
       return root;
   }
}
