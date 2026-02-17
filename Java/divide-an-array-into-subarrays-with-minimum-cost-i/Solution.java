class Solution {
    public int minimumCost(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            }else if(nums[i]<secondSmallest){
                secondSmallest = nums[i];
            }
        }
        return nums[0] + smallest + secondSmallest;
    }
}