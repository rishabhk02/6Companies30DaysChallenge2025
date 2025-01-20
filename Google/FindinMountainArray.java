package Google;
import java.util.*;

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);

    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peak = findPeak(len, mountainArr);
        int left = helper(0, peak, target, mountainArr, 0);
        if (left != -1)
            return left;

        int right = helper(peak + 1, len - 1, target, mountainArr, 1);
        if (right != -1)
            return right;
        return -1;
    }

    int helper(int low, int high, int tar, MountainArray mount, int f) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int v = mount.get(mid);
            if (v == tar)
                return mid;
            if (v > tar) {
                if (f == 0) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            } else {
                if (f == 1) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
        }
        return -1;
    }

    int findPeak(int n, MountainArray mount) {
        int low = 0;
        int high = n - 1;
        int peak = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cur = mount.get(mid);
            int left = (mid - 1 < 0) ? Integer.MIN_VALUE : mount.get(mid - 1);
            int right = (mid + 1 >= n) ? Integer.MAX_VALUE : mount.get(mid + 1);
            if (left < cur && right < cur)
                return mid;
            if (cur > left)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}