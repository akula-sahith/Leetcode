class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                result ^= nums[i];
            }else{
                seen.add(nums[i]);
            }
        }
        return result;
    }
}