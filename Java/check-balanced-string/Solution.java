class Solution {
    public boolean isBalanced(String num) {
        int even_sum = 0;
        int odd_sum = 0;

        for(int i = 0 ; i < num.length() ; i++){
            if( i % 2 == 0){
                even_sum += num.charAt(i) - '0';
            }else{
                odd_sum += num.charAt(i) - '0';
            }
        }

        return even_sum == odd_sum;
    }
}