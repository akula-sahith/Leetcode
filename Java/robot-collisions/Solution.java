import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the position of robots
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                // Robot moving Left: check for collisions with robots moving Right in the stack
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.peek();

                    if (healths[currentIndex] > healths[topIndex]) {
                        // Current (L) wins
                        healths[topIndex] = 0;
                        healths[currentIndex] -= 1;
                        stack.pop();
                    } else if (healths[currentIndex] < healths[topIndex]) {
                        // Stack top (R) wins
                        healths[currentIndex] = 0;
                        healths[topIndex] -= 1;
                    } else {
                        // Both destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                        stack.pop();
                    }
                }
            }
        }

        // Collect healths of survivors in the original input order
        List<Integer> result = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) {
                result.add(h);
            }
        }
        return result;
    }
}