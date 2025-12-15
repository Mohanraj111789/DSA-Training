class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]>ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i=1;i<intervals.length;i++)
        {
            if(ans.get(ans.size()-1)[1]>=intervals[i][0])
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            
            else
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        return ans.toArray(new int[ans.size()][]);
        
    }
}

// public class mergeInterval {
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
//         int[][] result = sol.merge(intervals);
//         for(int i=0;i<result.length;i++)
//         {
//             System.out.println(result[i][0] + " " + result[i][1]);
//         }
//         sc.close();
//     }
// }
