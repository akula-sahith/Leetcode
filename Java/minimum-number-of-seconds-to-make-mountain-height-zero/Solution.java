class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        return bs(workerTimes, mountainHeight);
    }

    public long bs(int[] workerTimes, int mountainHeight){

        long left = 1;
        long right = (long)1e18;

        while(left < right){

            long mid = left + (right - left)/2;

            if(canComplete(mid, workerTimes, mountainHeight)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

   public boolean canComplete(long time, int[] workerTimes, int mountainHeight){

    long total = 0;

    for(int t : workerTimes){

        long val = (2 * time) / t;

        long k = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);

        total += k;

        if(total >= mountainHeight){
            return true;
        }
    }

    return false;
}

}
