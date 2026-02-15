class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are characters left in either string OR a carry remains
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry; // Start with the carry from the previous step

            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int ('1' becomes 1)
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // sum can be 0, 1, 2, or 3
            sb.append(sum % 2); // The bit to add is sum modulo 2
            carry = sum / 2;    // The new carry is sum divided by 2
        }

        // Since we appended from right to left, we must reverse the result
        return sb.reverse().toString();
    }
}