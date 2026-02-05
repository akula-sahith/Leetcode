class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // return minSubBrute(target,nums);
        return minSubBetter(nums, target);
    }

    //Brute force approach
    public int minSubBrute(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                count++;
                sum += nums[j];
                if (sum >= target) {
                    minCount = Math.min(count, minCount);
                }
            }
        }
        if (minCount == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minCount;
        }
    }

    //Better approach
    public int minSubBetter(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int minCount = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minCount = Math.min(minCount, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minCount == Integer.MAX_VALUE) ? 0 : minCount;
    }
}