class Solution {
    public int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int currSum = arr[left] + arr[right];
            if(currSum == target){
                return new int[]{left+1,right+1};
            }else if(currSum < target){
                left++;
            }else{
                right--;
            }
        }

        return new int[]{-1,-1};
    }
}