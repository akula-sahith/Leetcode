class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length == 0) return 0;  // Edge case

        int i = 0;  // Pointer to track unique elements

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {  
                i++;  
                nums[i] = nums[j]; 
            }
        }
        return i + 1;  // Unique count (k)
    // }
}
}