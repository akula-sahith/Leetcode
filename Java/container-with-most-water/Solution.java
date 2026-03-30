class Solution {
    public int maxArea(int[] height) {
        // return maxAreaBrute(height)
        return optimizedSolution(height);
    }

    //Brute Force approach
    public int maxAreaBrute(int[] nums){
        int max_area = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            for(int j = (i+1);j<nums.length;j++){
                int height = Math.min(nums[i],nums[j]);
                int area = (j -i) * height;
                max_area = Math.max(area,max_area);
            }
        }
        return max_area;
    }

    public int optimizedSolution(int[] height){
        int max_area = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int height_cal = Math.min(height[left],height[right]);
            int width = right - left;
            int area = height_cal * width;
            max_area = Math.max(area , max_area);
            if(height[left] < height[right]){
               left++;
            }else{
                right--;
            }
        }

        return max_area;
    }
}