class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;

        // Step 1: Calculate Total Sum
        // We also pre-calculate row sums to make horizontal checks O(m)
        long[] rowSums = new long[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += grid[i][j];
            }
            totalSum += rowSums[i];
        }

        // Step 2: Check Horizontal Cuts
        // A cut is possible between row i and i+1
        long topSum = 0;
        for (int i = 0; i < m - 1; i++) {
            topSum += rowSums[i];
            if (topSum * 2 == totalSum) {
                return true;
            }
        }

        // Step 3: Check Vertical Cuts
        // Calculate column sums and check as we go to save space
        long leftSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                leftSum += grid[i][j];
            }
            if (leftSum * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}