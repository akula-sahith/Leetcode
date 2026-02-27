class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i<nums.length;i++){
            queue.add(nums[i]);
        }

        while(k > 1){
           int ele = queue.poll();
           System.out.println(ele);
           k--;
        }

        return queue.poll();
    }
}