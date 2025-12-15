class Solution {
    public boolean canJump(int[] nums) {
        int maxi = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(i<=maxi)
            {
                maxi = Math.max(maxi,i+nums[i]);
                if(maxi>=nums.length-1)
                    return true;
            }
        }
        return false;
        
    }
}

// public class jumpgame1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] nums = new int[n];
//         for(int i=0;i<n;i++)
//         {
//             nums[i] = sc.nextInt();
//         }
//         Solution sol = new Solution();
//         boolean result = sol.canJump(nums);
//         System.out.println(result);
//         sc.close();
        
//     }
    
// }