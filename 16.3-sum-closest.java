/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.76%)
 * Likes:    1396
 * Dislikes: 100
 * Total Accepted:    390.1K
 * Total Submissions: 853.2K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int minDelta = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int delta = sum - target;
                if (delta == 0) {
                    closest = sum;
                    break;
                } else if (delta > 0) {
                    right--;
                    if (minDelta > Math.abs(delta)) {
                        minDelta = Math.abs(delta);
                        closest = sum;
                    }
                } else {
                    left++;
                    if (minDelta > Math.abs(delta)) {
                        minDelta = Math.abs(delta);
                        closest = sum;
                    }
                }
            }
            if (closest == target) break;
        }
        return closest; 
    }
}
// @lc code=end

