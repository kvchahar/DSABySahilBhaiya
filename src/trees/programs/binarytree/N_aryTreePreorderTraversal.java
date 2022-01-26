package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal {
//     public List<Integer> preorder(Node root) {
//         List<Integer> list = new ArrayList<>();
//         postOrderTraversal(root,list);

//         return list;
//      }   

//     public void preOrderTraversal(Node root, List<Integer> list){

//         if(root==null){
//             return;
//         }


//        for(Node child : root.children){
//            preOrderTraversal(child,list);
//        }
//          list.add(root.val);

//         return;
//     }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);

        return list;
    }

    public void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);

            List<TreeNode> currentNode = current.children;

            int size = currentNode.size();

            for (int i = size - 1; i >= 0; i--) {
                stack.push(currentNode.get(i));
            }
        }

    }
}