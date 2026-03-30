class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        // int[][] org = mat;

        int[][] org = new int[mat.length][mat[0].length];

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                org[i][j] = mat[i][j];
            }
        }


        for(int h = 1 ; h <= k ; h++){
            perform(mat);
        }

        return check(org , mat);

    }

    public void perform(int[][] mat){
        for(int i = 0 ; i < mat.length ; i++){
            if(i % 2 == 0){
                leftShift(mat , i);
            }else{
                rightShift(mat , i);
            }
        }
    }

    public void leftShift(int[][] mat , int i){
        for(int j = 0 ; (j + 1) < mat[0].length ; j++){
            int temp = mat[i][j];
            mat[i][j] = mat[i][j + 1];
            mat[i][j + 1] = temp;
        }
    }

    public void rightShift(int[][] mat , int i){
         for(int j =  mat[0].length - 1 ; (j - 1) >= 0 ; j--){
            int temp = mat[i][j];
            mat[i][j] = mat[i][j - 1];
            mat[i][j - 1] = temp;
        }
    }

    public boolean check(int[][] org , int[][] mat){
        boolean ans = true;

        for(int i = 0 ; i < org.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(org[i][j] != mat[i][j]){
                    return false;
                }
            }
        }

        return ans;
    }
}