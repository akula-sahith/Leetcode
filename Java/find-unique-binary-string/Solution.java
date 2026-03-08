class Solution {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        HashSet<String> allStrings = helper("", new HashSet<>(), n);

        for (String s : nums) {
            allStrings.remove(s);
        }

        for (String s : allStrings) {
            return s;
        }

        return "";
    }

    public HashSet<String> helper(String curr, HashSet<String> set, int n) {

        if (curr.length() == n) {
            set.add(curr);
            return set;
        }

        for (int i = 0; i <= 1; i++) {
            set = helper(curr + (char)(i + '0'), set, n);
        }

        return set;
    }
}