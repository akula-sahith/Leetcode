class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Check even indices: {0, 2}
        // They match if (s1[0]==s2[0] and s1[2]==s2[2]) OR (s1[0]==s2[2] and s1[2]==s2[0])
        boolean evenMatch = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                            (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));
        
        // Check odd indices: {1, 3}
        // They match if (s1[1]==s2[1] and s1[3]==s2[3]) OR (s1[1]==s2[3] and s1[3]==s2[1])
        boolean oddMatch = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                           (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
        
        return evenMatch && oddMatch;
    }
}