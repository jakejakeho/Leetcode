package src.com.leetcode.s2092;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Solution {

    private static class Person {
        int value;

        Map<Integer, Person> neighbours = new HashMap<>();

        public Person(int value) {
            this.value = value;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        boolean[] hasSecrets = new boolean[n];
        hasSecrets[0] = true;
        hasSecrets[firstPerson] = true;

        // {time: [meeting]}
        int maxTime = 0;
        Map<Integer, List<int[]>> groupMeetingsByTime = new HashMap<>();
        for (int[] meeting : meetings) {
            int time = meeting[2];
            maxTime = Math.max(time, maxTime);
            groupMeetingsByTime.putIfAbsent(time, new ArrayList<>());
            groupMeetingsByTime.get(time).add(new int[]{meeting[0], meeting[1]});
        }

        for (int T = 0; T <= maxTime; T++) {
            List<int[]> meetingsInTimeT = groupMeetingsByTime.get(T);
            if (meetingsInTimeT == null) {
                continue;
            }
            Map<Integer, Person> peopleMap = new HashMap<>();
            for (int[] meeting : meetingsInTimeT) {
                int person1 = meeting[0];
                int person2 = meeting[1];
                peopleMap.computeIfAbsent(person1, (k) -> new Person(person1));
                peopleMap.computeIfAbsent(person2, (k) -> new Person(person2));
                peopleMap.get(person1).neighbours.put(person2, peopleMap.get(person2));
                peopleMap.get(person2).neighbours.put(person1, peopleMap.get(person1));
            }

            List<Person> people = peopleMap.values().stream().toList();
            for (Person person : people) {
                if (person != null && hasSecrets[person.value]) {
                    shareSecret(peopleMap, person.value, hasSecrets);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hasSecrets[i])
                result.add(i);
        }
        return result;
    }

    private void shareSecret(Map<Integer, Person> peopleMap, int initial, boolean[] hasSecrets) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(initial);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int currentVisit = queue.poll();
            visited.add(currentVisit);
            hasSecrets[currentVisit] = true;
            for (Person neighbour : peopleMap.get(currentVisit).neighbours.values()) {
                if (!hasSecrets[neighbour.value] && !visited.contains(neighbour.value)) {
                    queue.add(neighbour.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = read2DIntArrayFromFile("C:\\Users\\Jake\\IdeaProjects\\Leetcode\\src\\src\\com\\leetcode\\s2092\\data.txt");
        System.out.println(solution.findAllPeople(100000, array, 1));
    }

    public static int[][] read2DIntArrayFromFile(String filename) {
        int[][] result = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine().trim(); // Read the first line and trim whitespace
            line = line.substring(2, line.length() - 2); // Remove outer {{ }}
            String[] rows = line.split("\\},\\{");
            result = new int[rows.length][];
            for (int i = 0; i < rows.length; i++) {
                String[] cols = rows[i].split(",");
                result[i] = new int[cols.length];
                for (int j = 0; j < cols.length; j++) {
                    result[i][j] = Integer.parseInt(cols[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}