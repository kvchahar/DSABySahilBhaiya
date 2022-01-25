package stacks;

import java.util.Stack;

public class StockSpanProblem {
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int[] stock = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stock[i] = i + 1;
            } else {
                stock[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return stock;
    }
}
