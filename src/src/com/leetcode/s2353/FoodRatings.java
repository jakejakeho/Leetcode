package src.com.leetcode.s2353;

import java.util.*;

class FoodRatings {

    private static class Pair<L, R> {
        L left;
        R right;

        public Pair(L l, R r) {
            this.left = l;
            this.right = r;
        }

        public R getRight() {
            return this.right;
        }
    }

    Map<String, Integer> foodRatingMap = new HashMap<>();
    Map<String, String> foodCuisineMap = new HashMap<>();
    Map<String, TreeSet<Pair<String, Integer>>> cuisineFoodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            foodRatingMap.put(food, rating);
            foodCuisineMap.put(food, cuisine);
            cuisineFoodMap.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                int compareByRating = Integer.compare(b.right, a.right);
                if (compareByRating == 0) {
                    return a.left.compareTo(b.left);
                }
                return compareByRating;
            }));
            cuisineFoodMap.get(cuisine).add(new Pair<>(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        cuisineFoodMap.get(foodCuisineMap.get(food)).remove(new Pair<>(food, foodRatingMap.get(food)));
        foodRatingMap.put(food, newRating);
        cuisineFoodMap.get(foodCuisineMap.get(food)).add(new Pair<>(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).first().left;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 * <p>
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */