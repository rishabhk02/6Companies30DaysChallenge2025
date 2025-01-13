package Walmart;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0;
        int cost = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cost += Math.abs(t.charAt(i) - s.charAt(i));
            }
            while (cost > maxCost) {
                if (s.charAt(left) != t.charAt(left)) {
                    cost -= Math.abs(s.charAt(left) - t.charAt(left));
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}