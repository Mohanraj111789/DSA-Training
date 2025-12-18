class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)
        {
            pq.add(i);
        }
        for(int i=1;i<=k-1;i++)
        {
            pq.poll();
        }
        return pq.peek();
    }
}
//time complexity: O(N log N) explanation: we are adding N elements to the heap and each add operation takes log N time 
//and popping k elements takes O(k log N) time overall time complexity is O(N log N + k log N) which is asymptotically equal to O(N log N)
//space complexity: O(N) we are using a heap to store N elements

//problem link: https://leetcode.com/problems/kth-largest-element-in-an-array/ for accessing the question CTRL+click

