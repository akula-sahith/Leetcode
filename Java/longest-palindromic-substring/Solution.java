class Solution {
    public String longestPalindrome(String s) {
        return solution(s);
    }

    
   
    public String solution(String s){
        int start = 0;
        int end = 0;
        int len = Integer.MIN_VALUE;
        for(int i = 0;i<s.length();i++){
            int odd_len = expand(s , i , i);
            int even_len = expand(s , i , i + 1);
            len = Math.max(odd_len , even_len);
            
            if(len > (end - start)){
                start = (i - ((len - 1)/2));
                end = (i + len/ 2);
            }
        }
        return s.substring(start,end+1);
    }

    public int expand(String s, int left , int right){
        while(left >= 0 &&
              right < s.length() &&
              s.charAt(left) == s.charAt(right)){
                left--;
                right++;
              }

              return right - left - 1;
    }
}