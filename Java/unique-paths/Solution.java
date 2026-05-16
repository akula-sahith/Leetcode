class Solution {
    public int uniquePaths(int m, int n) {
        // return recursion(0,0,m,n);
        return topdown(0,0,m,n,new HashMap<String,Integer>());
    }

    //Plain recursion
    public int recursion(int i,int j,int m,int n){
        //Base Case 1 -> Reached Destination
        if(i==(m-1)&&j==(n-1)){
            return 1;
        }
        //Base Case 2 -> Out of Bounds
        if(i>=m || j>=n){
            return 0;
        }

        //Now explore both the ways
        int down = recursion(i+1,j,m,n);
        int right = recursion(i,j+1,m,n);

        return down + right;
    }

    //Recursion + Memoization -> Top Down Approach
    public int topdown(int i,int j,int m,int n,HashMap<String,Integer> map){
        if(i==(m-1) && j==(n-1)){
            return 1;
        }

        if(i>=m || j>=n){
            return 0;
        }

        String key = i + "," + j;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int down = topdown(i+1,j,m,n,map);
        int right = topdown(i,j+1,m,n,map);
        int count = down + right;
        String ansKey = i + "," + j;
        map.put(ansKey,count);
        return count;
    }
}