package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifference {
//    public int getMinimumDifference(TreeNode root) {
//
//        List<Integer> answer = new ArrayList<>();
//        int minValue = Integer.MAX_VALUE;
//        inorderTraversal(root,answer);
//
//        for(int i = 1; i<answer.size(); i++){
//            if(answer.get(i)-answer.get(i-1)<minValue){
//                minValue = answer.get(i) - answer.get(i-1);
//            }
//        }
//        return minValue;
//    }
//
//    private void inorderTraversal(TreeNode root,List<Integer> answer){
//
//        if(root==null){
//            return;
//        }
//
//        inorderTraversal(root.left,answer);
//        answer.add(root.val);
//        inorderTraversal(root.right,answer);
//
//        return;
//    }




    // without extra space
    public int getMinimumDifference(TreeNode root){
        TreeNode[] prev = new TreeNode[1];
        int[] min  = {Integer.MAX_VALUE};
        inorder(root,prev,min);

        return min[0];
    }

    private void inorder(TreeNode root, TreeNode[] prev, int[] min){

        if(root==null){
            return;
        }

        inorder(root.left,prev,min);

        if(prev[0]!=null){
            min[0] = Math.min(min[0],Math.abs(root.val-prev[0].val));
        }
        prev[0] = root;
        inorder(root.right,prev,min);

        return;
    }
}
