package stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }
    public static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertSorted(stack, value);
        stack.push(top);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        sortStack(stack);
        System.out.println(stack);
        sc.close();
    }
}