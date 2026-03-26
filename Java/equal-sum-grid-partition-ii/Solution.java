class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long totalSum = 0;
        int[] totalFreq = new int[100001];
        long[] rowSums = new long[m];
        long[] colSums = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                totalSum += val;
                rowSums[i] += val;
                colSums[j] += val;
                totalFreq[val]++;
            }
        }

        // 1. Horizontal Cuts
        long topSum = 0;
        int[] topFreq = new int[100001];
        for (int i = 0; i < m - 1; i++) {
            topSum += rowSums[i];
            for (int j = 0; j < n; j++) {
                topFreq[grid[i][j]]++;
            }
            long botSum = totalSum - topSum;

            // Check Top Section (can we discount from top to match bottom?)
            if (isPossible(topSum, botSum, topFreq, null, i + 1, n, grid, 0, i, 0, n - 1, true)) return true;
            // Check Bottom Section (can we discount from bottom to match top?)
            if (isPossible(botSum, topSum, totalFreq, topFreq, m - 1 - i, n, grid, i + 1, m - 1, 0, n - 1, false)) return true;
        }

        // 2. Vertical Cuts
        long leftSum = 0;
        int[] leftFreq = new int[100001];
        for (int j = 0; j < n - 1; j++) {
            leftSum += colSums[j];
            for (int i = 0; i < m; i++) {
                leftFreq[grid[i][j]]++;
            }
            long rightSum = totalSum - leftSum;

            // Check Left Section
            if (isPossible(leftSum, rightSum, leftFreq, null, m, j + 1, grid, 0, m - 1, 0, j, true)) return true;
            // Check Right Section
            if (isPossible(rightSum, leftSum, totalFreq, leftFreq, m, n - 1 - j, grid, 0, m - 1, j + 1, n - 1, false)) return true;
        }

        return false;
    }

    private boolean isPossible(long curSum, long otherSum, int[] f1, int[] f2, 
                               int h, int w, int[][] grid, int r1, int r2, int c1, int c2, boolean isF1Direct) {
        if (curSum == otherSum) return true;
        long diff = curSum - otherSum;
        if (diff <= 0 || diff > 100000) return false;
        int target = (int) diff;

        // Check if target exists in the current section
        boolean exists;
        if (isF1Direct) {
            exists = f1[target] > 0;
        } else {
            // Effectively: totalFreq[target] - topFreq[target] > 0
            exists = (f1[target] - f2[target]) > 0;
        }

        if (!exists) return false;

        // Connectivity Check
        if (h > 1 && w > 1) return true; 
        if (h == 1) return grid[r1][c1] == target || grid[r1][c2] == target;
        if (w == 1) return grid[r1][c1] == target || grid[r2][c1] == target;
        
        return false;
    }
}