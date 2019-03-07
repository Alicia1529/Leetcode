// time O(n) space O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        k = k%nums.length;//very important !!!!!!! make it circular
        for(int i = 0;i<nums.length-k;i++){
            ans[i+k] = nums[i];
        }
        for(int i = nums.length-k;i<nums.length;i++){
            ans[i-nums.length+k] = nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            nums[i] = ans[i];
        }

    }
}


public class Solution {

public void rotate(int[] nums, int k) {

    if(nums == null || nums.length < 2){
        return;
    }

    k = k % nums.length;
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);

}

private void reverse(int[] nums, int i, int j){
    int tmp = 0;
    while(i < j){
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
    }
}
}
