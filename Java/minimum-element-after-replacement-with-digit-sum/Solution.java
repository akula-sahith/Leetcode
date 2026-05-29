class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            int s = sum(num);
            if(min > s){
                min = s;
            }
        }
        return min;
    }
    public int sum(int num){
        int sum = 0;
        while(num > 0){
            int re = num % 10;
            sum += re;
            num = num / 10;
        }
        return sum;
    }
}