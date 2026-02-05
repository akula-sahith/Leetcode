class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return optiApproach(nums,goal);
    }
    
    //Optimized solution using subarray sum equals k
    public int optiApproach(int[] nums,int goal){
        //Calculate the prefix sum
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j = 0;j<nums.length;j++){
            int target = prefixSum[j] - goal;
            if(map.containsKey(target)){
                int fre = map.get(target);
                ans += fre;
            }
           map.put(prefixSum[j],map.getOrDefault(prefixSum[j],0)+1);
        }
        return ans;
    }
}