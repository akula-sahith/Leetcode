class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,m,n,grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int sr,int sc,int m,int n,char[][] grid){

        //Base case
        if(sr<0 || sc<0 || sr>=m || sc>=n || grid[sr][sc]!='1'){
            return;
        }

        grid[sr][sc] = '0';

        dfs(sr+1,sc,m,n,grid);
        dfs(sr-1,sc,m,n,grid);
        dfs(sr,sc+1,m,n,grid);
        dfs(sr,sc-1,m,n,grid);
    }
}