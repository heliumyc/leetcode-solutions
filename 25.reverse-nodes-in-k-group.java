/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (37.72%)
 * Likes:    1364
 * Dislikes: 273
 * Total Accepted:    203.4K
 * Total Submissions: 539K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * 
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        while (fast != null) {
            for (int i = 0; i < k; i++) {
                fast = fast.next;
                if (fast == null) return dummyHead.next;
            }

            ListNode next = slow.next;
            ListNode temp = fast.next;
            fast.next = null;

            reverse(next);
            slow.next = fast;
            next.next = temp;

            slow = next;
            fast = next;
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode next = dummyHead.next;
            dummyHead.next = head;
            head = head.next;
            dummyHead.next.next = next;
        }
        return dummyHead.next;
    }
}

