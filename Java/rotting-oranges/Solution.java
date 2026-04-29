class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return bfs(grid,m,n);
    }

    public int bfs(int[][] grid,int m,int n){
        int time = -1;
        int fresh = countFresh(grid,m,n);
        Queue<int[]> queue = new LinkedList<>();
        
        if(fresh==0){
            return 0;
        }

        //Add all the rotten oranges into the queue
         for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        if(queue.isEmpty()){
           return -1;
        }

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0 ; i < size ; i++){
              int[] popped = queue.poll();
              int row = popped[0];
              int col = popped[1];
              
              //Check for all the 4 directions for the adjacent fresh oranges
              for(int[] arr : directions){
                 int newRow = row + arr[0];
                 int newCol = col + arr[1];
                 if(newRow>=0 && newCol>=0 && newRow<m && newCol<n &&
                    grid[newRow][newCol]==1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.add(new int[]{newRow,newCol});
                    }
              }
            }

            time++;
            
        }

        if(fresh==0){
            return time;
        }else{
            return -1;
        }
    }

    public int countFresh(int[][] grid,int m,int n){
        int fresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        return fresh;
    }
}