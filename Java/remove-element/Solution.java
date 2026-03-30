class Solution {
    public int removeElement(int[] nums, int val) {
        int fre = 0;
        
        int insertPos = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                int temp = nums[i];
                nums[i] = nums[insertPos];
                nums[insertPos] = temp;
                insertPos++;
            }else{
                fre++;
            }
        }

        return nums.length - fre;
    }
}