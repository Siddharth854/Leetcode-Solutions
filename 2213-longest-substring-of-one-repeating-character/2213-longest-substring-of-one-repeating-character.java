class Solution {

    class Info {
        int leftChar;
        int rightChar;
        int leftLen;
        int rightLen;
        int maxLen;
        int len;

        Info(int ch) {
            leftChar = ch;
            rightChar = ch;
            leftLen = 1;
            rightLen = 1;
            maxLen = 1;
            len = 1;
        }
    }

    Info[] tree;

    Info merge(Info a, Info b) {

        Info res = new Info(0);

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.leftLen = a.leftLen;
        res.rightLen = b.rightLen;

        res.maxLen = Math.max(a.maxLen, b.maxLen);

        // Boundary characters are same
        if (a.rightChar == b.leftChar) {

            res.maxLen = Math.max(
                res.maxLen,
                a.rightLen + b.leftLen
            );

            // Entire left segment has same character
            if (a.leftLen == a.len) {
                res.leftLen = a.len + b.leftLen;
            }

            // Entire right segment has same character
            if (b.rightLen == b.len) {
                res.rightLen = b.len + a.rightLen;
            }
        }

        return res;
    }

    void build(int node, int l, int r, char[] s) {

        if (l == r) {
            tree[node] = new Info(s[l] - 'a');
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, s);
        build(node * 2 + 1, mid + 1, r, s);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int index, int ch) {

        if (l == r) {
            tree[node] = new Info(ch);
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();

        // IMPORTANT: initialize tree
        tree = new Info[4 * n];

        char[] arr = s.toCharArray();

        // Build segment tree
        build(1, 0, n - 1, arr);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            int ch = queryCharacters.charAt(i) - 'a';

            // Update character
            update(1, 0, n - 1, index, ch);

            // Root contains answer for whole string
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }
}