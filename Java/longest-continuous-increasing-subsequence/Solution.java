class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = Integer.MIN_VALUE;
        int length = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i - 1]){
                length++;
            }else{
                max = Math.max(max , length);
                length = 1;
            }
        }
        return Math.max(max , length);
    }
}