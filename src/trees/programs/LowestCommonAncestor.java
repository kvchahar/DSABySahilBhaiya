package trees.programs;

import trees.TreeNode.TreeNode;

public class LowestCommonAncestor {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q) {
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//
//        System.out.println(root.val);
//
//        if (left == null) {
//            return right;
//        } else if (right == null) {
//            return left;
//        } else {
//            return root;
//        }
//
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(root.val==p.val || root.val==q.val){
            return root;
        }

        else if(left!=null && right!=null){
            return root;
        }

        if(left==null){
            return right;
        }

        else if(right==null){
            return left;
        }
        else{
            return null;
        }
    }

}
