class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put((i+1),0);
        }

        for(int i = 0;i<nums.length;i++){
           int value = map.get(nums[i]);
           value += 1;
           map.put(nums[i],value);
        }

        //Iterate through hashmap for finding the answer
        for(int i = 0;i<nums.length;i++){
            int value = map.get((i+1));
            if(value==2){
                ans[0] = (i+1);
            }
            if(value==0){
                ans[1] = (i+1);
            }
        }

        return ans;

        // return ans;
    }
}