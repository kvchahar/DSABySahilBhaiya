package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<>();
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();

        populateParentMap(root,null,parentMap);
        printKDistanceNodes(target,k,new HashSet<>(),parentMap,answer);

        return answer;
    }

    private void printKDistanceNodes(TreeNode currentNode, int k, Set<TreeNode> set, HashMap<TreeNode,TreeNode> parentMap, List<Integer> answer){

        if(currentNode==null || set.contains(currentNode) || k<0){
            return;
        }

        if(k==0){
            answer.add(currentNode.val);
            return;
        }

        set.add(currentNode);

        printKDistanceNodes(currentNode.left, k-1, set, parentMap, answer);
        printKDistanceNodes(currentNode.right, k-1, set, parentMap, answer);
        printKDistanceNodes(parentMap.get(currentNode), k-1, set, parentMap, answer);
        return;

    }

    private void populateParentMap(TreeNode currentNode, TreeNode currentParent, HashMap<TreeNode,TreeNode> parentMap){

        if(currentNode==null){
            return;
        }

        parentMap.put(currentNode,currentParent);

        populateParentMap(currentNode.left, currentNode, parentMap);
        populateParentMap(currentNode.right, currentNode, parentMap);

        return;
    }
}
