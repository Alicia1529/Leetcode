# Input: 1->2->3->4->5->NULL
# Output: 5->4->3->2->1->NULL
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head==None:return None
        tmp_h = head
        tmp_n = head.next
        tmp_h.next = None
        while tmp_n:
            tmp = tmp_n.next
            tmp_n.next = tmp_h
            tmp_h = tmp_n
            tmp_n = tmp
        return tmp_h


class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head==None:return None
        if head.next==None:return head
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_head
