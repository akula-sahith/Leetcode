class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bot = x + k - 1;
        while(top < bot){
            int col = y + k - 1;
            for(int i = y ; i <= col ; i++){
                int temp = grid[top][i];
                grid[top][i] = grid[bot][i];
                grid[bot][i] = temp;
            }
            top++;
            bot--;
        }
        System.out.println(Arrays.toString(grid));
        return grid;
    }
}