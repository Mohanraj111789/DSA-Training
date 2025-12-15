class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int n = Arrival.length;
        int platform_needed = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        while(i<n && j<n)
        {
            if(Arrival[i]<=Departure[j])
            {
                platform_needed++;
                i++;
                if(platform_needed>result)
                    result = platform_needed;
            }
            else
            {
                platform_needed--;
                j++;
            }
        }
        return result;
    }
}
// public class minimumPlatform {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] Arrival = new int[n];
//         int[] Departure = new int[n];
//         for(int i=0;i<n;i++)
//         {
//             Arrival[i] = sc.nextInt();
//         }
//         for(int i=0;i<n;i++)
//         {
//             Departure[i] = sc.nextInt();
//         }
//         Solution sol = new Solution();
//         int result = sol.findPlatform(Arrival,Departure);
//         System.out.println(result);
//         sc.close();
//     }
// }
