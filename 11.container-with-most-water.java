/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (46.44%)
 * Likes:    4067
 * Dislikes: 478
 * Total Accepted:    463.3K
 * Total Submissions: 984.1K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) return 0;
        int p1 = 0;
        int p2 = height.length-1;
        int max = (p2-p1)*Math.min(height[p1], height[p2]);
        while (p1 < p2) {
            if (height[p1] < height[p2]) {
                int temp = height[p1];
                while (height[p1] <= temp && p1 < p2) {
                    p1++;
                }
            }
            // when the two pointer value is the same, it does not matter which to move, cuz
            // anyway they both must move to get another optimal max (think about it)
            else {
                int temp = height[p2];
                while (height[p2] <= temp && p1 < p2) {
                    p2--;
                }
            }
            max = Math.max((p2-p1)*Math.min(height[p1], height[p2]), max);
        }
        return max;
    }
}
// @lc code=end

