class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // return smallerNumber(nums);
        return solution2(nums);
    }

    //Brute force Solution
    public int[] smallerNumber(int[] nums){
        int[] arr = nums;
    //Lets create a hashmap to find out the numbers
HashMap<Integer,Integer> map = new HashMap<>();
    int[] dups = new int[nums.length];
    for(int i = 0;i<dups.length;i++){
        dups[i] = nums[i];
        map.put(nums[i],0);
    }
    

       Arrays.sort(arr); // ascending

for (int i = 0; i < arr.length / 2; i++) {
    int temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
} 

  int[] ans = new int[nums.length];

  for(int i = 0;i<arr.length;i++){
    int count = nums.length - 1 - i;
    map.put(arr[i],count);
  }

  for(int i = 0;i<nums.length;i++){
    ans[i] = map.get(dups[i]);
  }

   return ans;

  
    }

    public int[] solution2(int[] nums){
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // ascending

        HashMap<Integer, Integer> map = new HashMap<>();

        // First occurrence index = count of smaller numbers
        for (int i = 0; i < sorted.length; i++) {
            map.putIfAbsent(sorted[i], i);
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }

        return ans;
    }
}