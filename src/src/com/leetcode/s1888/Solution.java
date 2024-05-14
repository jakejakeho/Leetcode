package src.com.leetcode.s1888;

class Solution {
    public int minFlips(String s) {
        char[] arr = s.toCharArray();
        boolean[] bArr = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bArr[i] = arr[i] == '1';
        }
        for (int i = 0; i < arr.length; i++) {
            int flip1 = 0;
            int flip0 = 0;
            for (int j = 0; j < arr.length; j++) {
                boolean isOdd = j % 2 == 1;
                boolean current = bArr[(i + j) % arr.length];
                if (isOdd && current || ) {
                    count1++;
                } else {
                    count0++;
                }
            }

        }
    }
}