import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int count = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            count++;

            if (count % 3 == 0) {
                continue; // every third candy is free
            }

            total += cost[i];
        }

        return total;
    }
}