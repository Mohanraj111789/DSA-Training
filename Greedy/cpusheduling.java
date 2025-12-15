// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int tot = 0;
        int wt = 0;
        int n = bt.length;
        for(int i = 0;i<n;i++)
        {
            wt+= tot;
            tot+=bt[i];
        }
        return wt/n;
        
    }
}
// public class cpusheduling {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] bt = new int[n];
//         for(int i=0;i<n;i++)
//         {
//             bt[i] = sc.nextInt();
//         }
//         Solution sol = new Solution();
//         int result = sol.solve(bt);
//         System.out.println(result);
//         sc.close();
//      }
//}