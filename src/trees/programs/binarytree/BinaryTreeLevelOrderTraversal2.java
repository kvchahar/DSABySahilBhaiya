package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> answers = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        reverseLevelOrder(root,answers);
        // System.out.println(answers);
        for(int i = 0; i<answers.size(); i++){
            res.add(0,answers.get(i));
        }
        return res;
    }

    private void reverseLevelOrder(TreeNode root, List<List<Integer>> answers){

        if(root==null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> answer = new ArrayList<>();
            for(int i = 0; i<size; i++){
                if(queue.peek().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.add(queue.peek().right);
                }
                answer.add(queue.poll().val);
            }

            answers.add(answer);

        }

    }
}
