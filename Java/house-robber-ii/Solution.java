class Solution {
    public int rob(int[] arr) {
        
        if(arr.length == 1){
            return arr[0];
        }

        return Math.max(findMaxSum(arr , 0 , arr.length - 1, new HashMap<Integer , Integer>()),
               findMaxSum(arr , 1 , arr.length ,new HashMap<Integer , Integer>()));
    }
    int findMaxSum(int[] arr , int i , int end , HashMap < Integer , Integer > map){
        if (i >= end){
            return 0;
        }
        
        if(map.containsKey(i)){
            return map.get(i);
        }
        
        int rob = arr[i] + findMaxSum(arr , i + 2, end , map);
        int skip = findMaxSum(arr , i + 1,end , map);
        
        map.put(i , Math.max(rob , skip));
        
        return Math.max(rob , skip);
    }
}