package recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();

        totalWays(0,target,candidates, new ArrayList<>(), combinations);

        return combinations;
    }


    private static void totalWays(int currentIndex,int target,int[] candidates, List<Integer> answer, List<List<Integer>> combinations){


        if(currentIndex>=candidates.length){
            return;
        }

        if(target==0){
            combinations.add(new ArrayList<>(answer));
            return;
        }

        int currentValue = candidates[currentIndex];

        if(target>=currentValue){
            answer.add(currentValue);
            totalWays(currentIndex,target - currentValue, candidates, answer, combinations);
            answer.remove(answer.size()-1);
        }
        totalWays(currentIndex + 1, target, candidates, answer, combinations);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}