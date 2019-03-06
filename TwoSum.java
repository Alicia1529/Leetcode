class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length-1;
        int sum = numbers[p1]+numbers[p2];
        while (sum!=target && p1<p2){
            if (sum<target){
                p1+=1;
            }
            else if (sum>target){
                p2-=1;
            }
            sum = numbers[p1]+numbers[p2];
        }
        int[] ans = {p1+1,p2+1};
        return ans;
    }
}
