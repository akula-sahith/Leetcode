import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        HashMap<Character,Integer> required_chars = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            required_chars.put(ch, required_chars.getOrDefault(ch,0) + 1);
        }

        HashMap<Character,Integer> builded = new HashMap<>();

        int required = required_chars.size();
        int formed = 0;

        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);
            builded.put(c, builded.getOrDefault(c,0) + 1);

            if(required_chars.containsKey(c) &&
               builded.get(c).intValue() == required_chars.get(c).intValue()){
                formed++;
            }

            while(formed == required){

                int len = right - left + 1;

                if(len < min){
                    min = len;
                    start = left;
                }

                char left_char = s.charAt(left);

                builded.put(left_char, builded.get(left_char) - 1);

                if(required_chars.containsKey(left_char) &&
                   builded.get(left_char) < required_chars.get(left_char)){
                    formed--;
                }

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}