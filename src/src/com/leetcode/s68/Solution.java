package src.com.leetcode.s68;

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<List<String>> lines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        lines.add(currentLine);
        int charCount = 0;
        for (int i = 0; i < words.length; i++) {
            int lineNeeded = charCount + words[i].length() + (!currentLine.isEmpty() ? currentLine.size() : 0);
            if (lineNeeded <= maxWidth) {
                currentLine.add(words[i]);
                charCount += words[i].length();
            } else {
                charCount = words[i].length();
                currentLine = new ArrayList<>();
                lines.add(currentLine);
                currentLine.add(words[i]);
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            if (i != lines.size() - 1) {
                int charLnegth = 0;
                System.out.println(line);
                for (String s : line) {
                    charLnegth += s.length();
                }
                int spaceNeeded = maxWidth - charLnegth;
                int ceilSpace;
                int remainder;
                if ((line.size() - 1) == 0) {
                    ceilSpace = spaceNeeded;
                    remainder = 0;
                } else {
                    ceilSpace = (int)Math.ceil((double)spaceNeeded / (line.size() - 1));
                    remainder = spaceNeeded % (line.size() - 1);
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < line.size(); j++) {
                    String s = line.get(j);
                    sb.append(s);
                    if (line.size() == 1 || j != line.size() - 1) {
                        if (spaceNeeded >= ceilSpace && (remainder == 0 || j < remainder)) {
                            sb.append(" ".repeat(ceilSpace));
                            spaceNeeded -= ceilSpace;
                        } else {
                            sb.append(" ".repeat(ceilSpace - 1));
                            spaceNeeded -= ceilSpace - 1;
                        }
                    }
                }
                result.add(sb.toString());
            } else {
                int spaceRemain = maxWidth;
                StringBuilder sb = new StringBuilder();
                for (String s : line) {
                    sb.append(s);
                    spaceRemain -= s.length();
                    if (sb.length() + 1 < maxWidth) {
                        sb.append(" ");
                        spaceRemain -= 1;
                    }
                }
                sb.append(" ".repeat(spaceRemain));
                result.add(sb.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(solution.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(solution.fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}, 16));
    }
}
