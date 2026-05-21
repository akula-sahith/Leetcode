class Solution {
    public int cherryPickup(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] grid : dp){
            for(int[] row : grid){
                Arrays.fill(row,-1);
            }
        }
        // return recursion(mat,0,0,m-1,n,m);
         return topDown(mat,0,0,m-1,n,m,dp);
    }

    //Recursion
    public int recursion(int[][] grid,int i,int j1,int j2,int n,int m){

         //Base Case 1 -> Out of bounds
         if(j1<0 || j1>=m || j2<0 || j2>=m){
            return -(int)1e9;
         }

         //Base Case 2 -> Destination
         if(i==(n-1)){
            //Both were at the same position -> Add only once
            if(j1==j2){
               return grid[i][j1];
            }else{
               return grid[i][j1] + grid[i][j2];
            }
         }
         int max = Integer.MIN_VALUE;
         //Explore all the paths possible
         //For each moment of Robo1 -> there will be 3 moments of Robo2
         for(int c1 = -1 ; c1<=1 ; c1++){
            for(int c2 = -1 ; c2<=1 ; c2++ ){
                //Check if they both are at same position -> If yes add only once
                if(j1==j2){
                    int curr = grid[i][j1];
                    max = Math.max(max,curr+recursion(grid,i+1,j1+c1,j2+c2,n,m));
                }else{
                     int curr = grid[i][j1] + grid[i][j2];
                    max = Math.max(max,curr+recursion(grid,i+1,j1+c1,j2+c2,n,m));
                }
            }
         }

         return max;

    }

    //TopDown -> Recursion + Memoization
    //Use 3d dp
    public int topDown(int[][] grid,int i,int j1,int j2,int n,int m,int[][][] dp){
        //Base Case 1 -> Out of bounds
         if(j1<0 || j1>=m || j2<0 || j2>=m){
            return -(int)1e9;
         }

         //Base Case 2 -> Destination
         if(i==(n-1)){
            //Both were at the same position -> Add only once
            if(j1==j2){
               return grid[i][j1];
            }else{
               return grid[i][j1] + grid[i][j2];
            }
         }

         //Base Case 3 -> Memoization
         if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
         }

          int max = Integer.MIN_VALUE;
         //Explore all the paths possible
         //For each moment of Robo1 -> there will be 3 moments of Robo2
         for(int c1 = -1 ; c1<=1 ; c1++){
            for(int c2 = -1 ; c2<=1 ; c2++ ){
                //Check if they both are at same position -> If yes add only once
                if(j1==j2){
                    int curr = grid[i][j1];
                    max = Math.max(max,curr+topDown(grid,i+1,j1+c1,j2+c2,n,m,dp));
                }else{
                     int curr = grid[i][j1] + grid[i][j2];
                    max = Math.max(max,curr+topDown(grid,i+1,j1+c1,j2+c2,n,m,dp));
                }
            }
         }

         dp[i][j1][j2] = max;

         return max;


    }
} 