class Solution {
    public int maxProfit(int[] prices) {
        return solution(prices);
    }

    //Solution using the calculating the left and right profits
    public int solution(int[] prices){
        int[] left = new int[prices.length];
        left[0] = 0;
        int buy = prices[0];
        int profit = 0;
        for(int i = 1 ; i < prices.length ; i++){
            if (prices[i] < buy){
                buy = prices[i];
            }else{
                profit = Math.max(profit , prices[i] - buy);
            }
            left[i] = profit;
        }

        int[] right = new int[prices.length];
        right[prices.length - 1] = 0;
        int maxPrice = prices[prices.length - 1];
        profit = 0;
        for(int i = prices.length - 2 ; i>=0 ; i--){
            if(prices[i] > maxPrice){
                maxPrice = prices[i];
            }else{
                profit = Math.max(profit , maxPrice - prices[i]);
            }
            right[i] = profit;
        }

        //Calculating the total profit
        int total_profit = 0;
        for(int i = 0 ; i < prices.length ; i++){
            total_profit = Math.max(total_profit , left[i] + right[i]);
        }

        return total_profit;
    }
}