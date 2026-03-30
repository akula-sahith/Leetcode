class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = 0 ; 
        int second = 0;

        int k = 0;

        //Take an array of nums1

        int[] nums1_dup = new int[m];

        for(int i = 0 ; i < m ; i++){
            nums1_dup[i] = nums1[i];
        }

        while(first < m && second < n){
            if(nums1_dup[first] < nums2[second]){
                nums1[k] = nums1_dup[first];
                first++;
            }else{
                nums1[k] = nums2[second];
                second++;
            }
            k++;
        }

        while(first < m){
            nums1[k] = nums1_dup[first];
                first++;
               k++; 
        }

        while(second < n){
             nums1[k] = nums2[second];
                second++;
               k++; 
        }


    }
}