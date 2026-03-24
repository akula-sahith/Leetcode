class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int n = grid.length, m = grid[0].length;
        
        int k = n * m;
        int[] arr = new int[k];
        
        // Step 1: Flatten grid
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % MOD;
            }
        }
        
        // Step 2: Prefix products
        int[] res = new int[k];
        res[0] = 1;
        for (int i = 1; i < k; i++) {
            res[i] = (res[i - 1] * arr[i - 1]) % MOD;
        }
        
        // Step 3: Suffix multiplication
        int suf = 1;
        for (int i = k - 1; i >= 0; i--) {
            res[i] = (res[i] * suf) % MOD;
            suf = (suf * arr[i]) % MOD;
        }
        
        // Step 4: Convert back to 2D
        int[][] ans = new int[n][m];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = res[idx++];
            }
        }
        
        return ans;
    }
}