package src.com.leetcode.s225;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        Queue<Integer> queue1 = new LinkedList<>();
        int popVal = 0;
        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                popVal = queue.poll();
                break;
            } else {
                queue1.offer(queue.poll());
            }
        }
        queue = queue1;
        return popVal;
    }

    public int top() {
        int top = 0;
        Queue<Integer> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                top = queue.peek();
            }
            temp.offer(queue.poll());
        }
        queue = temp;
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}