class Solution {
    public int[] searchRange(int[] nums, int target) {
        return searchRange2(nums,target);
    }

    //Approach using binary search
    public int[] searchRange2(int[] nums, int target) {
    int[] ans = {-1, -1};
    
    ans[0] = findFirst(nums, target);
    ans[1] = findLast(nums, target);
    
    return ans;
}

private int findFirst(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    int index = -1;
    
    while(start <= end) {
        int mid = start + (end - start) / 2;
        
        if(nums[mid] == target) {
            index = mid;
            end = mid - 1;  // move left
        } 
        else if(nums[mid] < target) {
            start = mid + 1;
        } 
        else {
            end = mid - 1;
        }
    }
    
    return index;
}

private int findLast(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    int index = -1;
    
    while(start <= end) {
        int mid = start + (end - start) / 2;
        
        if(nums[mid] == target) {
            index = mid;
            start = mid + 1;  // move right
        } 
        else if(nums[mid] < target) {
            start = mid + 1;
        } 
        else {
            end = mid - 1;
        }
    }
    
    return index;
}

}