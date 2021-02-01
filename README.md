#### 3. Longest Substring Without Repeating Characters

Approach 1: Brute Force: Time complexity : O(n^3); Space complexity: O(k)

Approach 2: Sliding Window: Time complexity : O(2n); Space complexity: O(k)

Approach 2: Sliding Window Optimized: Time complexity : O(n); Space complexity: O(k) -> define a mapping of the characters to its index *

#### 4. Median of Two Sorted Arrays *

Approach 1: Create a new array and merge them: Time complexity : O(m+n); Space complexity: O(m+n)

Approach 2: Loop and count the mid index: Time complexity : O(m+n); Space complexity: O(1) **(2020.1.1)**
```
Runtime: 2 ms, faster than 99.97% of Java online submissions for Median of Two Sorted Arrays.
Memory Usage: 46.7 MB, less than 90.97% of Java online submissions for Median of Two Sorted Arrays.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int i = 0, j = 0;
        int median1 = -1, median2 = -1;
        for (int idx = 0; idx <= length/2; idx ++) {
            median1 = median2;
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    median2 = nums1[i++];
                } else {
                    median2 = nums2[j++];
                }
            } else if (i < m) {
                median2 = nums1[i++];
            } else {
                median2 = nums2[j++];
            }
        }
        if (length%2 == 1) {
            return median2;
        } else {
            return (median1+median2)/2.0; // notice the 2.0 here!!!! otherwise it's an integer
        }
    }
}
```
Approach 3: Top k 

Approach 4: Binary Search
```
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0, left2 = 0;
        int right1 = nums1.length - 1;
        int right2 = nums2.length - 1;
        int length = nums1.length + nums2.length;
        while (left1 <= right1 && left2 <= right2) {
            if (nums1[(left1+right1)/2] < nums2[(left2+right2)/2]) {
                left1 = (left1+right1)/2;
                right2 = (left2+right2)/2;
            } else {
                right1 = (left1+right1)/2;
                left2 = (left2+right2)/2;
            }
        }
    while (left1 <= right1) {
        le
    }

    }
}
...
```

#### 5. Longest Palindromic Substring *

Approach 1: Expand Around Center: Time complexity : O(N); Space complexity: O(1)  **(2020.1.1)**
```
Runtime: 35 ms, faster than 43.28% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Longest Palindromic Substring.

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxStart = 0;
        int maxLength = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int left = i - 1, right = i + 1;
            int tempLen = 1;
            while (0 <= left && s.charAt(left) == s.charAt(i)) {
                left--;
                tempLen++;
            }
            while (right < len && s.charAt(right) == s.charAt(i)) {
                right ++;
                tempLen++;
            }
            while (0 <= left && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                tempLen+=2;
            }
            if (maxLength < tempLen) {
                maxLength = tempLen;
                maxStart = left + 1;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}
```
#### 9. Palindrome Number **(2020.1.3)**
Approch 1: Revert half of the number: Time complexity : O(N); Space complexity: O(1)
```
class Solution {
    public boolean isPalindrome(int x) {
       int rev=0;
        if(x<0 || (x%10==0 && x!=0)){
          return false;   
        }
        while(x>rev){
            rev=rev*10+x%10;
            x=x/10;  
        }
        return x==rev || x==rev/10;
}
}
```

class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length < 2) return 0;
        int maxArea = 0;
        int i = 0, j = length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
#### 11. Container With Most Water **(2020.1.3)**
Approch 1: Revert half of the number: Time complexity : O(N); Space complexity: O(1)
```
class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length < 2) return 0;
        int maxArea = 0;
        int i = 0, j = length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
```




A process is an executing instance of an application, for example, double-clicking on the Internet browser icon on the desktop will start a process than runs the browser. A thread is an active flow of control that can be activated in parallel with other threads within the same process. The term "flow control" means a sequential execution of machine instructions. Also, a process can contain multiple threads, so starting the browser, the operating system creates a process and begins executing the primary threads of that process. Each thread can execute a set of instructions (typically, a function) independently and in parallel with other processes or threads. However, being the different active threads within the same process, they share space addressing and then the data structures. A thread is sometimes called a lightweight process because it shares many characteristics of a process, in particular, the characteristics of being a sequential flow of control that is executed in parallel with other control flows that are sequential. The term "light" is intended to indicate that the implementation of a thread is less onerous than that of a real process. However, unlike the processes, multiple threads may share many resources, in particular, space addressing and then the data structures.

Let's recap:
* A process can consist of multiple parallel threads.
* Normally, the creation and management of a thread by the operating system is less expensive in terms of CPU's resources than the creation and management of a process. Threads are used for small tasks, whereas processes are used for more heavyweight tasks—basically, the execution of applications.
* The threads of the same process share the address space and other resources, while processes are independent of each other.




