class Solution {

    public int numSteps(String s) {
       return numSteps2(s);
    }
    

    //Brute Force Approach
    public int numSteps1(String s) {
        int count = 0;
        while(Integer.parseInt(s,2)!=1){
            count++;
            int num = Integer.parseInt(s,2);
            if(num % 2 == 0){
                num = num / 2;
            }else{
                num = num + 1;
            }
            s = Integer.toBinaryString(num);
        }
        return count;
    }

    //Optimized approach using Bit Manipulation
    public int numSteps2(String s){
        int steps = 0;
        int carry = 0;
        for(int i = (s.length() -1);i>0;i--){
            int bit = (s.charAt(i) - '0') + carry;
            if(bit == 1){
                steps += 2;
                carry = 1;
            }else{
                steps += 1;
            }
        }
        return steps + carry;
    }
}