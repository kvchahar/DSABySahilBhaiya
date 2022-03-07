package stacks;

import java.util.Stack;

public class PrefixToPostfix {

    private static void prefixToPostfix(String str){

        Stack<String> stack = new Stack<>();

        for (int i = str.length()-1; i >=0 ; i--) {
            char ch = str.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'){
                String  first = stack.pop();
                String  second = stack.pop();
                String  concatenate = (first + second + ch);
                stack.push(concatenate);
            }else{
                String s = new String(String.valueOf(ch));
                stack.push(s);
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        String str1 = "*+AB-CD";
        String str2 = "*-A/BC-/AKL";
        prefixToPostfix(str1);  // AB+CD-*
        prefixToPostfix(str2); // ABC/-AK/L-*
    }
}
