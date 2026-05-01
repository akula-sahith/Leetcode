class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;

        // Step 1: Calculate Total Sum (S) and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long maxVal = f;

        // Step 2: Use the iterative formula to find F(1) to F(n-1)
        // F(k) = F(k-1) + sum - n * nums[n-k]
        for (int i = 1; i < n; i++) {
            f = f + sum - (long) n * nums[n - i];
            maxVal = Math.max(maxVal, f);
        }

        return (int) maxVal;
    }
}