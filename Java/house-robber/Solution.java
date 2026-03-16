class Solution {
    public int rob(int[] nums) {
        // return robBrute(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        return robBack(nums,0,map);
    }

    //Brute Force Approach - Check for every possibility
    public int robBrute(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            int sum = 0;
            for(int j = i ; j < nums.length ; j+=2){
                sum += nums[j];
            }
            max = Math.max(max,sum);
        }
        return max;
    }

    //Backtracking approach
    public int robBack(int[] nums,int i , HashMap<Integer,Integer> map){
        if(i >= nums.length){
            return 0;
        }

        if(map.containsKey(i)){
            return map.get(i);
        }

        int rob = nums[i] + robBack(nums , i + 2 , map);
        int skip = robBack(nums , i + 1 , map);
        map.put(i , Math.max(rob , skip));
        return Math.max(rob , skip);
    }
}