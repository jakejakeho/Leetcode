package src.com.leetcode.s853;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static class Car {
        public int position;
        public int speed;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            Car car = new Car();
            car.position = position[i];
            car.speed = speed[i];
            cars.add(car);
        }

        cars = cars.stream().sorted(Comparator.comparingInt(c -> c.position)).collect(Collectors.toList());

        for (int i = cars.size() - 1; i >= 0; i--) {
            Car currentCar = cars.get(i);
            double iteration = (0.0 + target - currentCar.position) / currentCar.speed;
            if (!stack.isEmpty() && iteration <= stack.peek()) {
                continue;
            } else {
                stack.push(iteration);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 12;
        int[] position = new int[]{10, 8, 0, 5, 3};
        int[] speed = new int[]{2, 4, 1, 1, 3};
        System.out.println(solution.carFleet(target, position, speed));
    }
}
