package src.com.lintcode.l659;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strs = List.of("lint","code","love","you");
        Solution solution = new Solution();
        System.out.println("Output: " + solution.decode(solution.encode(strs)));
    }
}
