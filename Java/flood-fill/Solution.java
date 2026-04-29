class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColour = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;

        if (oldColour == color) return image;

        dfs(image,rows,cols,sr,sc,color,oldColour);
        return image;
    }

    public void dfs(int[][] image , int rows , int cols, int sr , int sc , int newColour , int oldColour){
        
        //Base case
        if(sr<0 || sc<0 || sr>=rows || sc>=cols || image[sr][sc] != oldColour){
           return;
        }
        

        image[sr][sc] = newColour; //Update the colour

        //Call for the adjacent nodes
        dfs(image,rows,cols,sr+1,sc,newColour,oldColour);
        dfs(image,rows,cols,sr-1,sc,newColour,oldColour);
        dfs(image,rows,cols,sr,sc+1,newColour,oldColour);
        dfs(image,rows,cols,sr,sc-1,newColour,oldColour);

        
        return;

    }
}