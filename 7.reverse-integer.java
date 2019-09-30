/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.48%)
 * Likes:    2469
 * Dislikes: 3821
 * Total Accepted:    811.7K
 * Total Submissions: 3.2M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        int abs_x = x > 0? x: -x;
        int ans = 0;
        int old = ans;

        while (abs_x > 0) {
            old = ans;
            ans = 10*ans + abs_x%10;
            if (ans < 0 || old != ans/10) {
                return 0;
            }
            abs_x /= 10;
        }

        if (x < 0) {
            return -ans;
        }
        else {
            return ans;
        }
    }
}

