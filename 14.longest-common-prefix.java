/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (34.08%)
 * Likes:    1672
 * Dislikes: 1507
 * Total Accepted:    563.6K
 * Total Submissions: 1.6M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char curChar = strs[0].charAt(i);
            boolean allMatch = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != curChar) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                sb.append(curChar);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

