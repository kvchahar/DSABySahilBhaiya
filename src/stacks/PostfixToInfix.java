package stacks;

import java.util.Stack;

public class PostfixToInfix {
    private static void postfixToInfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                String first = stack.pop();
                String second = stack.pop();
                String concatenate = "(" + second + ch + first + ")";
                stack.push(concatenate);
            } else {
                String s = String.valueOf(ch);
                stack.push(s);
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        postfixToInfix("ab*c+"); // [((a*b)+c)]
    }
}
