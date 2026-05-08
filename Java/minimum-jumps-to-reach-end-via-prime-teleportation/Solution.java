import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // Removed the stray semicolon

        int maxVal = 0;
        for (int num : nums) maxVal = Math.max(maxVal, num);

        // 1. Sieve to find Smallest Prime Factor (SPF)
        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= maxVal; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }

        // 2. Map primes to indices (Buckets)
        // primeBuckets[p] stores all indices i where nums[i] is divisible by p
        List<Integer>[] primeBuckets = new ArrayList[maxVal + 1];
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (temp > 1) {
                int p = spf[temp];
                if (primeBuckets[p] == null) primeBuckets[p] = new ArrayList<>();
                primeBuckets[p].add(i);
                while (temp % p == 0) temp /= p;
            }
        }

        // 3. BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        boolean[] visitedIndices = new boolean[n];
        boolean[] visitedPrimes = new boolean[maxVal + 1];
        visitedIndices[0] = true;
        
        int jumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currIdx = queue.poll();
                
                if (currIdx == n - 1) return jumps;

                // Move to adjacent indices
                int[] neighbors = {currIdx - 1, currIdx + 1};
                for (int nextIdx : neighbors) {
                    if (nextIdx >= 0 && nextIdx < n && !visitedIndices[nextIdx]) {
                        visitedIndices[nextIdx] = true;
                        queue.offer(nextIdx);
                    }
                }

                // Teleport via Prime Factors
                // The problem states: if nums[currIdx] is a prime p, jump to any j where nums[j]%p == 0
                int val = nums[currIdx];
                if (val > 1 && spf[val] == val) { // Check if current number is prime
                    int p = val;
                    if (!visitedPrimes[p]) {
                        visitedPrimes[p] = true;
                        if (primeBuckets[p] != null) {
                            for (int targetIdx : primeBuckets[p]) {
                                if (!visitedIndices[targetIdx]) {
                                    visitedIndices[targetIdx] = true;
                                    queue.offer(targetIdx);
                                }
                            }
                            // Optimization: Clear bucket after visiting to avoid re-scanning
                            primeBuckets[p] = null; 
                        }
                    }
                }
            }
            jumps++;
        }

        return -1;
    }
}