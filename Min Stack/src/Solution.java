import java.util.Stack;

public class Solution {

    // Problem statement: https://leetcode.com/problems/min-stack/

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // O(1) time | O(1) space
    public void push(int val) {
        stack.push(val);

        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // O(1) time | O(1) space
    public void pop() {
        if (!stack.empty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    // O(1) time | O(1) space
    public int top() {
        return stack.peek();
    }

    // O(1) time | O(1) space
    public int getMin() {
        return minStack.peek();
    }
}
