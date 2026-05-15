class Solution {
    public int climbStairs(int n) {
        return helper(n,0,new HashMap<Integer,Integer>());
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
}