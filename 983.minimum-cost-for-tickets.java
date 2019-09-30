import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */
class Solution {

    // O(W)
    // static int[] prefixSumArr = new int[366];

    // public int hasNeed(int startDay, int endDay) {
    //     if ((prefixSumArr[Math.max(0, endDay)] - prefixSumArr[Math.max(0, startDay-1)]) > 0) {
    //         return 1;
    //     }
    //     else {
    //         return 0;
    //     }
    // }

    // public int mincostTickets(int[] days, int[] costs) {
    //     // init prefix sum arr
    //     java.util.Arrays.fill(prefixSumArr, 0);
    //     for (int i = 0; i < days.length; i++) {
    //         prefixSumArr[days[i]] = 1;
    //     }
    //     for (int i = 1; i < prefixSumArr.length; i++) {
    //         prefixSumArr[i] += prefixSumArr[i-1];
    //     }

    //     // dp
    //     int[] totalCost = new int[366];
    //     totalCost[0] = 0;
    //     for (int i = 1; i < totalCost.length; i++) {
    //         int cost_0 = totalCost[Math.max(0, i-1)] + costs[0]*hasNeed(i, i);
    //         int cost_1 = totalCost[Math.max(0, i-7)] + costs[1]*hasNeed(i-6, i);
    //         int cost_2 = totalCost[Math.max(0, i-30)] + costs[2]*hasNeed(i-29, i);
    //         totalCost[i] = Math.min(Math.min(cost_0, cost_1), cost_2);
    //     }

    //     return totalCost[365];
    // }


    // O(n)
    public int mincostTickets(int[] days, int[] costs) {
        int[] totalCost = new int[days.length];
        int[] duration = {1, 7, 30};
        Arrays.fill(totalCost, Integer.MAX_VALUE);
        // Set<T> daySet = Arrays.stream(days).boxed().collect(Collectors.toSet());
        for (int k = 0; k < totalCost.length; k++) {
            for (int i = 0; i < costs.length; i++) {
                int j = k;
                while (j >= 0 && days[j] + duration[i] > days[k]) {
                    j--;
                } // find the largest index such that the ticket could cover current day
                totalCost[k] = Math.min(totalCost[k], j < 0? costs[i]: totalCost[j]+costs[i]);
            }
        }
        return totalCost[totalCost.length-1];
    }
}

