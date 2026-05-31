class Solution {

    class SegTree {
        int n;
        int[] tree;
        int[] lazy;

        SegTree(int n) {
            this.n = n;
            tree = new int[4 * n];
            lazy = new int[4 * n];
            Arrays.fill(lazy, -1);
        }

        void apply(int node, int l, int r, int obstacle) {
            tree[node] = obstacle - l;
            lazy[node] = obstacle;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == -1) return;

            int mid = (l + r) >> 1;

            apply(node << 1, l, mid, lazy[node]);
            apply(node << 1 | 1, mid + 1, r, lazy[node]);

            lazy[node] = -1;
        }

        void update(int node, int l, int r,
                    int ql, int qr, int obstacle) {

            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r, obstacle);
                return;
            }

            push(node, l, r);

            int mid = (l + r) >> 1;

            update(node << 1, l, mid, ql, qr, obstacle);
            update(node << 1 | 1, mid + 1, r, ql, qr, obstacle);

            tree[node] =
                Math.max(tree[node << 1], tree[node << 1 | 1]);
        }

        int query(int node, int l, int r,
                  int ql, int qr) {

            if (ql > r || qr < l) return 0;

            if (ql <= l && r <= qr)
                return tree[node];

            push(node, l, r);

            int mid = (l + r) >> 1;

            return Math.max(
                query(node << 1, l, mid, ql, qr),
                query(node << 1 | 1, mid + 1, r, ql, qr)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        int MAX = 50000;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX + 1);

        for (int[] q : queries) {
            if (q[0] == 1)
                obstacles.add(q[1]);
        }

        SegTree seg = new SegTree(MAX + 1);

        Integer prev = 0;

        for (Integer cur : obstacles.tailSet(1)) {
            seg.update(
                1, 0, MAX,
                prev, cur - 1,
                cur
            );
            prev = cur;
        }

        List<Boolean> ansRev = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {

            int[] q = queries[i];

            if (q[0] == 2) {

                int x = q[1];
                int sz = q[2];

                int best = seg.query(
                    1, 0, MAX,
                    0, x - sz
                );

                ansRev.add(best >= sz);

            } else {

                int x = q[1];

                Integer p = obstacles.lower(x);
                Integer n = obstacles.higher(x);

                seg.update(
                    1, 0, MAX,
                    p, x - 1,
                    n
                );

                obstacles.remove(x);
            }
        }

        Collections.reverse(ansRev);
        return ansRev;
    }
}