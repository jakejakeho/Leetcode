package src.com.leetcode.s3233;

import java.util.*;

class Solution {

    private List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                primes.add(i);
        }
        return primes;
    }

    public int nonSpecialCount(int l, int r) {
        int maxPrime = (int) Math.sqrt(r);
        List<Integer> primes = sieveOfEratosthenes(maxPrime);

        int count = r - l + 1;
        for (int prime : primes) {
            int square = prime * prime;
            if (square >= l && square <= r) {
                count--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nonSpecialCount(5, 7));
        System.out.println(solution.nonSpecialCount(4, 16));
//        System.out.println(solution.nonSpecialCount(1, 2));
//        System.out.println(solution.nonSpecialCount(3693, 85366));
    }
}