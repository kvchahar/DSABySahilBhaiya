package trees.programs;

import trees.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class MaximumWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().level;
            int left = 0, right = 0;

            for (int i = 0; i < size; i++) {

                int currentId = queue.peek().level - min;

                TreeNode node = queue.peek().node;
                queue.poll();

                if (i == 0) left = currentId;
                if (i == size - 1) right = currentId;

                if (node.left != null) queue.offer(new Pair(node.left, currentId * 2 + 1));
                if (node.right != null) queue.offer(new Pair(node.right, currentId * 2 + 2));
            }
            width = Math.max(width, right - left + 1);
        }
        return width;
    }
}