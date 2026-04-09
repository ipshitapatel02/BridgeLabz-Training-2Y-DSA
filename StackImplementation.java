package stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class StackImplementation {
    static class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }
        public void enqueue(int x) {
            inStack.push(x);
            System.out.println(x + " enqueued");
        }
        public int dequeue() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            if (outStack.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return outStack.pop();
        }
        public int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            if (outStack.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return outStack.peek();
        }
        public boolean isEmpty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();
        while (true) {
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Peek");
            System.out.println("4.Check if Empty");
            System.out.println("5.Exit");
            System.out.print(" ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    int val = sc.nextInt();
                    q.enqueue(val);
                    break;
                case 2:
                    int removed = q.dequeue();
                    if (removed != -1)
                        System.out.println(removed);
                    break;
                case 3:
                    int front = q.peek();
                    if (front != -1)
                        System.out.println(front);
                    break;
                case 4:
                    System.out.println(q.isEmpty());
                    break;
                case 5:
                    System.out.println("Finished");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}