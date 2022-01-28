package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null){
            return null;
        }

        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else{

            if(root.left==null && root.right==null){
                root = null;
                return root;
            }

            if(root.left==null && root.right!=null){
                root = root.right;
                return root;
            }

            if(root.left!=null && root.right==null){
                root = root.left;
                return root;
            }

            TreeNode rightSubTree = root.right;
            TreeNode tempNode = leftMostNode(root.right);

            int temp = root.val;
            root.val = tempNode.val;
            tempNode.val = temp;

            root.right = deleteNode(root.right,tempNode.val);

            return root;

        }

        return root;
    }

    private TreeNode leftMostNode(TreeNode currentNode){

        while(currentNode.left!=null){
            currentNode = currentNode.left;
        }

        return currentNode;
    }
}
