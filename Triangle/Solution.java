/*
Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.size()];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return sum(triangle,dp,0,0);
    }
    public static int sum(List<List<Integer>> triangle,int dp[][],int i,int j)
    {
        if(i==triangle.size()-1)
        {
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+sum(triangle,dp,i+1,j);
        int diagonal=triangle.get(i).get(j)+sum(triangle,dp,i+1,j+1);
        return dp[i][j]=Math.min(down,diagonal);
    }
}

/*
TIME COMPLEXITY:-O(n*n)
SPACE COMPLEXITY:-O(n*n)
*/