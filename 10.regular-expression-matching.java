import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.63%)
 * Likes:    3102
 * Dislikes: 577
 * Total Accepted:    344.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */


 // THIS IS SLOW FOR THIS PROBLEM, BUT MORE POWERFUL AND MORE GENERAL
 // IT IS ACTUALLY A REGEX PARSER USING THOMPSON CONSTRUCTION
 // IF YOU USE DP, IT MAY BE FAST, BUT POINTLESS
class Solution {
    enum StateType {Match, Split, Terminal};
    class State {
        StateType type;
        char val;
        State out1;
        State out2;
        State(StateType type, char val) {
            this.type = type;
            this.val = val;
        }

        boolean isSplit() {
            return this.type == StateType.Split;
        }

        boolean isTerminal() {
            return this.type == StateType.Terminal;
        }

        boolean canTerminal(State cur) {
            if (cur.isTerminal()) return true;
            else if (cur.isSplit()) {
                return canTerminal(cur.out2);
            }
            else {
                return false;
            }
        }
    }

    public boolean recursiveMatch(State init, String str, int index) {
        if (init.isTerminal()) return index == str.length();
        if (index == str.length()) return init.canTerminal(init);

        if (init.val == '.' || str.charAt(index) == init.val) {
            if (init.isSplit()) {
                return recursiveMatch(init.out1, str, index+1) || recursiveMatch(init.out2, str, index) ;
            }
            else {
                return recursiveMatch(init.out1, str, index+1);
            }
        }
        else {
            if (init.isSplit()) return recursiveMatch(init.out2, str, index);
            else return false;
        }
    }

    public boolean isMatch(String s, String p) {
        // if you dont use recursive, use stack to backtrace
        if (p.length() == 0) {
            return s.length() == 0;
        }
        State init, cur;
        // building nfa
        init = new State(StateType.Match, p.charAt(0));
        cur = init;
        for (int i = 1; i < p.length(); i++) {
            if ((p.charAt(i) >= 'a' && p.charAt(i) <= 'z') || p.charAt(i) == '.') {
                if (cur.isSplit()) {
                    cur.out2 = new State(StateType.Match, p.charAt(i));
                    cur = cur.out2;
                }
                else {
                    cur.out1 = new State(StateType.Match, p.charAt(i));
                    cur = cur.out1;
                }
            }
            else if (p.charAt(i) == '*') {
                if (cur.isSplit()) return false; // find pattern like []**, illegal case
                cur.out1 = cur;
                cur.type = StateType.Split;
            }
            else {
                return false;
            }
        }

        if (cur.isSplit())
            cur.out2 = new State(StateType.Terminal, '0');
        else
            cur.out1 = new State(StateType.Terminal, '0');
            
        return recursiveMatch(init, s, 0);
    }
}

