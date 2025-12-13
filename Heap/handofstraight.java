import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        /*
        =======================
        APPROACH EXPLANATION
        =======================

        We need to divide the cards into groups of size = groupSize
        such that each group consists of consecutive numbers.

        Key Observations:
        - Total number of cards must be divisible by groupSize
        - Always try to form a group starting from the smallest available card
          (greedy strategy)

        Data Structures Used:
        1) HashMap -> to store frequency of each card
        2) Min Heap (PriorityQueue) -> to always get the smallest card
        */

        // If total cards cannot be divided into equal groups
        if (hand.length % groupSize != 0)
            return false;

        /*
        =======================
        STEP 1: FREQUENCY MAP
        =======================
        */
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int card : hand)
            freq.put(card, freq.getOrDefault(card, 0) + 1);

        /*
        Example:
        hand = [1,2,3,6,2,3,4,7,8]
        freq = {
            1=1, 2=2, 3=2, 4=1, 6=1, 7=1, 8=1
        }
        */

        /*
        =======================
        STEP 2: MIN HEAP
        =======================

        Heap stores all unique card values in sorted order
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : freq.keySet())
            pq.add(x);

        /*
        Heap (min-first):
        [1, 2, 3, 4, 6, 7, 8]
        */

        /*
        =======================
        STEP 3: FORM GROUPS
        =======================
        */
        while (!pq.isEmpty()) {

            int first = pq.peek(); // smallest available card

            // If frequency becomes zero, remove from heap
            if (freq.get(first) == 0) {
                pq.poll();
            } 
            else {
                /*
                Try to form a group:
                first, first+1, first+2, ..., first+(groupSize-1)
                */

                // Use the first card
                freq.put(first, freq.get(first) - 1);

                for (int i = 1; i <= groupSize - 1; i++) {
                    first++; // move to next consecutive card

                    // If required card doesn't exist or exhausted
                    if (!freq.containsKey(first) || freq.get(first) == 0)
                        return false;

                    // Use the card
                    freq.put(first, freq.get(first) - 1);
                }
            }
        }

        /*
        =======================
        DRY RUN
        =======================

        Input:
        hand = [1,2,3,6,2,3,4,7,8]
        groupSize = 3

        Frequency Map:
        1=1, 2=2, 3=2, 4=1, 6=1, 7=1, 8=1

        Heap:
        [1,2,3,4,6,7,8]

        Iteration 1:
        first = 1
        Group: [1,2,3]
        Updated freq:
        1=0, 2=1, 3=1

        Iteration 2:
        first = 2
        Group: [2,3,4]
        Updated freq:
        2=0, 3=0, 4=0

        Iteration 3:
        first = 6
        Group: [6,7,8]
        Updated freq:
        6=0, 7=0, 8=0

        Heap becomes empty
        ✔ All groups formed successfully
        */

        return true;
    }
}
