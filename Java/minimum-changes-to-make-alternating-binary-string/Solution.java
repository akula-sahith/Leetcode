class Solution {
    public int minOperations(String s) {
        int m1 = 0;
        int m2 = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(i%2==0 && s.charAt(i) != '1'){
                m1++;
            }else if(i%2!=0 && s.charAt(i)!='0'){
                m1++;
            }
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(i%2==0 && s.charAt(i) != '0'){
                m2++;
            }else if(i%2!=0 && s.charAt(i) != '1'){
                m2++;
            }
        }

        return Math.min(m1 , m2);
    }
}