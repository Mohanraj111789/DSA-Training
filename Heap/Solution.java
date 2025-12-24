public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        pq.add(new int[]{A.get(A.size()-1)+B.get(B.size()-1), A.size()-1, B.size()-1});
        HashSet<String> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (C-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];
            result.add(sum);
            if (i > 0 && !set.contains(i-1 + "," + j)) {
                set.add(i-1 + "," + j);
                pq.add(new int[]{A.get(i-1) + B.get(j), i-1, j});
            }
            if (j > 0 && !set.contains(i + "," + (j-1))) {
                set.add(i + "," + (j-1));
                pq.add(new int[]{A.get(i) + B.get(j-1), i, j-1});
            }
        }
        return result;
    }
}
//problem link:h