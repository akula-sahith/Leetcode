class Solution {
    public int longestBalanced(int[] nums) {
        return solution(nums);
    }

    //Brute Force Solution
    public int solution(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> odds = new HashSet<>();
            HashSet<Integer> evens = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evens.add(nums[j]);
                } else {
                    odds.add(nums[j]);
                }

                if (odds.size() == evens.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
