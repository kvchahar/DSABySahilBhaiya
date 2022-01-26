package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answers = new ArrayList<>();
        rightSideView(root,1,new HashSet<>(),answers);
        return answers;
    }

    public void rightSideView(TreeNode root, int level, HashSet<Integer> set, List<Integer> answers){
        if(root==null){
            return;
        }

        if(!set.contains(level)){
            set.add(level);
            answers.add(root.val);
        }

        rightSideView(root.right, level + 1, set, answers);
        rightSideView(root.left, level + 1, set, answers);

        return;

    }
}
