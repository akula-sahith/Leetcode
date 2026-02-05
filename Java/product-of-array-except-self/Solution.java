class Solution {
    public int[] productExceptSelf(int[] nums) {
        return optimizedSolution(nums);
    }

    //Optimized Solution
    public int[] optimizedSolution(int[] nums) {
    int totalProduct = 1;
    int zeroCount = 0;

    for (int num : nums) {
        if (num == 0) {
            zeroCount++;
        } else {
            totalProduct *= num;
        }
    }

    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        if (zeroCount > 1) {
            ans[i] = 0;
        } else if (zeroCount == 1) {
            ans[i] = nums[i] == 0 ? totalProduct : 0;
        } else {
            ans[i] = totalProduct / nums[i];
        }
    }

    return ans;
}

}