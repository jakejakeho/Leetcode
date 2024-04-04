package src.com.leetcode.s225;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        Queue<Integer> tmp = new LinkedList<>();
        while (queue.size() > 1)
            tmp.offer(queue.poll());
        int popVal = queue.poll();
        queue = tmp;
        return popVal;
    }

    public int top() {
        Queue<Integer> tmp = new LinkedList<>();
        int top = 0;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                top = queue.poll();
                tmp.offer(top);
            } else
                tmp.offer(queue.poll());
        }
        queue = tmp;
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}