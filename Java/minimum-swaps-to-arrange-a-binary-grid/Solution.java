class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        
        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;

        // Step 2: Try to place correct row at each position
        for (int i = 0; i < n; i++) {
            int requiredZeros = n - 1 - i;
            int j = i;

            // Find a row below that satisfies condition
            while (j < n && trailingZeros[j] < requiredZeros) {
                j++;
            }

            // If no such row found → impossible
            if (j == n) {
                return -1;
            }

            // Bring row j up to position i
            while (j > i) {
                // swap trailingZeros[j] and trailingZeros[j-1]
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;

                swaps++;
                j--;
            }
        }

        return swaps;
    }
}