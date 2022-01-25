package stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for(int i = 0; i<=heights.length; i++){
            while(!stack.isEmpty() && (i==heights.length || heights[stack.peek()]>=heights[i])){
                int height = heights[stack.pop()];

                int width;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }

                max = Math.max(max,height*width);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
