class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num : nums){
            processDigits(num,ans);
        }

         int[] arr = ans.stream().mapToInt(i -> i).toArray();
         return arr;
    }

    public void processDigits(int number , ArrayList<Integer> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        while(number!=0){
            int rem = number % 10;
            temp.add(rem);
            number = number / 10;
        }

        for(int i = temp.size() - 1 ; i>=0 ; i--){
            ans.add(temp.get(i));
        }
    }
}