/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.84%)
 * Likes:    4366
 * Dislikes: 400
 * Total Accepted:    660.1K
 * Total Submissions: 2.4M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    private char charAtAugmentedStr(String s, int index) {
        if (index%2 == 0) {
            return '#';
        }
        else {
            return s.charAt(index/2);
        }
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s.substring(0, 1);
        int maxLen = -1;
        int maxCenter = -1;
        int[] dp = new int[s.length()*2+1];
        int boundry = 0;
        int center = 0;
        for (int i = 0; i < dp.length; i++) {
            if (boundry > i) {
                dp[i] = Math.min(dp[2*center-i], boundry-i);
            }
            else {
                dp[i] = 1;
            }

            while (i-dp[i] >= 0 && i+dp[i] <= dp.length-1 && charAtAugmentedStr(s, i+dp[i]) == charAtAugmentedStr(s, i-dp[i])) {
                dp[i]++;
            }

            if (i+dp[i] > boundry) {
                center = i;
                boundry = i+dp[i]-1;
            }

            if (dp[i] > maxLen) {
                maxCenter = i;
                maxLen = dp[i];
            }
        }
        return s.substring((maxCenter-maxLen+1)/2, (maxCenter+maxLen-1)/2);
    }
}

