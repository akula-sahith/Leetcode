class Solution {
    public void moveZeroes(int[] nums) {
        helper(nums , 0 , 0);
    }

    public void helper(int[] nums , int i , int insertPos){
        if (i == nums.length){
            for(int j = insertPos ; j < nums.length ; j++){
                nums[j] = 0;
            }
            return;
        }

        if(nums[i] != 0){
            nums[insertPos] = nums[i];
            insertPos += 1;
        }

        helper(nums , i + 1 , insertPos);
    }
}