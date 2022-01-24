package dynamicprogramming;

public class JumpGame {

    boolean isPossible = false;

    public boolean canJump(int[] nums) {
        return isPossible(0,new boolean[nums.length],nums);
    }

    private boolean isPossible(int currentPos, boolean[] badPaths, int[] nums){

        if(currentPos==nums.length-1){
            return true;
        }

        if(badPaths[currentPos]) return false;

        int range = nums[currentPos];

        for(int i = 1; i <= range; i++) {
            if(isPossible(currentPos + i,badPaths,nums)) {
                return true;
            }
        }

        badPaths[currentPos] = true;
        return false;
    }
}