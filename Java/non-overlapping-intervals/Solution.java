class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int min_count = 0;
        Arrays.sort(intervals , (a,b) -> a[1] - b[1]);
        int last_index = intervals[0][1];
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] < last_index){
                min_count++;
            }else{
            last_index = intervals[i][1];
            }
        }
        return min_count;
    }
}