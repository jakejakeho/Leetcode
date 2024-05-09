package src.com.leetcode.s1396;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {

    Map<Integer, Trip> tripDatabase = new HashMap<>();
    Map<String, Map<String, List<Integer>>> graph = new HashMap<>();

    private static class Trip {
        String startStation;
        int startTime;
    }

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Trip trip = new Trip();
        trip.startStation = stationName;
        trip.startTime = t;
        tripDatabase.put(id, trip);
    }

    public void checkOut(int id, String stationName, int t) {
        Trip trip = tripDatabase.get(id);
        graph.putIfAbsent(trip.startStation, new HashMap<>());
        graph.get(trip.startStation)
             .putIfAbsent(stationName, new ArrayList<>());
        graph.get(trip.startStation)
             .get(stationName)
             .add(t - trip.startTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> tripTimes = graph.get(startStation).get(endStation);
        double sum = 0;
        for (int tripTime : tripTimes) {
            sum += tripTime;
        }
        return sum / tripTimes.size();
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three
        // trips "Leyton" ->
        // "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */