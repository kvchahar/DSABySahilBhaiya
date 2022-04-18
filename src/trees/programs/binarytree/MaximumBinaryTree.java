package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        return constructTree(start, end, nums);
    }

    private TreeNode constructTree(int start, int end, int[] nums) {
        if (start > end)
            return null;

        int index = maxElementIndex(start, end, nums);
        int value = nums[index];

        TreeNode rootNode = new TreeNode(value);
        TreeNode left = constructTree(start, index - 1, nums);
        TreeNode right = constructTree(index + 1, end, nums);

        rootNode.left = left;
        rootNode.right = right;

        return rootNode;

    }

    private int maxElementIndex(int start, int end, int[] num) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = start; i <= end; i++) {
            if (max < num[i]) {
                max = num[i];
                index = i;
            }
        }
        return index;
    }
}
