package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class SumOfNodesWithinKDistanceFromTarget {

    static int sum_at_distK(TreeNode root, int target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        createParentMap(root, null, parentMap);
        int[] sum = new int[1];
        HashSet<TreeNode> set = new HashSet<>();
        createTargetNode(target, root, parentMap, k, sum, set);

        return sum[0];
    }

    private static void createTargetNode(int target, TreeNode root, HashMap<TreeNode, TreeNode> parentMap,
                                         int k, int[] sum, HashSet<TreeNode> set) {
        if (root == null) {
            return;
        }


        if (root.val == target) {
            sumOfNodes(root, parentMap, k, sum, set);
            return;
        }

        createTargetNode(target, root.left, parentMap, k, sum, set);
        createTargetNode(target, root.right, parentMap, k, sum, set);

    }

    static void sumOfNodes(TreeNode currentNode, HashMap<TreeNode, TreeNode> parentMap, int k,
                           int[] sum, HashSet<TreeNode> set) {

        if (currentNode == null || set.contains(currentNode) || k < 0) {
            return;
        }


        if (k >= 0) {
            sum[0] += currentNode.val;
        }

        set.add(currentNode);


        sumOfNodes(currentNode.left, parentMap, k - 1, sum, set);
        sumOfNodes(currentNode.right, parentMap, k - 1, sum, set);
        sumOfNodes(parentMap.get(currentNode), parentMap, k - 1, sum, set);
        return;

    }

    static void createParentMap(TreeNode currentNode, TreeNode currentParent, HashMap<TreeNode, TreeNode> parentMap) {

        if (currentNode == null) {
            return;
        }

        parentMap.put(currentNode, currentParent);

        createParentMap(currentNode.left, currentNode, parentMap);
        createParentMap(currentNode.right, currentNode, parentMap);
        return;
    }
}
