class Solution {
    public int bitwiseComplement(int n) {
        String number = Integer.toBinaryString(n);
        String complement = "";

        for(int i = 0 ; i < number.length() ; i++){
            if(number.charAt(i) == '1'){
               complement = complement + '0';
            }else{
               complement = complement + '1';
            }
        }

        return Integer.parseInt(complement , 2);
    }
}