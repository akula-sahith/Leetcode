class Solution {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int countLessEqual(int[][] matrix, int x) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;

        // Start from the bottom-left corner of the matrix
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= x) {
                // If the current element is <= x, all elements in the current row
                // before this element are also <= x
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    public static int heapapproach(int[][] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                pq.offer(nums[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }


}