class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        // return recurrence(grid,0,0,grid.length,grid[0].length);
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr,0);
        }
        return topDown(grid,0,0,grid.length,grid[0].length,dp);
    }

    //Recurrence
    public int recurrence(int[][] grid,int i,int j,int m,int n){
        //Base Case 1 -> Check if index is out of range
        if(i>=m || j>=n){
            return 0;
        }
        //Base Case 2 -> Check if the box is a obstacle
        if(grid[i][j]==1){
            return 0;
        }
        //Base Case 3 -> Return if it reached the destination
        if(i==(m-1) && j==(n-1)){
            return 1;
        }

        int down = recurrence(grid,i+1,j,m,n);
        int right = recurrence(grid,i,j+1,m,n);
        return down + right;
    }
    //Top Down - Memoization
    public int topDown(int[][] grid,int i,int j,int m,int n,int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        //Base Case 2 -> Check if the box is a obstacle
        if(grid[i][j]==1){
            return 0;
        }
        //Base Case 3 -> Return if it reached the destination
        if(i==(m-1) && j==(n-1)){
            return 1;
        }
        //Base Case 4 -> Check if it is already explored
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        int down = topDown(grid,i+1,j,m,n,dp);
        int right = topDown(grid,i,j+1,m,n,dp);
        dp[i][j] = down + right;
        return down + right;
    }
    //Bottom Up - Tabulation

}