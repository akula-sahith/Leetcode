class Solution {
    public int[] twoSum(int[] nums, int target) {
     //    return twoSumBrute(nums,target);
       return solution(nums,target);
         
    }

    //brute force approach -> O(n^2)
    public int[] twoSumBrute(int[] nums,int target){
        int[] ans = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    //Optimized Approach using hashmaps -> O(n)
    public int[] twoSumOpti(int[] nums,int target){
       HashMap<Integer,Integer> map = new HashMap<>();
       int[] ans = new int[2];
       for(int i = 0;i<nums.length;i++){
           int curr = nums[i];
           int complement = target - nums[i];
           if(map.containsKey(complement)){
              ans[0] = i;
              ans[1] = map.get(complement);
              return ans;
           }

           map.put(nums[i],i);
       }
       return ans;
    }
    
    //More brute force Approach - O(n ^ 2) + O(n) works only on sorted arrays
    public int[] twoSumBruteF(int[] nums,int target){
       
        int[] ans = new int[2];
        int i = 0;
        int j = nums.length - 1;
        while(i<nums.length&&j>=0){
            int sum = nums[i] + nums[j];
            if(sum==target){
                ans[0] = i;
                ans[1] = j;
                return ans;
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }

    //Optimized approach using the hashing 
    public int[] solution(int[] nums , int k){
        int[] ans = new int[2];
        HashMap < Integer , Integer > map = new HashMap <>();

        // map.put(0 , 1);

        for(int i = 0 ; i < nums.length ; i++){
            int target = k - nums[i];

            if(map.containsKey(target)){
                ans[0] = i;
                ans[1] = map.get(target);
                return ans;
            }

            map.put(nums[i] , i);
        }

        return ans;
    }
}