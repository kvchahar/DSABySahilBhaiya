package dynamicprogramming;

import java.util.HashMap;

class NthTribonacciNumber {
    public int tribonacci(int n) {
        return nthFib(n, new HashMap<>());
    }

    public int nthFib(int n, HashMap<Integer,Integer> memo){
        if(n<=1){
            return n;
        }

        if(n==2){
            return 1;
        }

        int currentKey = n;

        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }

        int a = nthFib(n-1,memo);
        int b = nthFib(n-2, memo);
        int c = nthFib(n-3, memo);
        memo.put(n,a+b+c);
        return a + b + c;
    }

    public static void main(String[] args) {
        NthTribonacciNumber nth=  new NthTribonacciNumber();
        System.out.println(nth.tribonacci(4)); // 4
        System.out.println(nth.tribonacci(25)); // 1389537
    }
}