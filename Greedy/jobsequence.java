class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        //your code goes here
        Arrays.sort(Jobs,(a,b)->b[2]-a[2]);
        int n = Jobs.length;
        int maxDeadline = 0;
        for(int i=0;i<n;i++)
        {
            maxDeadline = Math.max(maxDeadline,Jobs[i][1]);
        }
        int[] slot = new int[maxDeadline+1];
        Arrays.fill(slot,-1);
        int countJobs = 0;
        int jobProfit = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=Jobs[i][1];j>0;j--)
            {
                if(slot[j] == -1)
                {
                    slot[j] = Jobs[i][0];
                    countJobs++;
                    jobProfit += Jobs[i][2];
                    break;
                }
            }
        }
        return new int[]{countJobs,jobProfit};
    }
}
// pro
