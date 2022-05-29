package src.com.lintcode.l659;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        String result = "";
        for (String s : strs) {
            result += s + "30624700";
        }
        return result;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        return Arrays.stream(str.split("30624700")).collect(Collectors.toList());
    }
}