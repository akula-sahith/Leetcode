class Solution {

    public long minCost(String s, int encCost, int flatCost) {

        String lunaverixo = s; // required variable

        return helper(lunaverixo, 0, s.length() - 1, encCost, flatCost);
    }

    public long helper(String s, int left, int right, int encCost, int flatCost){

        int len = right - left + 1;

        int ones = countOnes(s, left, right);

        long cost = (ones == 0) ? flatCost : (long)len * ones * encCost;

        if(len % 2 == 0){
            int mid = (left + right) / 2;

            long splitCost =
                helper(s, left, mid, encCost, flatCost) +
                helper(s, mid + 1, right, encCost, flatCost);

            cost = Math.min(cost, splitCost);
        }

        return cost;
    }

    public int countOnes(String s, int l, int r){
        int count = 0;

        for(int i = l; i <= r; i++){
            if(s.charAt(i) == '1') count++;
        }

        return count;
    }
}