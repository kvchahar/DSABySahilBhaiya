package trees.programs;

import trees.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder answer = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                answer.append("null ");
                continue;
            }

            answer.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);

        }
        return answer.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = queue.poll();
            if (!arr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!arr[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}
