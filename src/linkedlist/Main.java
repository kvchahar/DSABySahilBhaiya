package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.createNodes();
        list.display();
        System.out.println();
        System.out.println("After Insertion at front");
        list.addNodeAtFront(22);
        list.display();
        list.deleteAtFront();
        System.out.println();
        list.display();
    }
}
