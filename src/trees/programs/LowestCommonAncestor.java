package trees.programs;

import trees.TreeNode.Impl;
import trees.TreeNode.TreeNode;

public class LowestCommonAncestor {
    public TreeNode root;
    public void createTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
//        TreeNode fourth = new TreeNode(11);
//        TreeNode fifth = new TreeNode(null);
        TreeNode sixth = new TreeNode(4);
        TreeNode seventh = new TreeNode(5);
        TreeNode eighth = new TreeNode(8);
//        TreeNode ninth = new TreeNode(2);
        TreeNode tenth = new TreeNode(6);
        TreeNode eleventh = new TreeNode(7);
//        TreeNode twelfth = new TreeNode(5);
//        TreeNode thirteen = new TreeNode(1);


        root = first;
        first.left = second;
        first.right = third;
//        second.left = ;
//        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
//        fourth.left = eighth;
//        fourth.right = ninth;
//        fifth.left = tenth;
//        fifth.right = eleventh;
        sixth.left = eighth;
        seventh.left = tenth;
        seventh.right = eleventh;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        System.out.println(root.val);

        if(left==null){
            return right;
        }

        else if(right==null){
            return left;
        }
        else{
            return root;
        }

    }

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        l.createTree();
        l.lowestCommonAncestor(l.root,new TreeNode(7),new TreeNode(8));
//        System.out.println(l.root.val);
    }

}
