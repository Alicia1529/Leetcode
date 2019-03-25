
class Solution {
public:
    /**
     * @param nums: a vector of integers
     * @return: an integer
     */
    int maxProduct(vector<int>& nums) {
        // write your code here
        int posMax = nums[0];
        int negMax = nums[0];
        int ret = nums[0];
        for(int i=1;i<nums.size();i++)
        {
            int tempPosMax = posMax;
            int tempNegMax = negMax;
            posMax = max(nums[i],max(nums[i]*tempPosMax,nums[i]*tempNegMax));
            negMax = min(nums[i],min(nums[i]*tempPosMax,nums[i]*tempNegMax));
            ret = max(ret,posMax);
        }
        return ret;
    }


import copy
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        seq_max,seq_min = copy.deepcopy(nums),copy.deepcopy(nums)
        for i in range(1,len(nums)):
            seq_max[i] = max(nums[i],seq_max[i-1]*nums[i],seq_min[i-1]*nums[i])
            seq_min[i] = min(nums[i],seq_max[i-1]*nums[i],seq_min[i-1]*nums[i])

        return max(seq_max)
        
