package src.com.leetcode.s399;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.calcEquation(List.of(List.of("a", "b"), List.of("b", "c")), new double[]{2.0, 3.0}, List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")))));
        System.out.println(Arrays.toString(solution.calcEquation(List.of(List.of("BTC", "USDT"), List.of("ETH", "USDT")), new double[]{25000, 1600}, List.of(List.of("BTC", "ETH"), List.of("ETH", "BTC"), List.of("USDT", "BTC"), List.of("USDT", "ETH")))));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> hashMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0);
            String second = equation.get(equation.size() - 1);
            hashMap.computeIfAbsent(first, (k) -> new HashMap<>());
            hashMap.get(first).put(second, values[i]);

            // inverse value
            hashMap.computeIfAbsent(second, (k) -> new HashMap<>());
            hashMap.get(second).put(first, 1 / values[i]);
        }

        double[] queryResult = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            HashSet<String> visited = new HashSet<>();
            Double price = getPrice(hashMap, query.get(0), query.get(query.size() - 1), 1.0, visited);
            queryResult[i] = price == null ? -1 : price;
        }
        return queryResult;
    }

    public Double getPrice(HashMap<String, HashMap<String, Double>> hashMap, String first, String target, double currentPrice, HashSet<String> visited) {
        if (visited.contains(first)) return null;
        visited.add(first);
        HashMap<String, Double> quotes = hashMap.getOrDefault(first, new HashMap<>());
        for (Map.Entry<String, Double> quote : quotes.entrySet()) {
            if (Objects.equals(quote.getKey(), target)) {
                return currentPrice * quote.getValue();
            } else {
                Double price = getPrice(hashMap, quote.getKey(), target, currentPrice * quote.getValue(), visited);
                if (price != null) {
                    return price;
                }
            }
        }
        return null;
    }
}