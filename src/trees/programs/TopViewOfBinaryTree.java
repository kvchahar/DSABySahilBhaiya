package trees.programs;


import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfBinaryTree
{
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(TreeNode root)
    {
        // add your code
        ArrayList<Integer> answer = new ArrayList<>();

        if(root==null)
            return answer;

        int left = 1000000;
        int right = -1000000;

        HashMap<Integer,Integer> memo = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root,0));

        while(!queue.isEmpty()){
            Pair currentPair = queue.remove();
            TreeNode currentNode = currentPair.node;
            int currentHd = currentPair.hd;

            left = Math.min(left,currentHd);
            right = Math.max(right,currentHd);

            if(!memo.containsKey(currentHd)){
                memo.put(currentHd,currentNode.val);
            }

            if(currentNode.left!=null){
                queue.add(new Pair(currentNode.left,currentHd-1));
            }

            if(currentNode.right!=null){
                queue.add(new Pair(currentNode.right,currentHd+1));
            }
        }

        for(int i = left; i<=right; i++){
            answer.add(memo.get(i));
        }

        return answer;
    }
}