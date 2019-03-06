// two pass O(m+n) space
void sortColors(int A[], int n) {
    int num0 = 0, num1 = 0, num2 = 0;

    for(int i = 0; i < n; i++) {
        if (A[i] == 0) ++num0;
        else if (A[i] == 1) ++num1;
        else if (A[i] == 2) ++num2;
    }

    for(int i = 0; i < num0; ++i) A[i] = 0;
    for(int i = 0; i < num1; ++i) A[num0+i] = 1;
    for(int i = 0; i < num2; ++i) A[num0+num1+i] = 2;
}
///


class Solution {
    public void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public void sortColors(int[] nums) {
        int last0 = 0, first2 = nums.length-1;
        for(int i = 0; i<=first2;i++){
          if (nums[i]==0){
            swap(nums,last0,i);
            last0++;
          }
          else if (nums[i]==2){
            swap(nums,first2,i);
            first2--;
            i--;
          }
        }
    }
}
