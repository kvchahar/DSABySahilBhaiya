package trees.programs.binarysearchtree;

import trees.TreeNode.TreeNode;

public class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         TreeNode currentNode = root;

//         if(currentNode==null){
//             return null;
//         }

//         while(currentNode!=null){

//             if(currentNode.val>p.val && currentNode.val>q.val){
//                 currentNode = lowestCommonAncestor(currentNode.left,p,q);

//             }else if(currentNode.val<p.val && currentNode.val<q.val){
//                 currentNode = lowestCommonAncestor(currentNode.right,p,q);
//             } else{
//                 return currentNode;
//             }
//         }

//         return null;




        // recursive
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);

        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
