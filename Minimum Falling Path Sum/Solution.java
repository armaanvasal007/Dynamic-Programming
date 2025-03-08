/*
Minimum Falling Path Sum

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
*/

class Solution {
    public int minFallingPathSum(int[][] a) {
       int dp[][]=new int[a.length][a.length];
       for(int row[]:dp)
       {
        Arrays.fill(row,Integer.MAX_VALUE);
       }
       int mini=Integer.MAX_VALUE;
       for(int i=0;i<a.length;i++)
       {
        mini=Math.min(mini,count(a,dp,a.length-1,i));
       }
       return mini;
    }
    public static int count(int a[][],int dp[][],int i,int j)
    {
         if(j<0 || j>=a.length)
        {
            return  Integer.MAX_VALUE;
        }

        if(i==0)
        {
            return a[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE)
        {
            return dp[i][j];
        }
        int up=count(a,dp,i-1,j);
        int left=count(a,dp,i-1,j-1);
        int right=count(a,dp,i-1,j+1);
        return dp[i][j]=a[i][j]+Math.min(up,Math.min(left,right));
    }
}

/*
TIME COMPLEXITY:-O(n*n)
SPACE COMPLEXITY:-O(n) + O(n*m)
*/