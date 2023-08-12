package src.com.leetcode.s295;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    public MedianFinder() {
    }

    public void addNum(int num) {
        double median1 = findMedian();
        if (num > median1) {
            rightMinHeap.add(num);
        } else {
            leftMaxHeap.add(num);
        }

        if (leftMaxHeap.size() - rightMinHeap.size() >= 2) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size() - leftMaxHeap.size() >= 2){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            int leftMax = leftMaxHeap.size() > 0 ? leftMaxHeap.peek() : 0;
            int rightMin = rightMinHeap.size() > 0 ? rightMinHeap.peek() : 0;
            return (leftMax + rightMin) / 2.0;
        } else {
            int medianIndex = ((leftMaxHeap.size() +rightMinHeap.size()) / 2) + 1;
            if (leftMaxHeap.size() == medianIndex) {
                return leftMaxHeap.peek();
            } else {
                return rightMinHeap.peek();
            }
        }
    }
}
