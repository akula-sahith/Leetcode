import java.util.*;

class LazyTag {
    int toAdd;

    LazyTag() {
        this.toAdd = 0;
    }

    void add(int val) {
        this.toAdd += val;
    }

    boolean hasTag() {
        return this.toAdd != 0;
    }

    void clear() {
        this.toAdd = 0;
    }
}

class SegmentTreeNode {
    int minValue;
    int maxValue;
    LazyTag lazy;

    SegmentTreeNode() {
        minValue = 0;
        maxValue = 0;
        lazy = new LazyTag();
    }
}

class SegmentTree {

    int n;
    SegmentTreeNode[] tree;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new SegmentTreeNode[4 * n];
        for (int i = 0; i < 4 * n; i++)
            tree[i] = new SegmentTreeNode();
        build(arr, 0, n - 1, 0);
    }

    void build(int[] arr, int l, int r, int idx) {
        if (l == r) {
            tree[idx].minValue = arr[l];
            tree[idx].maxValue = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, l, mid, 2 * idx + 1);
        build(arr, mid + 1, r, 2 * idx + 2);
        pullUp(idx);
    }

    void pullUp(int idx) {
        tree[idx].minValue = Math.min(
            tree[2 * idx + 1].minValue,
            tree[2 * idx + 2].minValue
        );
        tree[idx].maxValue = Math.max(
            tree[2 * idx + 1].maxValue,
            tree[2 * idx + 2].maxValue
        );
    }

    void pushDown(int idx) {
        if (tree[idx].lazy.hasTag()) {
            int val = tree[idx].lazy.toAdd;

            apply(2 * idx + 1, val);
            apply(2 * idx + 2, val);

            tree[idx].lazy.clear();
        }
    }

    void apply(int idx, int val) {
        tree[idx].minValue += val;
        tree[idx].maxValue += val;
        tree[idx].lazy.add(val);
    }

    void update(int L, int R, int val) {
        update(L, R, val, 0, n - 1, 0);
    }

    void update(int L, int R, int val, int l, int r, int idx) {
        if (L > r || R < l) return;

        if (L <= l && r <= R) {
            apply(idx, val);
            return;
        }

        pushDown(idx);
        int mid = (l + r) / 2;
        update(L, R, val, l, mid, 2 * idx + 1);
        update(L, R, val, mid + 1, r, 2 * idx + 2);
        pullUp(idx);
    }

    // find largest index >= start where value == 0
    int findLastZero(int start) {
        return find(start, 0, n - 1, 0);
    }

    int find(int start, int l, int r, int idx) {
        if (r < start) return -1;

        if (tree[idx].minValue > 0 || tree[idx].maxValue < 0)
            return -1;

        if (l == r) return l;

        pushDown(idx);

        int mid = (l + r) / 2;

        int right = find(start, mid + 1, r, 2 * idx + 2);
        if (right != -1) return right;

        return find(start, l, mid, 2 * idx + 1);
    }
}

class Solution {

    public int longestBalanced(int[] nums) {

        int n = nums.length;

        Map<Integer, Queue<Integer>> pos = new HashMap<>();

        // store all positions (0-based)
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums[i], k -> new LinkedList<>()).add(i);
        }

        int[] prefix = new int[n];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            prefix[i] = (i > 0 ? prefix[i - 1] : 0);

            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
                prefix[i] += sign(nums[i]);
            }
        }

        SegmentTree seg = new SegmentTree(prefix);

        int ans = 0;

        for (int l = 0; l < n; l++) {
    // 1. Search for the current baseline (which is now always 0 after our shifts)
    int r = seg.findLastZero(l);
    if (r != -1) ans = Math.max(ans, r - l + 1);

    // 2. Prepare for l + 1: Remove the contribution of nums[l] from the whole array
    int s = sign(nums[l]);
    seg.update(l, n - 1, -s); 

    // 3. If nums[l] exists later, it now becomes the "first" occurrence
    Queue<Integer> q = pos.get(nums[l]);
    q.poll(); 
    if (!q.isEmpty()) {
        int nextPos = q.peek();
        seg.update(nextPos, n - 1, s);
    }
}

        return ans;
    }

    private int sign(int x) {
    return (x % 2 == 0) ? -1 : 1;
}

}
