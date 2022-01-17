package dynamicprogramming;

public class StoneGame {
    public boolean stoneGame(int[] piles) {

        int alice = 0;
        int bob = 0;

        int left = 0;
        int right = piles.length - 1;

        while(left<right){
            if(piles[left]==piles[right] || piles[left]>piles[right]){
                alice += piles[left];
                bob += piles[right];
            }else{
                alice += piles[right];
                bob += piles[left];
            }
            left++;
            right--;
        }

        return alice > bob;
    }
}
