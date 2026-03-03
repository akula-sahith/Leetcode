class Solution {
    public int sumSubarrayMins(int[] arr) {
        // return bruteforce(arr);
        return opt(arr);
    }

    //My Brute Force approach is to find all subarray and find min of them
    public int bruteforce(int[] arr){
        int sum = 0;
        int n = arr.length;
        // for(int num : arr){
        //     sum += num;
        // }
        for(int i = 0;i<n;i++){
            int min = arr[i];
            for(int j = i;j<n;j++){
               min = Math.min(min , arr[j]);
               sum += min;
            }
        }
        return sum;
    }

    //Optimized approach
    public int opt(int[] arr){
          int n = arr.length;
        long mod = 1_000_000_007;
        long result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() && 
                   (i == n || arr[stack.peek()] > arr[i])) {

                int mid = stack.pop();

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int rightBoundary = i;

                long left = mid - leftBoundary;
                long right = rightBoundary - mid;

                result = (result + 
                         (arr[mid] * left % mod) * right % mod) % mod;
            }

            stack.push(i);
        }

        return (int) result;
    }
}