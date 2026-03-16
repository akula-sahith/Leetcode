class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]);
                if (set.size() > 3) set.pollFirst();

                for (int k = 1; r-k >= 0 && r+k < m && c-k >= 0 && c+k < n; k++) {

                    int sum = 0;

                    for (int i = 0; i < k; i++) {
                        sum += grid[r-k+i][c+i];
                        sum += grid[r+i][c+k-i];
                        sum += grid[r+k-i][c-i];
                        sum += grid[r-i][c-k+i];
                    }

                    set.add(sum);
                    if (set.size() > 3) set.pollFirst();
                }
            }
        }

        int size = set.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[i] = set.pollLast();   // largest first
        }

        return res;
    }
}