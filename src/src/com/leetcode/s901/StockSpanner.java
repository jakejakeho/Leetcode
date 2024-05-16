package src.com.leetcode.s901;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {

    Stack<Integer> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        stack.add(price);
        int span = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if (list.get(i) <= price) {
                span++;
            } else {
                break;
            }
        }
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
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */