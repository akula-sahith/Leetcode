class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // The minimum element must be in the right halves
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                // The minimum element is at mid or to the left of mid
                high = mid;
            } else {
                // When nums[mid] == nums[high], we cannot determine which side to go.
                // We safely decrement high to shrink the search space.
                high--;
            }
        }
        
        return nums[low];
    }
}