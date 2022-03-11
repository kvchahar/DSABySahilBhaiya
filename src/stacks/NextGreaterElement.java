package stacks;

import java.util.Stack;

public class NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Long> stack = new Stack<>();
        long[] res = new long[n];
        for(int i = n-1; i>=0; i--){
            long value = arr[i];
            while(!stack.isEmpty() && stack.peek()<value){
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(value);
        }
        return res;
    }
}
