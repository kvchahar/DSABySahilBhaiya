package stacks.implementation;

public class StackImplUsingArray {
    //Using Array
        int arr[];
        int top; //maintain top element
        int capacity;

        public StackImplUsingArray(int capacity) {
            this.capacity = capacity;
            top = -1; // -1 means no element is present at first
            arr = new int[capacity];
        }

        void push(int data) {

            //check if stack is full or not
            if(top == capacity-1) {
                System.out.println("Stack is full");
            }
            //increase the top size and add the element in the array
            top++;
            arr[top] = data;
        }

        int pop() {

            //if stack is empty
            if(top == -1) {
                System.out.println("Stack is Empty");
            }
            int res = arr[top];
            top--;
            return res;
        }
        //return the top element
        int peek() {

            if(top == -1) {
                System.out.println("Stack is Empty");
            }
            return arr[top];
        }

        //to check if stack is empty
        boolean isEmpty() {
            return top == -1;
        }
}
