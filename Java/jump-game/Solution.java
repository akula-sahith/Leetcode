class Solution {
    public boolean canJump(int[] nums) {
        // return helper(nums, 0);
           return helper2(nums);
    }

    //Brute Force approach is we can use recursion until we reach the end
    public boolean helper(int[] nums, int currIndex) {
        if (currIndex == (nums.length - 1)) {
            return true;
        }

        int maxJump = nums[currIndex];
        for (int jump = 1; jump <= maxJump; jump++) {
            if (helper(nums, currIndex + jump))
                return true;
        }

        return false;
    }


    //Optimized approach is using GREEDY method
    //Just check for each index the farthest index you can reach from there
    public boolean helper2(int[] nums){
     
     int maxReach = 0;
     for(int i = 0;i<nums.length;i++){
        if(i > maxReach){
            return false;
        }

        maxReach = Math.max(maxReach , (i + nums[i]));
     }

     return true;

    }
}