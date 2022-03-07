package stacks;

import java.util.Stack;

public class PrefixToInfix {
    private static void prefixToInfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                String first = stack.pop();
                String second = stack.pop();
                String concatenate = "(" + first + ch + second + ")";
                stack.push(concatenate);
            } else {
                String s = String.valueOf(ch);
                stack.push(s);
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        prefixToInfix("*+AB-CD"); // [((A+B)*(C-D))]
    }
}
