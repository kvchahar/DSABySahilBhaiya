package linkedlist.myprograms;

import linkedlist.leetcode_programs.node.Node;

public class OddEven {
    void rearrangeEvenOdd(Node head) {
        Node oddDummyNode = new Node(-101);
        Node evenDummyNode = new Node(-101);
        Node current1 = oddDummyNode;
        Node current2 = evenDummyNode;
        Node current = head;
        while (current != null) {
            if (current.val % 2 != 0) {
                Node newNode = new Node(current.val);
                current1.next = newNode;
                current1 = current1.next;
                current = current.next;
            } else {
                Node newNode = new Node(current.val);
                current2.next = newNode;
                current2 = current2.next;
                current = current.next;
            }
        }
        current1.next = evenDummyNode.next;
    }
}
