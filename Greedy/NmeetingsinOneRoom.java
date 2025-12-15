import java.util.*;

class Node {
    int start;
    int end;
    
    Node(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        ArrayList<Node> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            arr.add(new Node(start[i], end[i]));
        }
        
        // Sort meetings by end time
        Collections.sort(arr, (a, b) -> a.end - b.end);
        
        int count = 1;
        int lastEnd = arr.get(0).end;
        
        for (int i = 1; i < n; i++) {
            if (arr.get(i).start > lastEnd) {
                count++;
                lastEnd = arr.get(i).end;
            }
        }
        
        return count;
    }
}
// public class NmeetingsinOneRoom {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] start = new int[n];
//         int[] end = new int[n];
        
//         for (int i = 0; i < n; i++) {
//             start[i] = sc.nextInt();
//         }
        
//         for (int i = 0; i < n; i++) {
//             end[i] = sc.nextInt();
//         }
        
//         Solution sol = new Solution();
//         int result = sol.maxMeetings(start, end);
//         System.out.println(result);
        
//         sc.close();
//     }
// }