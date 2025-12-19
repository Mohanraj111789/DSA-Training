class Solution {
    class Job {
        int deadline;
        int profit;
        Job(int d, int p) {
            this.deadline = d;
            this.profit = p;
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (int d : deadline) {
            if (d > maxDeadline) {
                maxDeadline = d;
            }
        }
        int jobsDone = 0;
        int totalProfit = 0;
        int [] slot = new int[maxDeadline + 1];
        for(int i=0;i<jobs.length;i++)
        {
            Job job = jobs[i];
            for(int j=job.deadline;j>0;j--)
            {
                if(slot[j]==0)
                {
                    jobsDone++;
                    totalProfit+=job.profit;
                    slot[j]=job.profit;
                    break;
                }
            }

        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(jobsDone);
        res.add(totalProfit);
        return res;
    }
}