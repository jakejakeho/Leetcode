package src.com.leetcode.s901;

import java.util.Stack;

class StockSpanner {

    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        stack.push(new int[] {price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such: StockSpanner obj = new StockSpanner(); int param_1
 * = obj.next(price);
 */