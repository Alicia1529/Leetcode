# Input: 1->2->2->1
# Output: true

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        dic = {}
        length = 0
        while head is not None:
            dic[length] = head
            head = head.next
            length+=1
        lo = 0
        hi = length-1
        while lo<hi:
            if dic[lo].val!=dic[hi].val:
                return False
            lo+=1
            hi-=1
        return True


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import copy
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None: return True
        reverse_head = copy.deepcopy(head)
        next_re = reverse_head.next
        reverse_head.next = None

        while next_re:
            tmp = next_re.next
            next_re.next = reverse_head
            reverse_head = next_re
            next_re = tmp
        while reverse_head and head:
            if reverse_head.val!=head.val:
                return False
            else:
                reverse_head = reverse_head.next
                head = head.next
        return True



# Follow up: Could you do it in O(n) time and O(1) space?

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None: return True
        if head.next.next is None:
            if head.val!=head.next.val:
                return False
            return True
        slow,fast = head,head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        reverse = self.reverse(slow)
        while reverse and head:
            if reverse.val!=head.val:
                return False
            else:
                reverse = reverse.next
                head = head.next
        return True

    def reverse(self,head):
        next_re = head.next
        head.next = None
        while next_re:
            tmp = next_re.next
            next_re.next = head
            head = next_re
            next_re = tmp
        return head
