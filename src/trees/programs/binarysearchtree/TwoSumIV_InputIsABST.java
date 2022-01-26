package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV_InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> answers = new ArrayList<>();

        inorderTraversal(answers,root);

        int left = 0;
        int right = answers.size()-1;

        while(left<right){

            if(answers.get(left)+answers.get(right)==k){
                return true;
            }else if(answers.get(left)+answers.get(right)>k){
                right -= 1;
            }else{
                left += 1;
            }
        }
        return false;

    }

    private void inorderTraversal(List<Integer> answers, TreeNode root){
        if(root==null){
            return;
        }

        inorderTraversal(answers,root.left);
        answers.add(root.val);
        inorderTraversal(answers,root.right);

        return;
    }
}
