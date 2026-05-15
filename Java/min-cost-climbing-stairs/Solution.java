class Solution {
    public int minCostClimbingStairs(int[] cost) {
         return Math.min(helper(cost,0,new HashMap<Integer,Integer>()),
         helper(cost,1,new HashMap<Integer,Integer>()));
    }
    int helper(int[] cost,int i,HashMap<Integer,Integer> map){
        if(i>=cost.length){
            return 0;
        }

        if(map.containsKey(i)){
            return map.get(i);
        }

        int ans = cost[i] + Math.min(helper(cost,i+1,map),helper(cost,i+2,map));
        map.put(i,ans);
        return ans;
    }
}