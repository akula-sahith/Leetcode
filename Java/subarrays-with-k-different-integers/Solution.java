class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums , k) - atmost(nums , (k - 1));
    }

      static int atmost(int[] arr , int k){
        HashMap < Integer , Integer > map = new HashMap<>();
        int left = 0;
        int count = 0;
        
        for(int right = 0 ; right < arr.length ; right++){
            map.put(arr[right] , map.getOrDefault(arr[right],0) + 1);
            
            while(map.size() > k){
                map.put(arr[left] , map.getOrDefault(arr[left],0) - 1);
                
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                
                left++;
            }
            
            count += (right - left + 1);
        }
        
        return count;
    }
}