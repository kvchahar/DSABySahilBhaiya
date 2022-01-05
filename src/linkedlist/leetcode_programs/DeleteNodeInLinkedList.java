package linkedlist.leetcode_programs;

import linkedlist.leetcode_programs.node.ListNode;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next =  node.next.next;
        return;
    }
}
