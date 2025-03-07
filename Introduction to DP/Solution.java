/*Question 1:-

Introduction to DP

Geek is learning data structures, and he recently learned about the top-down and bottom-up dynamic programming approaches. Geek is having trouble telling them apart from one another.

When given an integer n, where n is based on a 0-based index, find the nth Fibonacci number.

Every ith number in the series equals the sum of the (i-1)th and (i-2)th numbers, where the first and second numbers are specified as 0 and 1, respectively.

For the given issue, code both top-down and bottom-up approaches.

Note : As the answer might be large, return the final answer modulo 109 + 7

Example 1:

Input:
n = 5
Output: 5
Explanation: 0,1,1,2,3,5 as we can see 5th number is 5.
Example 2:

Input:
n = 6
Output: 8
Explanation: 0,1,1,2,3,5,8 as we can see 6th number is 8.
Constraints:
1 <= n <= 104

Your Task:
You don't need to read input or print anything. Your task is to complete two functions topDown() and bottomUp() which take n as input parameters and return the nth Fibonacci number.
*/

class Solution {

    static long topDown(int n) {
        long dp[]=new long[n+1];
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=-1;
        }
        return Top(n,dp);
    }
    public static long Top(int n,long dp[])
    {
        if(n<=1)
        {
            return n;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
       return dp[n]=(Top(n-1,dp)+Top(n-2,dp))%1000000007;
    }

    static long bottomUp(int n) {
        long prev2=0;
        long prev=1;
        long curr=0;
        for(int i=2;i<=n;i++)
        {
            curr=(prev+prev2)%1000000007;
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}

/*TIME COMPLEXITY:-O(n)
SPACE COMPLEXITY:-o(1)
*/