package recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1000);
        possiblePermute(0, arr, list, nums, nums.length);

        return list;
    }

    public void possiblePermute(int index, int[] arr, List<List<Integer>> answer, int[] nums, int n) {

        if (index == n) {
            List<Integer> list = populateAns(arr);
            answer.add(list);
            return;
        }

        int current = nums[index];
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1000) {
                arr[i] = current;
                possiblePermute(index + 1, arr, answer, nums, n);
                arr[i] = -1000;
            }
        }
        return;
    }

    public List<Integer> populateAns(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
