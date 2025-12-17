class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        int maxDead = 0;
        for(int d : deadline)
        {
            maxDead = Math.max(maxDead,d);
        }
        int slots[] = new int[maxDead+1];
        Arrays.fill(slots,-1);
        Integer idx[] = new Integer[n];
        for(int i=0;i<n;i++)
            idx[i] = i;
        Arrays.sort(idx, (a,b) -> profit[b] - profit[a]);
        int countJobs = 0;
        int jobProfit = 0;
        for(int i=0;i<n;i++)
        {
            int jobIdx = idx[i];
            for(int j=deadline[jobIdx];j>0;j--)
            {
                if(slots[j] == -1)
                {
                    slots[j] = jobIdx;
                    countJobs++;
                    jobProfit += profit[jobIdx];
                    break;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(countJobs);
        res.add(jobProfit);
        return res;
    }
}