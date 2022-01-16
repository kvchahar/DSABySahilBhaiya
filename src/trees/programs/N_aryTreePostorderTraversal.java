package trees.programs;/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class N_aryTreePostorderTraversal {
//     public List<Integer> postorder(Node root) {
//         List<Integer> list = new ArrayList<>();
//         postOrderTraversal(root,list);

//         return list;
//      }   

//     public void postOrderTraversal(Node root, List<Integer> list){

//         if(root==null){
//             return;
//         }


//        for(Node child : root.children){
//            postOrderTraversal(child,list);
//        }
//          list.add(root.val);

//         return;
//     }

    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);

        Collections.reverse(list);
        return list;
    }

    public void postOrderTraversal(TreeNode root, List<Integer> list) {

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

            for (int i = 0; i < size; i++) {
                stack.push(currentNode.get(i));
            }
        }
    }
}