package Amazon;

class Solution {
    public int waysToReachStair(int k) {
        int res = 0;
        for (int pow = 0; (1 << pow) - k <= pow + 1; pow++) {
            int reqBackMove = (1 << pow) - k;
            if (reqBackMove >= 0) {
                res += nCr(pow + 1, reqBackMove);
            }
        }
        return res;
    }

    int nCr(int n, int r) {
        long val = 1l;
        if (r > n - r) {
            r = n - r;
        }
        for (int i = 0; i < r; i++) {
            val = val * (n - i);
            val = val / (i + 1);
        }
        return (int) val;
    }
}