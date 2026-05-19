class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // return recursion(triangle,0,0);
        
        //Initialize for the memoization
        // int[][] dp = new int[triangle.size()][triangle.size()];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return topDown(triangle,0,0,dp);
        return bottomUp(triangle);
    }

    //Recursion Approach
    public int recursion(List<List<Integer>> triangle,int i,int j){
        //Base Case 1 -> Check if it reached the bottom level
        if(i==triangle.size()-1&&j<triangle.get(i).size()){
            return triangle.get(i).get(j);
        }
        //Base Case 2 -> Check if level or position is out of bounds
        if(i>=triangle.size() || j>=triangle.get(i).size()){
            return Integer.MAX_VALUE;
        }

        //Explore both the bottom & digonal ways
        int down = recursion(triangle,i+1,j);
        int diag = recursion(triangle,i+1,j+1);
        int min = Math.min(down,diag);
        if(min==Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return triangle.get(i).get(j) + min;
    }

    //Top Down Approach - Memoization
    public int topDown(List<List<Integer>> triangle,int i,int j,int[][] dp){

    // Bottom row
    if(i == triangle.size() - 1){
        return triangle.get(i).get(j);
    }

    // Memoized
    if(dp[i][j]!=-1){
        return dp[i][j];
    }

    int down = topDown(triangle,i+1,j,dp);
    int diag = topDown(triangle,i+1,j+1,dp);
    
    dp[i][j] = triangle.get(i).get(j) + Math.min(down,diag);
    

    return dp[i][j];
}

 public int bottomUp(List<List<Integer>> triangle){
    int n = triangle.size();
    int[][] dp = new int[n][n];
    //Initialize the n base case (All the positions of last level)
    for(int i = 0 ; i < n ; i++){
        dp[n-1][i] = triangle.get(n-1).get(i);
    }

    //Now move upwards
    for(int i = (n-2) ; i >= 0 ;i--){
        for(int j = i ; j >= 0 ; j--){
            int down = triangle.get(i).get(j) + dp[i+1][j];
            int diag = triangle.get(i).get(j) + dp[i+1][j+1];
            dp[i][j] = Math.min(down,diag);
        }
    }

    return dp[0][0];
 }

}