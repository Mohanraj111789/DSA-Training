class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[1] - b[1]);
        int lastEnd = intervals[0][1];
        int ans = 0;
        for(int i=1;i<intervals.length;i++)
        {
            if(lastEnd>intervals[i][0])
            {
                ans++;
            }
            else
                lastEnd = intervals[i][1];
        }
        return ans;
        
    }
}
// public class NonOverlapping {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] intervals = new int[n][2];
//         for(int i=0;i<n;i++)
//         {
//             intervals[i][0] = sc.nextInt();
//             intervals[i][1] = sc.nextInt();
//         }
//         Solution sol = new Solution();
//         int result = sol.eraseOverlapIntervals(intervals);
//         System.out.println(result);
//         sc.close();
//     }
// }