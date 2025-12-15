class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans = n;
        int i=1;
        while(i<n)
        {
            if(ratings[i-1] == ratings[i])
            {
                i++;
                continue;
            }
            int peak = 0;
            while(i<n && ratings[i-1]<ratings[i])
            {
                peak++;
                ans+=peak;
                i++;
            }
            int vally = 0;
            while (i<n && ratings[i-1]>ratings[i]) {
                vally++;
                ans+=peak;
                i++;
                
            }
            ans-=Math.min(peak,vally);
        }
        return ans;
    }
}