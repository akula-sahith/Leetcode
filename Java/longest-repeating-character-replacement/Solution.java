class Solution {
    public int characterReplacement(String s, int k) {
        HashMap< Character , Integer > map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;

        int maxFreq = Integer.MIN_VALUE;

        int left = 0;

        for(int right = 0 ; right < s.length() ; right++){
           char ch = s.charAt(right);
           map.put(ch , map.getOrDefault(ch,0) + 1);
           if(map.get(ch) > maxFreq){
             maxFreq = map.get(ch);
           }
           int length = right - left + 1;
           int ops_req = length - maxFreq;

           if(ops_req <= k){
            maxLen = Math.max(maxLen, length);
           }else{
             char left_char = s.charAt(left);
             map.put(left_char , map.getOrDefault(left_char,0) - 1);
             left++;
           }
           
        }

        return maxLen;
    }
}