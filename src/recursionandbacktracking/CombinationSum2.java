package recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int index, int[] arr, int target, List<List<Integer>> answers,List<Integer> list){
        if(target==0){
            answers.add(new ArrayList<>(list));
        }

        for(int i = index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;

            list.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],answers,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

}
