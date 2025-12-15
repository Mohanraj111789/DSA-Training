class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int n = intervals.length;
        while(i<n && intervals[i][1]<newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n)
        {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

// public class insertInterval {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] intervals = new int[n][2];
//         for(int i=0;i<n;i++)
//         {
//             intervals[i][0] = sc.nextInt();
//             intervals[i][1] = sc.nextInt();
//         }
//         int[] newInterval = new int[2];
//         newInterval[0] = sc.nextInt();
//         newInterval[1] = sc.nextInt();
//         Solution sol = new Solution();
//         int[][] result = sol.insert(intervals,newInterval);
//         for(int i=0;i<result.length;i++)
//         {
//             System.out.println(result[i][0] + " " + result[i][1]);
//         }
//         sc.close();
//     }
// }
