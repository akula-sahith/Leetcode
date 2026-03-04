class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[i].length;j++){
                if(mat[i][j] == 1){
                    if(checkSpecial(mat ,i , j , mat.length , mat[i].length)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean checkSpecial(int[][] arr,int row,int column,int m,int n){
        int row_count = 0;
        int col_count = 0;
        for(int i = 0;i<n;i++){
            if(arr[row][i]==1){
                row_count++;
            }
        }

         for(int i = 0;i<m;i++){
            if(arr[i][column]==1){
                col_count++;
            }
        }

        return row_count == 1 && col_count == 1;
    }
}