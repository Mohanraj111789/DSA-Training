import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        while(i<g.length && j<s.length)
        {
            if(g[i]<=s[j])
            {
                i++;
            }
            
            j++;
        }
        return i;
        
    }
}
//complete the main function and input output handling part
public class Assigncokies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] g = new int[n];
        int[] s = new int[m];
        for(int i=0;i<n;i++)
        {
            g[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            s[i] = sc.nextInt();
        }
        replacewithRanks sol = new replacewithRanks();
        int result = sol.findContentChildren(g,s);
        System.out.println(result);
        sc.close();
    }
}   