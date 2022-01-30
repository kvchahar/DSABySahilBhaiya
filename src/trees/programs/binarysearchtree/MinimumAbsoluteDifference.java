package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifference {
    public int getMinimumDifference(TreeNode root) {

        List<Integer> answer = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        inorderTraversal(root,answer);

        for(int i = 1; i<answer.size(); i++){
            if(answer.get(i)-answer.get(i-1)<minValue){
                minValue = answer.get(i) - answer.get(i-1);
            }
        }
        return minValue;
    }

    private void inorderTraversal(TreeNode root,List<Integer> answer){

        if(root==null){
            return;
        }

        inorderTraversal(root.left,answer);
        answer.add(root.val);
        inorderTraversal(root.right,answer);

        return;
    }
}
