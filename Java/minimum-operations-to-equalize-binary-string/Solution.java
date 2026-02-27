import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') z++;
        }

        if (z == 0) return 0;

        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i == z) continue;
            if (i % 2 == 0) even.add(i);
            else odd.add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(z);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == 0) return steps;

                int minI = Math.max(0, k - (n - curr));
                int maxI = Math.min(k, curr);

                int L = curr + k - 2 * maxI;
                int R = curr + k - 2 * minI;

                TreeSet<Integer> target =
                        ((curr + k) % 2 == 0) ? even : odd;

                Integer next = target.ceiling(L);

                while (next != null && next <= R) {
                    q.add(next);
                    target.remove(next);
                    next = target.ceiling(L);
                }
            }
            steps++;
        }

        return -1;
    }
}