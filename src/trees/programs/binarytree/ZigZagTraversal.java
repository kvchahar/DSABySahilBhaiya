package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> answers = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null){
            return answers;
        }

        queue.offer(root);

        boolean flag = true;

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i<size; i++){


                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }

                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }

                if(flag) list.add(queue.poll().val);
                else list.add(0,queue.poll().val);
            }
            flag = !flag;
            answers.add(list);
        }
        return answers;
    }
}
