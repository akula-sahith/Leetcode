class Solution {
    public int reverseBits(int n) {
        String bin = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        String reversed = new StringBuilder(bin).reverse().toString();
        // System.out.println(bin);
        return Integer.parseInt(reversed,2);
        // return 0;'
    }
}