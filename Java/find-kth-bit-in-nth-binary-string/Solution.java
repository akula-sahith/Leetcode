class Solution {
    public char findKthBit(int n, int k) {
        String curr = "0";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(curr);
            sb.append("1");
            sb.append(new StringBuilder(complement(curr)).reverse());
            curr = sb.toString();
        }

        return curr.charAt(k - 1);
    }

    private String complement(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}