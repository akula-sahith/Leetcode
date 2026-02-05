class Solution {
    public long countSubarrays(int[] nums, long k) {
        return countSubOpti(nums,k);
    }

    public long countSubOpti(int[] nums,long k){
        int left = 0;
        int right = 0;
        long sum = 0;
        long count = 0;
        while(right < nums.length){
            sum += (long) nums[right];
            long len = (right - left) + 1;
            while((sum*len)>=k&&left<nums.length){
                sum -= nums[left];
                left++;
                len--;
            }
            count += len;
            right++;
        }
        return count;

    }
}