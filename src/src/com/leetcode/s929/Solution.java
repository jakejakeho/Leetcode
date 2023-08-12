package src.com.leetcode.s929;

import java.util.HashSet;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmailSet = new HashSet<>();
        for (String email : emails) {
            String cleanEmail = cleanEmail(email);
            uniqueEmailSet.add(cleanEmail);
        }
        return uniqueEmailSet.size();
    }

    private String cleanEmail(String email) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = email.toCharArray();
        boolean arrivedAt = false;
        boolean ignoreAfterPlus = false;
        for (char c : chars) {
            if (c == '+') {
                ignoreAfterPlus = true;
                continue;
            }
            if (c == '@') {
                ignoreAfterPlus = false;
                arrivedAt = true;
            }
            if ((c != '.' && !ignoreAfterPlus) || arrivedAt) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}