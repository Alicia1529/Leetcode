// O(N lg N) running time + O(1) memory

public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}



import java.util.*;
class Solution {
    public int[] listToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            array[i] = list.get(i);
        }
        return array;
    }
    public int findKthLargest(int[] nums, int k) {
        int idx = nums.length/2;
        int mid = nums[idx];
        List<Integer> small = new ArrayList<>();
        List<Integer> mid_equal = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if (nums[i]<mid){
                small.add(nums[i]);
            }
            else if (nums[i]>mid){
                large.add(nums[i]);
            }
            else{
                mid_equal.add(nums[i]);
            }
        }
        if (k <= large.size()){
            int[] array = listToArray(large);
            return findKthLargest(array,k);
        }
        else if (k<=large.size()+mid_equal.size()){
            return mid_equal.get(0);
        }
        else{
            int[] array = listToArray(small);
            return findKthLargest(array,k-large.size()-mid_equal.size());
        }

    }
}


/////////////

public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
