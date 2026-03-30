class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        // Arrays to store counts for characters at even and odd indices
        int[] evenCounts = new int[26];
        int[] oddCounts = new int[26];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // For even indices, increment for s1 and decrement for s2
                evenCounts[s1.charAt(i) - 'a']++;
                evenCounts[s2.charAt(i) - 'a']--;
            } else {
                // For odd indices, increment for s1 and decrement for s2
                oddCounts[s1.charAt(i) - 'a']++;
                oddCounts[s2.charAt(i) - 'a']--;
            }
        }

        // If s1 and s2 are transformable, all counts must be zero
        for (int i = 0; i < 26; i++) {
            if (evenCounts[i] != 0 || oddCounts[i] != 0) {
                return false;
            }
        }

        return true;
    }
}