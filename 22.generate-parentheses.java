import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (56.78%)
 * Likes:    3456
 * Dislikes: 206
 * Total Accepted:    408.4K
 * Total Submissions: 708.9K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {
    // recursive

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        CombinationsParenthesis(result, "", 0, 0, n);
        return result;
    }

    private void CombinationsParenthesis(List<String> result, String prefix, int leftNum, int rightNum, int n) {
        // base condition
        if (prefix.length() == n*2) {
            result.add(prefix);
            return;
        }
        if (leftNum < n) {
            CombinationsParenthesis(result, prefix+"(", leftNum+1, rightNum, n);
        }
        if (rightNum < leftNum) {
            CombinationsParenthesis(result, prefix+")", leftNum, rightNum+1, n);
        }
    }
}
// @lc code=end

