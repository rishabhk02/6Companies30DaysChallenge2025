package GoldmanSachs;
import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len=nums[0].length(); int n=nums.length;
        int list[][] = new int[len][n];
        radixSort(nums,list);
        int res[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            res[i]=list[queries[i][1]-1][queries[i][0]-1];
        }
        return res;
    }

    public void radixSort(String[] nums, int[][] list){
        int n = nums[0].length();
        int[] index = new int[nums.length];
        for(int i=0; i<nums.length; i++)  
            index[i] = i;
        list[0] = countSort(nums,index,  n-1);
        for(int i=1; i<n; i++){
            list[i] = countSort(nums, list[i-1], n-1-i);
        }
    }

    public int[] countSort(String[] nums, int[] index, int idx){
        int n = nums.length;
        int[] sorted = new int[n];
        int[] count = new int[10];
        for(String s:nums)
            count[s.charAt(idx)-'0']++;
        for(int i=1; i<10; i++)
            count[i] += count[i-1];
        for(int i=n-1; i>=0; i--){
            sorted[count[nums[index[i]].charAt(idx)-'0']-- -1] = index[i];
        }
        return sorted;
    }
}

class RadixSort{
    public static void radixSort(int[][] list, String[] nums){
        int n = nums[0].length();
        int[] index = new int[nums.length];
        for(int i=0; i<nums.length; i++)  
            index[i] = i;
        list[0] = countingSort(index, nums, n-1);
        for(int i=1; i<n; i++){
            list[i] = countingSort(list[i-1], nums, n-1-i);
        }
    }
    public static int[] countingSort(int[] index, String[] nums, int idx){
        int n = nums.length;
        int[] sorted = new int[n];
        int[] count = new int[10];
        for(String s:nums)
            count[s.charAt(idx)-'0']++;
        for(int i=1; i<10; i++)
            count[i] += count[i-1];
        for(int i=n-1; i>=0; i--){
            sorted[count[nums[index[i]].charAt(idx)-'0']-- -1] = index[i];
        }
        return sorted;
    }
}