package stacks;

import java.util.Stack;

public class PostfixToPrefix {

    private static void PostfixToPrefix(String str){

        Stack<String> stack = new Stack<>();

        for (int i = 0; i <str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'){
                String  first = stack.pop();
                String  second = stack.pop();
                String  concatenate = (ch + second + first);
                stack.push(concatenate);
            }else{
                String s = new String(String.valueOf(ch));
                stack.push(s);
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        String str1 = "AB+CD-*";
        String str2 = "ABC/-AK/L-*";
        PostfixToPrefix(str1);  // *+AB-CD
        PostfixToPrefix(str2); //  *-A/BC-/AKL
    }
}
