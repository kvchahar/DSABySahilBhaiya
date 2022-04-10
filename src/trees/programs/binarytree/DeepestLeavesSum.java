package trees.programs.binarytree;

import trees.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        deepestSum(root, map, 1);

        int max = Integer.MIN_VALUE;

        for (int level : map.keySet()) {
            if (level > max) {
                max = level;
            }
        }

        System.out.println(max);
        List<Integer> sum = map.get(max);

        return sum.stream().reduce(0, (a, b) -> a + b);

    }

    private void deepestSum(TreeNode root, HashMap<Integer, List<Integer>> map, int levels) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (map.containsKey(levels)) {
                List<Integer> list = map.get(levels);
                list.add(root.val);
                map.put(levels, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.put(levels, list);
            }
        }

        deepestSum(root.left, map, levels + 1);
        deepestSum(root.right, map, levels + 1);
    }
}
