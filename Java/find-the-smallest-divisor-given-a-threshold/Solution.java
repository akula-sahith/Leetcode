class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int num : nums){
            // left = Math.min(left , num);
            right = Math.max(right , num);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(inThreshhold(nums,threshold,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }


        return left;
    }

    public boolean inThreshhold(int[] nums,int threshold,int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num + divisor - 1)/divisor;
        }

        return sum <= threshold;
    }
}