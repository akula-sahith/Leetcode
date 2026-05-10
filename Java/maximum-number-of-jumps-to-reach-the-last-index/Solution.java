class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Initialize dp array with -1 (unreachable)
        java.util.Arrays.fill(dp, -1);
        
        // Base case: starting point
        dp[0] = 0;
        
        // Fill the DP table
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // Can we jump from i to j?
                if (dp[i] != -1 && Math.abs((long)nums[j] - nums[i]) <= (long)target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}