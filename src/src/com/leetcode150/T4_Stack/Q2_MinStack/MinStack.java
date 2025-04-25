package src.com.leetcode150.T4_Stack.Q2_MinStack;
import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <=minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int popVal = stack.pop();
        if (!minStack.isEmpty() && minStack.peek() == popVal) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

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

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack(); obj.push(val);
 * obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */