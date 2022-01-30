package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> answer = new ArrayList<>();
        inorderTraversal(root,answer);

        if(answer.size()==1){
            return answer.get(0);
        }

        return answer.get(k-1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> answer){

        if(root==null){
            return;
        }

        inorderTraversal(root.left,answer);
        answer.add(root.val);
        inorderTraversal(root.right,answer);

        return;

    }
}
