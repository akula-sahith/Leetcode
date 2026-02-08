class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffleArray = new int[nums.length];
        int h = 0;
        for (int i = 0, j = n; i < n && j < 2 * n; i++, j++) {
           
           shuffleArray[h] = nums[i];
           h++;
           shuffleArray[h] = nums[j];
           h++;
        }

        return shuffleArray;
    }
}