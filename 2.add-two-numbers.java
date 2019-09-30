/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (31.72%)
 * Likes:    5987
 * Dislikes: 1565
 * Total Accepted:    1M
 * Total Submissions: 3.2M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        int temp = 0;
        while (l1 != null && l2 != null) {
            temp = temp + l1.val + l2.val;
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            temp = temp/10;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remain = l1 == null? l2: l1;
        while (remain != null) {
            temp = temp + remain.val;
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            temp = temp/10;
            remain = remain.next;
        }

        if (temp > 0) {
            cur.next = new ListNode(temp);
        }
        return ans.next;
    }
}

