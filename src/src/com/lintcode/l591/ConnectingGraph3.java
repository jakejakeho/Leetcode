package src.com.lintcode.l591;
import java.util.HashSet;
import java.util.Set;

public class ConnectingGraph3 {

    public static void main(String[] args) {
        //ConnectingGraph3 connectingGraph3 = new ConnectingGraph3(5);
        //System.out.println(connectingGraph3.query());
        //connectingGraph3.connect(1, 2);
        //System.out.println(connectingGraph3.query());
        //connectingGraph3.connect(2, 4);
        //System.out.println(connectingGraph3.query());
        //connectingGraph3.connect(1, 4);
        //System.out.println(connectingGraph3.query());

        int[] expected = new int[] {9, 9, 9, 7, 5, 4, 4, 4, 4, 4, 4, 4};
        int count = 0;
        ConnectingGraph3 connectingGraph3 = new ConnectingGraph3(12);
        connectingGraph3.connect(3, 9);
        connectingGraph3.connect(10, 9);
        connectingGraph3.connect(5, 7);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        connectingGraph3.connect(3, 2);
        connectingGraph3.connect(10, 11);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        connectingGraph3.connect(12, 8);
        connectingGraph3.connect(10, 3);
        connectingGraph3.connect(10, 12);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        connectingGraph3.connect(10, 5);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        connectingGraph3.connect(10, 8);
        connectingGraph3.connect(12, 2);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        System.out.println(connectingGraph3.query() + " expected = " + expected[count++]);
        connectingGraph3.connect(7, 6);
    }

    int n;

    HashSet<Integer>[] sets;

    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        this.n = n;
        sets = new HashSet[n + 1];
    }

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        HashSet<HashSet<Integer>> uniqueGroups = new HashSet<>();
        if (sets[a] != null) {
            HashSet<Integer> groupA = sets[a];
            for (Integer val : groupA) {
                uniqueGroups.add(sets[val]);
            }
        }
        if (sets[b] != null) {
            HashSet<Integer> groupB = sets[b];
            for (Integer val : groupB) {
                uniqueGroups.add(sets[val]);
            }
        }
        HashSet<Integer> group = new HashSet<>();
        for (HashSet<Integer> uniqueGroup : uniqueGroups) {
            group.addAll(uniqueGroup);
        }
        group.add(a);
        group.add(b);
        for (int groupVal : group) {
            sets[groupVal] = group;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        Set<Set<Integer>> uniqueGroups = new HashSet<>();
        for (Set<Integer> group : sets) {
            if (group != null) {uniqueGroups.add(group);}
        }

        int total = n;
        for (Set<Integer> unqiueGroup : uniqueGroups) {
            total -= (unqiueGroup.size() - 1);
        }
        return total;
    }
}