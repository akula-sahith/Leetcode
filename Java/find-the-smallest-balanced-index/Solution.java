class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long[] left = new long[nums.length + 1];
        long[] right = new long[nums.length + 1];
        left[0] = 0;
        right[0] = 1;
        
        long prefix_sum = 0;
        for(int i = 1 ; i < left.length ; i++){
            prefix_sum += nums[i - 1];
            left[i] = prefix_sum;
        }

       long prefix_product = 1;
int insert_pos = 1;

for(int i = nums.length - 1 ; i >= 0 ; i--){

    if(prefix_product > Long.MAX_VALUE / nums[i]){
        prefix_product = Long.MAX_VALUE;
    }else{
        prefix_product *= nums[i];
    }

    right[insert_pos] = prefix_product;
    insert_pos++;
}

        int index = -1;
        for(int i = 0 ; i < nums.length ; i++){
            long left_sum = left[i];
            long right_product = right[nums.length - i - 1];
            if(i == 0){
                System.out.println(left_sum + " " + right_product);
            }
            if(left_sum == right_product){
                index = i;
            }
        }

        return index;
        
        
    }
}