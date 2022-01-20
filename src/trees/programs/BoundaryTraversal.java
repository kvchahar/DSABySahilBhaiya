package trees.programs;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal {
    ArrayList<Integer> boundary(TreeNode node)
    {
        ArrayList<Integer> answers = new ArrayList<>();
        if(isLeaf(node)==false) answers.add(node.val);
        addLeftBoundary(node,answers);
        addLeaves(node,answers);
        addRightBoundary(node,answers);

        return answers;
    }

    private boolean isLeaf(TreeNode root){
        return (root.left==null) && (root.right==null);
    }

    private void addLeftBoundary(TreeNode root, ArrayList<Integer> answers){
        TreeNode current = root.left;
        while(current!=null){
            if(isLeaf(current)==false) answers.add(current.val);
            if(current.left!=null) current = current.left;
            else current = current.right;
        }
    }

    private void addRightBoundary(TreeNode root, ArrayList<Integer> answers){
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode current = root.right;
        while(current!=null){
            if(isLeaf(current)==false) list.add(current.val);
            if(current.right!=null) current = current.right;
            else current = current.left;
        }
        for(int i = list.size()-1; i>=0; i--){
            answers.add(list.get(i));
        }
    }

    private void addLeaves(TreeNode root, ArrayList<Integer> answers){
        if(isLeaf(root)) {
            answers.add(root.val);
            return;
        }

        if(root.left!=null)
            addLeaves(root.left, answers);
        if(root.right!=null)
            addLeaves(root.right, answers);

    }
}
