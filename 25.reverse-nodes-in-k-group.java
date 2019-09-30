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
        if (head == null || k == 1) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        ListNode con, tail;

        int firstPass = 0;

        while (curr != null) {
            int counter = k;
            tail = curr;
            while (counter > 0 && curr != null) {
                counter--;
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if (counter > 0) {
                int recount = k-counter;
                curr = prev;
                prev = null;
                while (recount > 0) {
                    recount--;
                    temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
            } else {
                // concate
                tail.next = prev;
            }
            if (firstPass == 0) {
                firstPass++;
                head = prev;
            }
        }
        return head;
    }
}

