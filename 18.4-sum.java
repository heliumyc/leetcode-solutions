import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (31.41%)
 * Likes:    1300
 * Dislikes: 263
 * Total Accepted:    269.5K
 * Total Submissions: 850.3K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        nSum(nums, 0, nums.length-1, target, 4, new ArrayList<>(), results);
        return results;
    }
    
    private void twoSum(int[] nums, int start, int end, int target, List<Integer> prefix, List<List<Integer>> results) {
        int left = start;
        int right = end;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> buffer = new ArrayList<>(prefix);
                buffer.add(nums[left]);
                buffer.add(nums[right]);
                results.add(buffer);
                while (left+1 < right && nums[left] == nums[left+1]) {
                    left++;
                }
                while (left < right-1 && nums[right-1] == nums[right]) {
                    right--;
                }
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    private void nSum(int[] nums, int start, int end, int target, int n, List<Integer> prefix, List<List<Integer>> results) {
        if (n == 2) this.twoSum(nums, start, end, target, prefix, results);
        else {
            for (int i = start; i <= end-n+1; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;
                List<Integer> buffer = new ArrayList<>(prefix);
                buffer.add(nums[i]);
                nSum(nums, i+1, end, target-nums[i], n-1, buffer, results);
            }
        }
    }

}
// @lc code=end

