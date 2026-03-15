class Solution {

    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        backtrack(n, "", list);

        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void backtrack(int n, String curr, List<String> list) {

        if (curr.length() == n) {
            list.add(curr);
            return;
        }

        for (char ch : new char[]{'a','b','c'}) {

            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                continue;

            backtrack(n, curr + ch, list);
        }
    }
}