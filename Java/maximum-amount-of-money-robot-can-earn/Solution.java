class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        // dp[i][j][k] -> max profit at (i, j) with k neutralizations used (k = 0, 1, 2)
        int[][][] dp = new int[m][n][3];
        
        // Initialize with a very small value to handle negative profits
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE / 2);
            }
        }

        // Base case: Starting point (0,0)
        dp[0][0][0] = coins[0][0]; // No neutralization used
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // Used one neutralization at the start
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    // Skip the start cell as it's already initialized
                    if (i == 0 && j == 0) continue;

                    int prevMax = Integer.MIN_VALUE / 2;
                    if (i > 0) prevMax = Math.max(prevMax, dp[i - 1][j][k]);
                    if (j > 0) prevMax = Math.max(prevMax, dp[i][j - 1][k]);

                    if (prevMax == Integer.MIN_VALUE / 2) continue;

                    // Option 1: Take the current cell as is (gain or loss)
                    dp[i][j][k] = Math.max(dp[i][j][k], prevMax + coins[i][j]);

                    // Option 2: If current cell is a robber and we have neutralizations left
                    if (coins[i][j] < 0 && k < 2) {
                        int prevNeutralMax = Integer.MIN_VALUE / 2;
                        if (i > 0) prevNeutralMax = Math.max(prevNeutralMax, dp[i - 1][j][k]);
                        if (j > 0) prevNeutralMax = Math.max(prevNeutralMax, dp[i][j - 1][k]);
                        
                        // We use a neutralization here, moving from state k to k+1
                        dp[i][j][k + 1] = Math.max(dp[i][j][k + 1], prevNeutralMax);
                    }
                }
            }
        }

        // The answer is the max profit at the bottom-right with 0, 1, or 2 neutralizations used
        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}