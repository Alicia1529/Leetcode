class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in range(1, len(nums)):
                if nums[i-1] > 0:
                    nums[i] += nums[i-1]
        return max(nums)


class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res=before=nums[0]
        for num in nums[1:]:
            if before>=0:
                before=before+num
            else:
                before=num
            if res<before:
                res=before
        return res

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n==1: return nums[0]
        p1 = nums[:n//2]
        p2 = nums[n//2:]
        m1 = self.maxSubArray(p1)
        m2 = self.maxSubArray(p2)
        m3 = self.maxTail(p1)
        m4 = self.maxHead(p2)
        return max(m1,m2,m3+m4)

    def maxTail(self,tail):
        _max = tail[-1]
        _cur = tail[-1]
        for i in range(len(tail)-2,-1,-1):
            _cur+=tail[i]
            if _cur>_max: _max = _cur
        return _max
    def maxHead(self,head):
        _max = head[0]
        _cur = head[0]
        for i in range(1,len(head)):
            _cur+=head[i]
            if _cur>_max: _max = _cur
        return _max
