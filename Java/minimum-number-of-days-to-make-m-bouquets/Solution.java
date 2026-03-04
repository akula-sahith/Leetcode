class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length){
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int day : bloomDay){
            left = Math.min(left , day);
            right = Math.max(right , day);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(canMake2(bloomDay,m,k,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canMake(int[] bloomDay,int m,int k,int days){
        int boques_made = 0;
        int each_boque = k;
        int last_used = 0;
        boolean fresh_boque = true;
        for(int i = 0;i<bloomDay.length;i++){
            if(bloomDay[i] <= days){
              if(fresh_boque){
                each_boque--;
                fresh_boque = false;
                last_used = i;
              }else{
                if((i - 1)==last_used){
                    each_boque--;
                    last_used = i;
                }
              }
              
              if(each_boque == 0){
                boques_made++;
                fresh_boque = true;
                each_boque = k;
              }
            }else{
                each_boque = k;
                fresh_boque = true;
            }
        }

        return boques_made >= m;
    }


    //This is one more can make function
    public boolean canMake2(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int flowers = 0;

        for (int d : bloomDay) {

            if (d <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}