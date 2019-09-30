import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.80%)
 * Likes:    6401
 * Dislikes: 369
 * Total Accepted:    1.1M
 * Total Submissions: 3.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        map.put(s.charAt(0), 0);
        int maxLen = 1;
        int curLen = 1;

        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int end = map.get(s.charAt(i));
                while (start <= end) {
                    map.remove(s.charAt(start));
                    start++;
                }
                map.put(s.charAt(i), i);
                curLen = i-start+1;
            } else {
                curLen += 1;
                map.put(s.charAt(i), i);
            }
            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}

