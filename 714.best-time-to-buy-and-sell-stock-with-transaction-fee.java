/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * algorithms
 * Medium (51.38%)
 * Likes:    1034
 * Dislikes: 33
 * Total Accepted:    46.4K
 * Total Submissions: 90K
 * Testcase Example:  '[1,3,2,8,4,9]\n2'
 *
 * Your are given an array of integers prices, for which the i-th element is
 * the price of a given stock on day i; and a non-negative integer fee
 * representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the
 * transaction fee for each transaction.  You may not buy more than 1 share of
 * a stock at a time (ie. you must sell the stock share before you buy again.)
 * Return the maximum profit you can make.
 * 
 * Example 1:
 * 
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1Selling at prices[3] = 8Buying at prices[4] =
 * 4Selling at prices[5] = 9The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) =
 * 8.
 * 
 * 
 * 
 * Note:
 * 0 < prices.length .
 * 0 < prices[i] < 50000.
 * 0 .
 * 
 */

// dp_i = max {
//     dp_i-1, do not sell at i
//     max{ dp_j - a_j} + a_i - 2, sell at i
// }
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cachedMax = 0;
        int[] dp = new int[prices.length];

        dp[0] = 0;
        cachedMax = dp[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profitIfSell = cachedMax + prices[i] - fee;
            dp[i] = Math.max(dp[i-1], profitIfSell);
            cachedMax = Math.max(cachedMax, dp[i]-prices[i]);
        }

        return dp[prices.length-1];
    }
}

