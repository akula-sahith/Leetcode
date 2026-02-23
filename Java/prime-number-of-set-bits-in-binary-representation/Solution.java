class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left;i<=right;i++){
            // int count bin = Integer.toBinaryString(i);
            if(checkPrime(countOnes(Integer.toBinaryString(i)))){
                ans++;
            }
        }
        return ans;
    }

    //To check if primt
    public boolean checkPrime(int n){
        if(n < 2) return false;
        int i = 2;
        while(i * i <= n){
            if(n % i == 0){
                return false;
            }
            i = i + 1;
        }
        return true;
    }

    //Function to count ones in String
    public int countOnes(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}