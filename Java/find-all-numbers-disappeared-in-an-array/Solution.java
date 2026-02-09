class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> missing = new ArrayList<>();
        HashSet<Integer> given_nums = new HashSet<>();
        for (int num :  nums) {
    given_nums.add(num);
}
        
        //int[] check_nums = new int[nums.length];
        for(int i = 1;i<=nums.length;i++){
            if(!given_nums.contains(i)){
                missing.add(i);
            }
        }
        return missing;
        
    }
}