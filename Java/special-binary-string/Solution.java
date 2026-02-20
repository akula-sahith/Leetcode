class Solution {
    public String makeLargestSpecial(String s) {
        List<String> blocks = new ArrayList<>();
        int count = 0;
        int start = 0;

        // Split into primitive special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) {
                // Recursively solve inside part
                String inner = s.substring(start + 1, i);
                String largestInner = makeLargestSpecial(inner);
                
                blocks.add("1" + largestInner + "0");
                start = i + 1;
            }
        }

        // Sort in descending order
        Collections.sort(blocks, Collections.reverseOrder());

        // Join them
        StringBuilder result = new StringBuilder();
        for (String block : blocks) {
            result.append(block);
        }

        return result.toString();
    }
}