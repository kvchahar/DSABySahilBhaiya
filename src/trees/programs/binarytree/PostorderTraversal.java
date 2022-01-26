package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostorderTraversal {
    ArrayList<Integer> postOrder(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();

            list.add(current.val);

            if(current.left!=null){
                stack.push(current.left);
            }

            if(current.right!=null){
                stack.push(current.right);
            }
        }

        Collections.reverse(list);

        return list;
    }
}
