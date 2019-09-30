import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 *
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
 *
 * algorithms
 * Hard (48.91%)
 * Likes:    773
 * Dislikes: 22
 * Total Accepted:    27.6K
 * Total Submissions: 56.1K
 * Testcase Example:  '[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]'
 *
 * You have k lists of sorted integers in ascending order. Find the smallest
 * range that includes at least one number from each of the k lists.
 * 
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c
 * if b-a == d-c.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * Explanation: 
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * -10^5 <= value of elements <= 10^5.
 * 
 * 
 */
class Solution {

    class Node{
        int val;
        int row;
        int col;
        Node (int row, int col, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }

        public String toString() {
            return ""+this.val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.val - b.val);

        int k = nums.size();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int s, t;
        int range = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new Node(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
            min = Math.min(min, nums.get(i).get(0));
        }
        range = max - min;
        s = min;
        t = max;

        while (pq.size() == k) {
            Node cur = pq.poll();
            if ((max - cur.val) < range) {
                s = cur.val;
                t = max;
                range = max - cur.val;
            }
            if (cur.col < nums.get(cur.row).size()-1) {
                cur.col += 1;
                cur.val = nums.get(cur.row).get(cur.col);
                max = Math.max(max, cur.val);
                pq.add(cur);
            }    
        }
        // System.out.println(s);
        // System.out.println(t);
        return new int[] {s, t};
    }
}

