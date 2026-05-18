class Solution {
    public int climbStairs(int n) {
        // return helper(n,0,new HashMap<Integer,Integer>());
        return bottomUp(n);
    }

    //Helper function
    public int helper(int n,int i,HashMap<Integer,Integer> map){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }

        if(map.containsKey(i)){
            return map.get(i);
        }

        int ans = helper(n,i+1,map) + helper(n,i+2,map);
        map.put(i,ans);
        return ans;

    }

    //Bottom Up Approach
    public int bottomUp(int n){
        int[] dp = new int[n+2];
        dp[n] = 1;
        // dp[n-1] = 1;
        for(int i = n - 1 ; i >=0 ; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];

    }
}