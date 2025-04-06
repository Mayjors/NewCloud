package demo.eu.algorithm;

import java.util.Arrays;

public class Leetcode1005 {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) { return;}
        //System.out.println(Arrays.toString(a));
        int i = lo, j = hi;
        int pivot = a[lo];
        while (i < j) {
            while((i<j)&&(Math.abs(a[j]) >= Math.abs(pivot))){
                j--;
            }
            swap(a, i, j);
            while((i<j)&&(Math.abs(a[i]) < Math.abs(pivot))){
                i++;
            }
            swap(a, i, j);
        }
        a[i] = pivot;
        quickSort(a, lo, i-1);
        quickSort(a, i+1, hi);
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        quickSort(nums, 0, n-1);
        System.out.println(Arrays.toString(nums));
        for (int i = n-1; i>=0; i--){
            if (nums[i] < 0){
                nums[i] = -nums[i];
            }
            k--;
            if (k == 0){break;}
        }
        if(k%2==1){
            nums[0] = -nums[0];
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        Leetcode1005 leetcode1005 = new Leetcode1005();
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        int n = leetcode1005.largestSumAfterKNegations(nums, k);
        System.out.println(n);
    }
}
