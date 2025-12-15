class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int currFarthest = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            currFarthest = Math.max(currFarthest,i+nums[i]);
            if(i == currEnd)
            {
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;

    }
}

// public class jumpgame2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] nums = new int[n];
//         for(int i=0;i<n;i++)
//         {
//             nums[i] = sc.nextInt();
//         }
//         Solution sol = new Solution();
//         int result = sol.jump(nums);
//         System.out.println(result);
//         sc.close();
