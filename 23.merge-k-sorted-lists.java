import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (35.85%)
 * Likes:    3086
 * Dislikes: 206
 * Total Accepted:    472.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>((x, y) -> x.val-y.val);
        for (ListNode node : lists) {
            if (node != null) {
                minQueue.add(node);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!minQueue.isEmpty()) {
            ListNode minNode = minQueue.poll();
            if (minNode.next != null) {
                minQueue.add(minNode.next);
            }
            cur.next = minNode;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

