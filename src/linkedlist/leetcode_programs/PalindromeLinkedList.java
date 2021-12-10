package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode temp1 = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();
        while(temp1!=null){
            stack.push(temp1.val);
            temp1 = temp1.next;
        }
        while(head!=null){
            int i = stack.pop();
            if(i==head.val){
                isPalindrome = true;
            }else{
                isPalindrome = false;
                break;
            }
            head = head.next;
        }

        return isPalindrome;
    }
}
