class Solution {
    public boolean hasAlternatingBits(int n) {
        String num = Integer.toBinaryString(n);
        boolean changed = false;
        char prev = num.charAt(0);
        for(int i = 1;i<num.length();i++){
            if(prev==num.charAt(i)){
                return false;
            }
            prev = num.charAt(i);
        }
        return true;
    }
}