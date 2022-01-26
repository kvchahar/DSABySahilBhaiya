package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return list;
    }
}
