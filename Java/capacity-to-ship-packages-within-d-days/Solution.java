class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
int right = 0;

for (int w : weights) {
    left = Math.max(left, w);  // max weight
    right += w;               // total sum
}

        while(left < right){
            int mid = left + (right - left)/2;
            if(canSend(weights,mid,days)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canSend(int[] weights,int capacity,int days){
        int usedDays = 1;
        int currentCapacity = 0;
        for(int weight : weights){
            if(currentCapacity + weight > capacity){
                usedDays++;
                currentCapacity = 0;
            }
            currentCapacity += weight;
        }
        return usedDays <= days;
    }
}