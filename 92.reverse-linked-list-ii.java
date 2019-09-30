/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (35.91%)
 * Likes:    1424
 * Dislikes: 100
 * Total Accepted:    212.3K
 * Total Submissions: 591K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || m < 1) return head;
        int counter = n-m;

        // init: set reverse function from m
        ListNode prev = null;
        ListNode curr = head;
        for (int i = m; i > 1; i--) {
            prev = curr;
            curr = curr.next;
        }

        // start reverse
        ListNode con = prev;
        ListNode tail = curr;
        ListNode temp = null;
        while (counter >= 0 && curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            counter--;
        }

        // concate
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;
        return head;
    }
}

