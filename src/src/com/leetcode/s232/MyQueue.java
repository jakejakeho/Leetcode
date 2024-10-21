package src.com.leetcode.s232;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MyQueue {

    Stack<Integer> stack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        Stack<Integer> newStack = new Stack<>();
        newStack.push(x);
        List<Integer> temp = new ArrayList<>();
        while (!stack.empty()) {
            temp.add(stack.pop());
        }
        for (int i = temp.size() - 1; i >= 0 ; i--) {
            newStack.push(temp.get(i));
        }
        stack = newStack;
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println("peek = " + myQueue.peek());
        System.out.println("pop = " + myQueue.pop());
        System.out.println("empty = " + myQueue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue(); obj.push(x); int param_2 =
 * obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */