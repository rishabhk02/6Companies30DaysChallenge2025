import java.util.*;

class Solution {

    long mod = (long) (1e9 + 7);

    public int numberOfGoodSubsets(int[] nums) {
        /*
        2 3 5 7
        11 13 17 19
        23 29
        */
        int n = nums.length;

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        // get the frequency of each element from 1 ..... 30
        // dp[k][j] -> using the numbers from 1 .... k, how many subsets multiply to j
        // if k = 1, then if j=1, it is the frequency of 1
        // otherwise dp[k][j] = dp[k-1][j] 
        // is k a divisor of j?
        // if so then dp[k][j] += f(k) * dp[k-1][j-k]

        long[] freq = new long[31];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        long[][] dp = new long[31][(1<<10)];
        
        long power = 1;
        for (int i = 0; i < freq[1]; i++) {
            power = power + power; power %= mod;
        }

        for (int i = 1; i <= 30; i++) {
            dp[i][0] = power; 
        }

        for (int i = 1; i <= 30; i++) {
            int[] powers = new int[10];

            int originalValue = i;
            for (int j = 0; j < 10; j++) {
                while (originalValue % primes[j] == 0) {
                    originalValue /= primes[j];
                    powers[j]++;
                }
            }

            boolean canUse = true;
            for (int j = 0; j < 10; j++) {
                if (powers[j] > 1) {
                    canUse = false;
                }
            }


            if (i == 1) continue;

            for (int j = 1; j < (1<<10); j++) {
                dp[i][j] = dp[i-1][j];
            }

            if (!canUse) continue;
            for (int j = 1; j < (1<<10); j++) {
                boolean allBits = true;
                int subtract = j;

                for (int k = 0; k < 10; k++){
                    if (powers[k] == 1) {
                        if ((j >> k) % 2 != 1) {
                            allBits = false;
                        } else {
                            subtract -= (1<<k);
                        }
                    }
                }

                

                if (allBits) {
                    dp[i][j] += freq[i] * dp[i-1][subtract];
                    dp[i][j] %= mod;
                    // System.out.printf("dp(%d, %d) = %d\n",i, j, dp[i][j]);
                }
            }
        }

        /*for (int i = 1; i <= 30; i++) {
            for (int j = 0; j < (1<<10); j++) {
                if (dp[i][j] != 0) {
                    System.out.printf("dp(%d, %d) = %d\n", i, j, dp[i][j]);
                }
            }
        }*/

        long answer = 0;
        for (int j = 1; j <(1<<10); j++) {
            answer += dp[30][j];
            answer %= mod;
        }
        return (int) answer;
    }
}