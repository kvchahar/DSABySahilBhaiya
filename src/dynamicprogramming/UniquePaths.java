package dynamicprogramming;

import java.util.HashMap;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        return numberOfPaths(m,n, new HashMap<>());
    }

    public int numberOfPaths(int destinationRow, int destinationColumn, HashMap<String,Integer> memo){
        if(destinationRow==1||destinationColumn==1){
            return 1;
        }

        String currentKey = Integer.toString(destinationRow) +"_" + Integer.toString(destinationColumn);

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int totalPaths = numberOfPaths(destinationRow - 1, destinationColumn, memo) +
                numberOfPaths(destinationRow, destinationColumn-1, memo);
        memo.put(currentKey, totalPaths);
        return totalPaths;
    }

    public static void main(String[] args) {
        UniquePaths paths = new UniquePaths();
        System.out.println(paths.uniquePaths(3,7)); // 28
    }
}