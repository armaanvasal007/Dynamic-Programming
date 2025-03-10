/*
House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

import java.util.*;
class Solution {
    public int rob(int[] a) {
int dp[]=new int[a.length];
Arrays.fill(dp,-1);
return count(a,dp,a.length-1);
    }
    public static int count(int a[],int dp[],int n)
    {
        if(n<0)
        {
            return 0;
        }
        if(n==0)
        {
            return a[0];
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int not_pick=0+count(a,dp,n-1);
        int pick=a[n]+count(a,dp,n-2);
        return dp[n]=Math.max(pick,not_pick);
    }
}

/*
TIME COMPLEXITY:-O(n)
SPACE COMPLEXITY:-O(n)
*/