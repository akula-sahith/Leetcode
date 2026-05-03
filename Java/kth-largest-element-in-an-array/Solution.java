class Solution {
    public int findKthLargest(int[] nums, int k) {
    // PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    //     for(int i = 0;i<nums.length;i++){
    //         queue.add(nums[i]);
    //     }

    //     while(k > 1){
    //        int ele = queue.poll();
    //        System.out.println(ele);
    //        k--;
    //     }

    //     return queue.poll();
    return approach2(nums,k);
    }

    public int approach2(int[] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length ; i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}