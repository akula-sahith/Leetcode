class Solution {
    public int minPathSum(int[][] grid) {
        // return recursion(grid,0,0,grid.length,grid[0].length);
        // int[][] dp = new int[grid.length][grid[0].length];
        // for(int[] arr : dp){
        //     Arrays.fill(arr,0);
        // }
        // return topDown(grid,0,0,grid.length,grid[0].length,dp);
           return bottomUp(grid);
    }
    //Recursion Approach
    public int recursion(int[][] grid,int i,int j,int m,int n){
        //Base Case 1 :- Return the cost if it is the goal
        if(i==(m-1)&&j==(n-1)){
            return grid[i][j];
        }
        //Base Case 2 :- Return the Max Value
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        int down = recursion(grid,i+1,j,m,n);
        int right = recursion(grid,i,j+1,m,n);
        int min = Math.min(down,right);
        if(min == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return grid[i][j] + min;
    }
    //Top Down Approach -> Recursion + Memoization
    public int topDown(int[][] grid,int i,int j,int m,int n,int[][] dp){
        if(i==(m-1)&&j==(n-1)){
            return grid[i][j];
        }
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int down = topDown(grid,i+1,j,m,n,dp);
        int right = topDown(grid,i,j+1,m,n,dp);
        int min = Math.min(down,right);
        if(min==Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        dp[i][j] = grid[i][j] + min;
        return grid[i][j] + min;
    }
    //Bottom Up Approach
    public int bottomUp(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int i = (m-1);i>=0;i--){
            for(int j = (n-1);j>=0;j--){
                if(i==(m-1)&&j==(n-1)){
                    continue;
                }
                 int down = Integer.MAX_VALUE;
             int right = Integer.MAX_VALUE;

                if(i < (m-1)){
                    down = dp[i+1][j];
                }
                if(j < (n-1)){
                    right = dp[i][j+1];
                }
                dp[i][j] = grid[i][j] + Math.min(down,right);
            }
        }
        return dp[0][0];
    }
}