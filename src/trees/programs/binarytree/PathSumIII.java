package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.HashMap;

public class PathSumIII {
    int ways = 0;

    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Integer,Integer> memo = new HashMap<>();
        memo.put(0,1);
        rootToLeafSum(root,targetSum, 0,memo);

        return ways;

    }

    public void rootToLeafSum(TreeNode root, int targetSum, int currSum, HashMap<Integer,Integer> memo){

        if(root==null){
            return;
        }

        int sum = currSum + root.val;
        int prefixSum = sum - targetSum;

        if(memo.containsKey(prefixSum)){
            ways += memo.get(prefixSum);
        }

        // if(memo.containsKey(sum)){
        //     memo.put(sum,memo.get(sum)+1);
        // }else{
        //     memo.put(sum,1);
        // }

        memo.put(sum, memo.getOrDefault(sum, 0) + 1);
        rootToLeafSum(root.left,targetSum,currSum + root.val, memo);
        rootToLeafSum(root.right,targetSum,currSum + root.val, memo);
        memo.put(sum,memo.get(sum)-1);
        return;

    }
}
