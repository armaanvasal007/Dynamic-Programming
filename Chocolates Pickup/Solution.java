/*
Chocolates Pickup

You are given an n rows and m cols matrix grid representing a field of chocolates where grid[i][j] represents the number of chocolates that you can collect from the (i, j) cell.

You have two robots that can collect chocolates for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of chocolates collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the chocolates.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
Example:

Input:
n = 4, m = 3
grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output:
24
Explanation:
Path of robot #1 and #2 are described in color green and blue respectively. Chocolates taken by Robot #1, (3 + 2 + 5 + 2) = 12. Chocolates taken by Robot #2, (1 + 5 + 5 + 1) = 12. Total of Chocolates: 12 + 12 = 24.
Expected Time Complexity: O(n * m * m)
Expected Space Complexity: O(n * m * m)

Constraint:
2 <= n, m < = 70
0 <= grid[i][j] <= 100
*/


class Solution {
    public int solve(int n, int m, int grid[][]) {
       int dp[][][]=new int[n][m][m];
       for(int row[][]:dp)
       {
           for(int row1[]:row)
           {
               Arrays.fill(row1,-1);
           }
       }
       return count(0,0,m-1,grid,dp);
    }
    public static int count(int i,int j1,int j2,int grid[][],int dp[][][])
    {
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length)
        {
            return (int)Math.pow(-10,9);
        }
        if(i==grid.length-1)
        {
            if(j1==j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1)
        {
            return dp[i][j1][j2];
        }
        int max=Integer.MIN_VALUE;
        for(int dj1=-1;dj1<=1;dj1++)
        {
            for(int dj2=-1;dj2<=1;dj2++)
            {
                int value=0;
                if(j1==j2)
                {
                    value=grid[i][j1]+count(i+1,j1+dj1,j2+dj2,grid,dp);
                }
                else
                {
                    value=grid[i][j1]+grid[i][j2]+count(i+1,j1+dj1,j2+dj2,grid,dp);
                }
                max=Math.max(max,value);
            }
        }
        return dp[i][j1][j2]=max;
    }
}

/*
TIME COMPLEXITY:-O(n*m*m)
SPACE COMPLEXITY:-O(n*m*m)
*/