class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefix = 0;
        long[] minPrefix = new long[k];
        long ans = Long.MIN_VALUE;
        Arrays.fill(minPrefix,Long.MAX_VALUE);
        minPrefix[0] = 0;
        for(int i = 0 ; i < nums.length ; i++){
            prefix += nums[i];
            int rem = (i + 1) % k;
            if(minPrefix[rem] != Long.MAX_VALUE){
                long candidate = prefix - minPrefix[rem];
                ans = Math.max(candidate , ans);
            }
            minPrefix[rem] = Math.min(minPrefix[rem] , prefix);
        }
        return ans;
    }
}