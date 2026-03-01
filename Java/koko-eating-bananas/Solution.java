class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        int left = 1;
        for(int pile : piles){
            right = Math.max(right , pile);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if(canFinish(piles,mid,h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canFinish(int[] piles,int k,int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile + k - 1)/k;
        }
        return hours<=h;
    }
}