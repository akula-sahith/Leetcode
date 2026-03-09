class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper1(nums , ans , list , 0);
        return ans;
    }

    public void helper1(int[] nums , List<List<Integer>> ans , List<Integer> list , int start){
        ans.add(new ArrayList<>(list));
        for(int i = start ; i < nums.length ; i++){
            list.add(nums[i]);
            helper1(nums , ans , list , i + 1);
            list.remove(list.size() - 1);
        }
    }
}