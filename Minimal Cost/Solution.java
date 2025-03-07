/*
Minimal Cost

Given an array arr[] of size n, where arr[i] denotes the height of ith stone. Geek starts from stone 0 and from stone i, 
he can jump to stones i + 1, i + 2, … i + k. The cost for jumping from stone i to stone j is abs(arr[i] – arr[j]). 
Find the minimum cost for Geek to reach the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be |10-30| + |30-20| = 30, which is minimum.
Input: k = 1, arr[]= [10, 20, 10]
Output: 20
Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.
Constraints:

1 <= arr.size() <=104
1 <= k <= 100
1 <= arr[i] <= 104
 */

import java.util.*;
class Solution {
    public int minimizeCost(int k, int a[]) {
        int dp[]=new int[a.length];
        Arrays.fill(dp,-1);
        return count(a,dp,a.length-1,k);
    }

    public static int count(int a[],int dp[],int n,int k)
    {
        if(n==0)
        {
            return 0;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {
            if((n-i)>=0)
            {
                int min=Math.abs(a[n]-a[n-i])+count(a,dp,n-i,k);
                mini=Math.min(mini,min);
            }
        }
        return dp[n]=mini;
    }
}

/*
TIME COMPLEXITY:-O(n*k)
SPACE COMPLEXITY:-O(n+k)
 */