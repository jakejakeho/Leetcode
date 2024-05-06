package src.com.leetcode.s838;
import java.util.Objects;

class Solution {

    public String pushDominoes(String dominoes) {
        char[] dominoesArr = dominoes.toCharArray();
        for (int i = 0; i < dominoesArr.length; i++) {
            if (dominoesArr[i] == 'L') {
                int leftIndex = i - 1;
                while (leftIndex >= 0 && dominoesArr[leftIndex] == '.' && (leftIndex - 1 < 0
                    || dominoesArr[leftIndex - 1] != 'R')) {
                    dominoesArr[leftIndex] = 'L';
                    leftIndex--;
                }
            } else if (dominoesArr[i] == 'R') {
                int nextSpecialIndex = i + 1;
                while (nextSpecialIndex < dominoesArr.length && dominoesArr[nextSpecialIndex] == '.') {
                    nextSpecialIndex++;
                }
                if (nextSpecialIndex < dominoesArr.length && dominoesArr[nextSpecialIndex] == 'L') {
                    int spaceBetween = (nextSpecialIndex - i - 1);
                    int numOfMoved = Math.floorDiv(spaceBetween, 2);
                    int rightMoved = 0;
                    while (rightMoved < numOfMoved) {
                        dominoesArr[i + rightMoved + 1] = 'R';
                        rightMoved++;
                    }

                    int leftMoved = 0;
                    while (leftMoved < numOfMoved) {
                        dominoesArr[nextSpecialIndex - leftMoved - 1] = 'L';
                        leftMoved++;
                    }

                } else {
                    int rightIndex = i + 1;
                    while (rightIndex < nextSpecialIndex) {
                        dominoesArr[rightIndex] = 'R';
                        rightIndex++;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < dominoesArr.length; i++) {
            stringBuilder.append(dominoesArr[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pushDominoes(".L.R."));
        //System.out.println(solution.pushDominoes(".L.R...LR..L.."));
    }
}