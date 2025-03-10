/*Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
*/

class Solution {
    public int climbStairs(int n) {
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return climb(n,dp);
//     }
//     public static int climb(int n,int dp[])
//     {
//         if(n<=2)
//         {
//             return n;
//         }
//         if(dp[n]!=-1)
//         {
//             return dp[n];
//         }
//         return dp[n]=climb(n-1,dp)+climb(n-2,dp);
//     }
// }


if(n<=2)
{
    return n;
}
int prev1=2;
int prev2=1;
int curr=0;
for(int i=3;i<=n;i++)
{
    curr=prev1+prev2;
    prev2=prev1;
    prev1=curr;
}
return curr;
    }
}
/*
TIME COMPLEXITY:-O(n)
SPACE COMPLEXITY:-O(1)
*/