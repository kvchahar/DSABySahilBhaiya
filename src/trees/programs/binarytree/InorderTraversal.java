package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
//      public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         inorder(root,list);

//         return list;
//      }   

//     public void inorder(TreeNode root, List<Integer> list){

//         if(root==null){
//             return;
//         }

//         inorder(root.left,list);
//         list.add(root.val);
//         inorder(root.right,list);


//         return;
//     }





    // Iterative
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root==null)
            return list;

        addLeftSubtree(root, stack);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            list.add(current.val);

            if(current.right!=null){
                addLeftSubtree(current.right,stack);
            }
        }
        return list;
    }

    public void addLeftSubtree(TreeNode current, Stack<TreeNode> stack){

        stack.push(current);

        while(current.left!=null){
            stack.push(current.left);
            current = current.left;
        }
        return;
    }
}