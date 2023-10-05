package src.com.leetcode.s2013;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class DetectSquares {

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isDiagonal(Coordinate point) {
            return Math.abs(point.y - this.y) == Math.abs(point.x - this.x) && point.y != this.y && point.x != this.x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Coordinate that = (Coordinate)o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        System.out.println(detectSquares.count(new int[] {11, 10})); // return 1. You can choose:
        //   - The first, second, and third points
        detectSquares.count(new int[] {14, 8});  // return 0. The query point cannot form a square with any points in
        // the
        // data structure.
        detectSquares.add(new int[] {11, 2});    // Adding duplicate points is allowed.
        System.out.println(detectSquares.count(new int[] {11, 10})); // return 2. You can choose:
        //   - The first, second, and third points
        //   - The first, third, and fourth points
    }

    public List<Coordinate> coordinates = new ArrayList<>();
    public Map<Coordinate,Integer> coordinateCountMap = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        Coordinate coordinate = new Coordinate(point[0], point[1]);
        coordinates.add(coordinate);
        coordinateCountMap.put(coordinate,  coordinateCountMap.getOrDefault(coordinate, 0) + 1);
    }

    public int count(int[] point) {
        Coordinate testCoordinate = new Coordinate(point[0], point[1]);
        int count = 0;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.isDiagonal(testCoordinate)) {
                count += coordinateCountMap.getOrDefault(new Coordinate(testCoordinate.x, coordinate.y), 0) *
                    coordinateCountMap.getOrDefault(new Coordinate(coordinate.x, testCoordinate.y), 0);
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such: DetectSquares obj = new DetectSquares();
 * obj.add(point); int param_2 = obj.count(point);
 */