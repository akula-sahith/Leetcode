class Solution {

    int[] dp;

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;
        dp = new int[n];

        int ans = 1;

        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d));
        }

        return ans;
    }

    private int dfs(int i, int[] arr, int d) {

        // Already computed
        if(dp[i] != 0) return dp[i];

        int max = 1; // At least we can stay at current index

        // Move Right
        for(int j = i + 1; j <= Math.min(i + d, arr.length - 1); j++) {

            // If greater/equal found, cannot move further
            if(arr[j] >= arr[i]) break;

            max = Math.max(max, 1 + dfs(j, arr, d));
        }

        // Move Left
        for(int j = i - 1; j >= Math.max(i - d, 0); j--) {

            // If greater/equal found, cannot move further
            if(arr[j] >= arr[i]) break;

            max = Math.max(max, 1 + dfs(j, arr, d));
        }

        return dp[i] = max;
    }
}