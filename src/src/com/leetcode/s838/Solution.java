package src.com.leetcode.s838;
import java.util.Objects;

class Solution {

    public String pushDominoes(String dominoes) {
        String lastAfterPush = dominoes;
        String currentAfterPush;
        while (true) {
            currentAfterPush = afterPush(lastAfterPush);
            if (Objects.equals(currentAfterPush, lastAfterPush)) {
                break;
            }
            lastAfterPush = currentAfterPush;
        }
        return currentAfterPush;
    }

    public String afterPush(String dominoes) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] dominoesArr = dominoes.toCharArray();
        for (int i = 0; i < dominoesArr.length; i++) {
            if (i <= dominoesArr.length - 3 && dominoesArr[i] == 'R' && dominoesArr[i + 1] == '.'
                && dominoesArr[i + 2] == 'L') {
                stringBuilder.append(dominoesArr[i]);
                stringBuilder.append(dominoesArr[i + 1]);
                stringBuilder.append(dominoesArr[i + 2]);
                i += 2;
            } else if (i >= 1 && dominoesArr[i] == 'L' && dominoesArr[i - 1] == '.') {
                stringBuilder.setCharAt(stringBuilder.length() - 1, 'L');
                stringBuilder.append('L');
            } else if (i <= dominoesArr.length - 2 && dominoesArr[i] == 'R' && dominoesArr[i + 1] == '.') {
                stringBuilder.append('R');
                stringBuilder.append('R');
                i++;
            } else {
                stringBuilder.append(dominoesArr[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }
}