package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {

        int sum = 0;
        List<String> answers = new ArrayList<>();
        sumOfNodes(root,"",answers);

        for(int i = 0; i<answers.size(); i++){
            sum += Integer.parseInt(answers.get(i));
        }
        return sum;
    }

    private void sumOfNodes(TreeNode root, String path, List<String> answers){

        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            path += String.valueOf(root.val);
            answers.add(path);
            return;
        }

        sumOfNodes(root.left, path + String.valueOf(root.val), answers);
        sumOfNodes(root.right, path + String.valueOf(root.val), answers);
        return;
    }
}
