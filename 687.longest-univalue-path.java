
/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Easy (34.43%)
 * Likes:    1113
 * Dislikes: 284
 * Total Accepted:    67.4K
 * Total Submissions: 195.4K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the
 * root.
 * 
 * The length of path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * Output: 2
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * Output: 2
 * 
 * 
 * 
 * Note: The given binary tree has not more than 10000 nodes. The height of the
 * tree is not more than 1000.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {

    static int maxLen = 0;

    public int travelDown(TreeNode root) {
        if (root == null) return 0;
        int sameFlag = 0;
        int leftVal = 0, rightVal = 0;
        int onePathLen = 0;

        if (root.left != null) leftVal = travelDown(root.left);
        if (root.right != null) rightVal = travelDown(root.right);

        if (root.left != null && root.left.val == root.val) {
            sameFlag++;
            maxLen = Math.max(leftVal+1, maxLen);
            onePathLen = Math.max(onePathLen, leftVal+1);
        }
        if (root.right != null && root.right.val == root.val) {
            sameFlag++;
            maxLen = Math.max(rightVal+1, maxLen);
            onePathLen = Math.max(onePathLen, rightVal+1);
        }
        if (sameFlag == 2) {
            maxLen = Math.max(leftVal+rightVal+2, maxLen);
        }
        return onePathLen;
    }
    public int longestUnivaluePath(TreeNode root) {
        maxLen = 0;
        travelDown(root);
        return maxLen;
    }
}

