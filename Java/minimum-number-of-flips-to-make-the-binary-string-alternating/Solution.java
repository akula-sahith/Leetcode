class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String t = s + s;

        int alt1 = 0;
        int alt2 = 0;

        int res = Integer.MAX_VALUE;

        int left = 0;

        for(int right = 0; right < t.length(); right++){

            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if(t.charAt(right) != expected1) alt1++;
            if(t.charAt(right) != expected2) alt2++;

            if(right - left + 1 > n){

                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if(t.charAt(left) != leftExpected1) alt1--;
                if(t.charAt(left) != leftExpected2) alt2--;

                left++;
            }

            if(right - left + 1 == n){
                res = Math.min(res, Math.min(alt1, alt2));
            }
        }

        return res;
    }
}