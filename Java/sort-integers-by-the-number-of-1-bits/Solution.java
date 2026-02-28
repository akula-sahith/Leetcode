class Solution {
    public int[] sortByBits(int[] arr) {
        return sortBits(arr);
    }

    // Brute force approach is to count the number of ones in each binary string and arrange in ascending order

    //Arrange the Binary Strings in the ascending order
    public int[] sortBits(int[] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = (i + 1);j<arr.length;j++){
                // String bin1 = Integer.toBinaryString(arr[i]);
                // String bin2 = Integer.toBinaryString(arr[j]);
                if(countOnes(arr[i]) > countOnes(arr[j]) || (countOnes(arr[j])==countOnes(arr[i])&&arr[i]>arr[j])){
                   int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
                }
            }
        }
        return arr;
    }

      public int countOnes(int num){
        int count = 0;
        while(num > 0){
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}