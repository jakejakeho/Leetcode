package src.com.leetcode.s68;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            solution.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        int count = 0;
        for (String word : words) {
            int nextWordCount = word.length();
            if (count != 0) {
                nextWordCount++;
            }

            if (count + nextWordCount <= maxWidth) {
                tempList.add(word);
                count = count + nextWordCount;
            } else {
                list.add(construct(tempList, maxWidth, false));
                count = word.length();
                tempList = new ArrayList<>();
                tempList.add(word);
            }
        }
        list.add(construct(tempList, maxWidth, true));
        return list;
    }

    private String construct(List<String> tempList, int maxWidth, boolean lastLine) {
        if (!lastLine) {
            int numOfSpace = Math.max(1, tempList.size() - 1);
            int wordCount = 0;
            for (String word : tempList) {
                wordCount += word.length();
            }

            int spacesRequired = maxWidth - wordCount;
            int[] spaces = new int[numOfSpace];
            int spaceIndex = 0;
            while (spacesRequired > 0) {
                spaces[spaceIndex]++;
                spaceIndex = (spaceIndex + 1) % numOfSpace;
                spacesRequired--;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < tempList.size(); i++) {
                stringBuilder.append(tempList.get(i));
                if (i < spaces.length) {
                    stringBuilder.append(" ".repeat(Math.max(0, spaces[i])));
                }
            }
            return stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < tempList.size(); i++) {
                stringBuilder.append(tempList.get(i));
                if (i < tempList.size() - 1) {stringBuilder.append(" ");}
            }
            stringBuilder.append(" ".repeat(Math.max(0, maxWidth - stringBuilder.length())));
            return stringBuilder.toString();
        }
    }
}