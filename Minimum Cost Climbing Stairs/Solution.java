/*
Min Cost Climbing Stairs

Solved
Easy
Topics
Companies
Hint
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
*/

import java.util.*;
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(count(cost,dp,0),count(cost,dp,1));
    }
    public static int count(int a[],int dp[],int n)
    {
        if(n>=a.length)
        {
            return 0;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int jump_one=a[n]+count(a,dp,n+1);
        int jump_two=Integer.MAX_VALUE;
            jump_two=a[n]+count(a,dp,n+2);
        return dp[n]=Math.min(jump_one,jump_two);
    }
}

/*
TIME COMPLEXITY:-O(n)
SPACE COMPLEXITY:-O(n)
*/