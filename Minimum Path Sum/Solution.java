/*
Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
*/


class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int row1[]:dp)
        {
            Arrays.fill(row1,-1);
        }
        return count(grid,dp,grid.length-1,grid[0].length-1);
    }
    public static int count(int a[][],int dp[][],int m,int n)
    {
        if(m==0 && n==0)
        {
            return a[0][0];
        }
        if(m<0 || n<0)
        {
            return 1000000;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        int left=a[m][n]+count(a,dp,m,n-1);
        int up=a[m][n]+count(a,dp,m-1,n);
        return dp[m][n]=Math.min(left,up);
    }
    
/*    
TIME COMPLEXITY:-O(m*n)
SPACE COMPLEXITY:-O(m*n)
*/
}