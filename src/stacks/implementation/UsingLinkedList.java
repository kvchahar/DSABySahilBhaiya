package stacks.implementation;

class Node{
    Node next;
    int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }
}
public class UsingLinkedList {
    Node head;
    int size;

    public UsingLinkedList() {
        head = null;
        size = 0;
    }

    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    int peek() {
        if(head == null) {
            System.out.println("Empty stack");
        }
        // return head data
        return head.data;
    }

    int pop() {
        if(head == null) {
            System.out.println("Empty stack");
        }
        //store the head data in temp and move the head to next pointer and decrease the size
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    boolean isEmpty() {
        return head == null;
    }

    int getSize() {
        return size;
    }

}
