class Solution {
    public int maxDistance(int[] position, int m) {
        int left = 1;
        Arrays.sort(position);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int pos : position){
           min = Math.min(pos , min);
           max = Math.max(pos , max);
        }

        int right = max - min;

        while(left < right){
            int mid = left + (right - left + 1)/2;
            if(canPlace(position , m , mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    public boolean canPlace(int[] positions,int m,int dist){
        int placed_balls = 1;
        int last_placed = positions[0];
        for(int i = 1;i<positions.length;i++){
            if(positions[i] - last_placed >= dist){
                last_placed = positions[i];
                placed_balls++;
            }
        }

        return placed_balls >= m;
    }
}