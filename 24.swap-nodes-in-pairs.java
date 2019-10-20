/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (46.15%)
 * Likes:    1460
 * Dislikes: 129
 * Total Accepted:    367K
 * Total Submissions: 784.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        while (fast != null) {
            for (int i = 0; i < 2; i++) {
                fast = fast.next;
                if (fast == null) return dummyHead.next;
            }
            ListNode temp = fast.next;
            ListNode next = slow.next;

            fast.next = next;
            next.next = temp;
            slow.next = fast;
            slow = next;
            fast = next;
        }

        return dummyHead.next;
    }
}
// @lc code=end

