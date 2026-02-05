class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // return findMaxBrute(nums, k);
        return findMaxOpti(nums, k);
    }

    //Brute Force approach
    public double findMaxBrute(int[] nums, int k) {
         double maxValue = -Double.MAX_VALUE;
    for (int i = 0; i <= nums.length - k; i++) {
        double sum = 0;
        for (int j = i; j < i + k; j++) {
            sum += nums[j];
        }
        double avg = sum / k;
        maxValue = Math.max(avg, maxValue);
    }
    return maxValue;
    }

    //Optimized approach
    public double findMaxOpti(int[] nums, int k) {
         double maxValue = -Double.MAX_VALUE;
         double sum = 0;
         for(int i = 0;i<nums.length;i++){
            sum += (double) nums[i];
            if(i>=k-1){
                double   avg = sum / k;
                 maxValue = Math.max(avg,maxValue);
                sum -= nums[i-k+1];
            }
            
         }
         return maxValue;
    }
}