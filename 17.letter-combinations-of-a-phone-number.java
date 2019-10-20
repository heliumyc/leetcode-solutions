import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (42.83%)
 * Likes:    2690
 * Dislikes: 341
 * Total Accepted:    462.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        HashMap<Integer, List<Character>> teleCharMap = new HashMap<>();
        teleCharMap.put(2, Arrays.asList('a', 'b', 'c'));
        teleCharMap.put(3, Arrays.asList('d', 'e', 'f'));
        teleCharMap.put(4, Arrays.asList('g', 'h', 'i'));
        teleCharMap.put(5, Arrays.asList('j', 'k', 'l'));
        teleCharMap.put(6, Arrays.asList('m', 'n', 'o'));
        teleCharMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        teleCharMap.put(8, Arrays.asList('t', 'u', 'v'));
        teleCharMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        res.add("");
        List<String> buffer = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            if (num < 2 || num > 9) return null;
            List<Character> letters = teleCharMap.get(num);

            for (String str: res) {
                for (Character character : letters) {
                    buffer.add(str+character);
                }
            }
            res = buffer;
            buffer = new LinkedList<>();
        }

        return res;
    }
}
// @lc code=end

