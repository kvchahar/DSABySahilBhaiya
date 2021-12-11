package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode runner = head;
        ListNode follower = head;
        int i = 1;
        while(i<k){
            runner = runner.next;
            i++;
        }
        ListNode tempNode = runner;

        while(runner.next!=null){
            runner = runner.next;
            follower = follower.next;
        }

        int temp = tempNode.val;
        tempNode.val = follower.val;
        follower.val = temp;
        return head;
    }
}
