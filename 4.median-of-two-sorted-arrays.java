/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (27.20%)
 * Likes:    5030
 * Dislikes: 730
 * Total Accepted:    508.2K
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    // there are two solutions
    // but i think the k-th solution is more intuitive and more general
    // the other iterative O(min(n, m)) solution is complicated and full of edge cases and specified for this problem
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len%2 == 1) {
            return kthNumber(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, len/2+1);
        } else {
            return (kthNumber(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, len/2) + 
                kthNumber(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, len/2+1)) / 2.0;
        }
    }

    public int kthNumber(int[] nums1, int[] nums2, int s1, int e1, int s2, int e2, int k) {
        if (s1 > e1) return nums2[s2+k-1];
        if (s2 > e2) return nums1[s1+k-1];

        int mid1 = (s1 + e1) / 2;
        int mid2 = (s2 + e2) / 2;

        if ((mid1 - s1) + (mid2 - s2) + 1 < k) {
            if (nums1[mid1] > nums2[mid2]) {
                return kthNumber(nums1, nums2, s1, e1, mid2+1, e2, k-(mid2-s2+1));
            }
            else {
                return kthNumber(nums1, nums2, mid1+1, e1, s2, e2, k-(mid1-s1+1));
            }
        }
        else {
            if (nums1[mid1] > nums2[mid2]) {
                return kthNumber(nums1, nums2, s1, mid1-1, s2, e2, k);
            }
            else {
                return kthNumber(nums1, nums2, s1, e1, s2, mid2-1, k);
            }
        }
    }
}

