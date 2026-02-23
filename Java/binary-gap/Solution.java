class Solution {
    public int binaryGap(int n) {
        int max = Integer.MIN_VALUE;
        int last_one = -1;
        String s = Integer.toBinaryString(n);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(last_one == -1){
                    last_one = i;
                }else{
                    int dist = i - last_one;
                    System.out.println(dist);
                    max = (dist > max) ? dist : max;
                    System.out.println(max);
                    last_one = i;
                }
            }
        }

        if(max == Integer.MIN_VALUE){
            return 0;
        }

        return max;
    }
}