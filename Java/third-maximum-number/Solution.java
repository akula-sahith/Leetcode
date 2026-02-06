class Solution {
    public int thirdMax(int[] nums) {

        int first_max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        int third_max = Integer.MIN_VALUE;

        boolean first_updated = false;
        boolean second_updated = false;
        boolean third_updated = false;

        // Find first max
        for (int n : nums) {
            if (!first_updated || n > first_max) {
                first_max = n;
                first_updated = true;
            }
        }

        // Find second max
        for (int n : nums) {
            if (n != first_max && (!second_updated || n > second_max)) {
                second_max = n;
                second_updated = true;
            }
        }

        // Find third max
        for (int n : nums) {
            if (n != first_max && n != second_max &&
                (!third_updated || n > third_max)) {
                third_max = n;
                third_updated = true;
            }
        }

        // Decide result
        return third_updated ? third_max : first_max;
    }
}
