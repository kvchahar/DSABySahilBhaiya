package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        generateAllSubsets(nums,0,new ArrayList<>(), powerSet);

        return powerSet;
    }

    private static void generateAllSubsets(int[] nums, int currentIndex, List<Integer> currentSubset, List<List<Integer>> powerSet){

        if(currentIndex>=nums.length){
//            powerSet.add(currentSubset);
            powerSet.add(new ArrayList<>(currentSubset)); // first store the copy of current subset else it will return the empty powerSet of subsets
            return;
        }

        int currentValue = nums[currentIndex];

        currentSubset.add(currentValue);
        generateAllSubsets(nums, currentIndex + 1, currentSubset, powerSet);

        currentSubset.remove(currentSubset.size()-1);
        generateAllSubsets(nums, currentIndex + 1, currentSubset, powerSet);

        return;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
