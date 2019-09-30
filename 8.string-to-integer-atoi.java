/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (14.79%)
 * Likes:    1094
 * Dislikes: 6844
 * Total Accepted:    419.8K
 * Total Submissions: 2.8M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (2^31 − 1) or
 * INT_MIN (−2^31) is returned.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "42"
 * Output: 42
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical 
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * 
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 * 
 */
class Solution {
    public int myAtoi(String str) {
        int[][] transitions = new int[][] {
            {-1, 1, 2, 0, 4},
            {-1, -1, 2, -1, -1},
            {3, 3, 2, 3, 3},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        };

        int out = 0;
        int state = 0;
        int i = 0;

        int sign = 1;
        boolean signFlag = true; // 本来应该在状态机再加一个状态处理这个 edgecase 的, 但是懒得加了, 就这样吧
        
        while (state != -1 && state != 3 && state != 4) {
            if (i == str.length()) {
                state = transitions[state][0];
                break;
            }
            char input = str.charAt(i);
            if (input == '+') {
                state = transitions[state][1];
            } else if(input == '-') {
                state = transitions[state][1];
                if (signFlag) sign = -1;
            } else if (input >= '0' && input <= '9') {
                int x = input - '0';
                int new_out = 10*out+x;
                signFlag = false;
                if (new_out/10 == out && new_out%10 == x) {
                    out = new_out;
                    state = transitions[state][2];
                } else {
                    // overflow
                    if (sign == -1) {
                        out = Integer.MIN_VALUE;
                    } else {
                        out = Integer.MAX_VALUE;
                    }
                    state = 3;
                }
            } else if (input == ' ') {
                state = transitions[state][3];
            } else {
                state = transitions[state][4];
            }
            i++;
        }

        if (state == 3 || state == 2) {
            return sign*out;
        } else {
            return 0;
        }
    }
}

