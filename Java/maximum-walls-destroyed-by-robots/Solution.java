import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        
        // Pair robots' positions with their corresponding distances
        int[][] R = new int[n][2];
        for (int i = 0; i < n; i++) {
            R[i][0] = robots[i];
            R[i][1] = distance[i];
        }
        // Sort robots by position
        Arrays.sort(R, (a, b) -> Integer.compare(a[0], b[0]));
        
        Arrays.sort(walls);
        int baseAns = 0;
        List<Integer> filtered = new ArrayList<>();
        
        // Walls exactly at a robot's position are guaranteed to be destroyed
        for (int w : walls) {
            if (isRobotAt(R, w)) {
                baseAns++;
            } else {
                filtered.add(w);
            }
        }
        
        // Convert filtered list back to array for efficient binary search
        int[] filteredWalls = new int[filtered.size()];
        for (int i = 0; i < filtered.size(); i++) {
            filteredWalls[i] = filtered.get(i);
        }

        // Base case: first interval strictly ending before the 0-th robot
        // This counts walls hit by the first robot firing Left
        int prev0 = countIn(filteredWalls, R[0][0] - R[0][1], R[0][0] - 1);
        int prev1 = 0; // Represents state where previous robot fired Right
        
        // DP transitions on adjacent pair intervals
        for (int i = 1; i < n; i++) {
            int xPrev = R[i - 1][0], dPrev = R[i - 1][1];
            int xCurr = R[i][0], dCurr = R[i][1];
            
            int aLen = countIn(filteredWalls, xPrev + 1, xCurr - 1);
            int p = countIn(filteredWalls, xPrev + 1, Math.min(xCurr - 1, xPrev + dPrev));
            int s = countIn(filteredWalls, Math.max(xPrev + 1, xCurr - dCurr), xCurr - 1);
            
            // curr0: Max unique walls destroyed up to robot i, robot i fires Left (or is neutral)
            // If i-1 fired Right (prev1) and i fires Left (s), 
            // the unique walls in the gap is min(total_gap, walls_from_left + walls_from_right)
            int curr0 = Math.max(prev0 + s, prev1 + Math.min(aLen, p + s));
            
            // curr1: Max unique walls destroyed up to robot i, robot i fires Right
            int curr1 = Math.max(prev0, prev1 + p);
            
            prev0 = curr0;
            prev1 = curr1;
        }
        
        // Final interval: walls hit by the last robot firing Right
        int lastRightCount = countIn(filteredWalls, R[n - 1][0] + 1, R[n - 1][0] + R[n - 1][1]);
        
        return baseAns + Math.max(prev0, prev1 + lastRightCount);
    }

    // Helper to check if a robot exists at position w
    private boolean isRobotAt(int[][] R, int w) {
        int low = 0, high = R.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (R[mid][0] == w) return true;
            if (R[mid][0] < w) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    // Efficiency: count walls in range [L, R_val] using binary search
    private int countIn(int[] walls, int L, int R_val) {
        if (L > R_val) return 0;
        
        // Find first element >= L
        int start = Arrays.binarySearch(walls, L);
        if (start < 0) start = -(start + 1);
        
        // Find first element > R_val
        int end = Arrays.binarySearch(walls, R_val);
        if (end < 0) end = -(end + 1);
        else end++; // If found, we want the index after it
        
        return end - start;
    }
}