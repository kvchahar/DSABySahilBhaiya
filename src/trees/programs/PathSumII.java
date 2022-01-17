package trees.programs;

import trees.TreeNode.Impl;
import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answers = new ArrayList<>();

        rootToLeafSum(root, new ArrayList<>(), 0, answers, targetSum);

        return answers;
    }

    public static void rootToLeafSum(TreeNode root, List<Integer> list,int sum, List<List<Integer>> answers, int targetSum){

        if(root==null){
            return;
        }

        sum += root.val;
        list.add(root.val);

        if(root.left==null && root.right==null && sum==targetSum){
            answers.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }


        rootToLeafSum(root.left, list, sum, answers,targetSum);
        rootToLeafSum(root.right, list,sum, answers, targetSum);

        list.remove(list.size()-1);

    }

    public static void main(String[] args) {
        Impl tree = new Impl();
        tree.createTree();
        List<List<Integer>> list = pathSum(tree.root,22);
        System.out.println(list);
    }
}
