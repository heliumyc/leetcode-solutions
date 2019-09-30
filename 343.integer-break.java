/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (48.44%)
 * Likes:    662
 * Dislikes: 184
 * Total Accepted:    87.1K
 * Total Submissions: 179.5K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */
// f[i] = max{(n-j)*f[j]}
class Solution {
    public int pow3(int n) {
        int ans = 1;
        while (n > 0) {
            n--;
            ans *= 3;
        }
        return ans;
    }
    public int integerBreak(int n) {
        switch (n) {
            case 0: return 0;
            case 1: return 1;
            case 2: return 1;
            case 3: return 2;
            default: break;
        }

        int m = n/3;
        if (n%3 == 0) {
            return pow3(m); 
        } else if (n%3 == 1) {
            return 4*pow3(m-1);
        } else {
            return 2*pow3(m);
        }
        // // n > 4
        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     int max = -1;
        //     for (int j = 0; j < i; j++) {
        //         max = Math.max(max, dp[j]*(i-j));
        //     }
        //     dp[i] = max;
        // }
        // return dp[n];
        
    }
}

