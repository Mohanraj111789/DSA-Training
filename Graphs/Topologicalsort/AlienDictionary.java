import java.util.*;

class Solution {
    public String bfs(ArrayList<ArrayList<Integer>> adj, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char) (node + 'a'));
            for (int ne : adj.get(node)) {
                inDegree[ne]--;
                if (inDegree[ne] == 0)
                    q.add(ne);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] > 0)
                return "";
        }
        return ans.toString();
    }
    public String findOrder(String[] words) {
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            adj.add(new ArrayList<>());
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (inDegree[c - 'a'] == -1)
                    inDegree[c - 'a'] = 0;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            int len = Math.min(str1.length(), str2.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                int u = str1.charAt(j) - 'a';
                int v = str2.charAt(j) - 'a';
                if (str1.charAt(j) != str2.charAt(j)) {
                    
                        adj.get(u).add(v);
                        inDegree[v]++;
                    }

                    found = true;
                    break;
               
            }
            if (!found && str1.length() > str2.length())
                return "";
        }

        return bfs(adj, inDegree);
    }
}
//problem Link:https://www.geeksforgeeks.org/problems/alien-dictionary/1