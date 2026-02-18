import java.util.*;

class Solution {

    public List<List<String>> findLadders(String beginWord,
                                          String endWord,
                                          List<String> wordList) {

        Map<String, Integer> depthMap = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        // BFS to compute shortest depth
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        depthMap.put(beginWord, 1);
        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int steps = depthMap.get(word);

            if (word.equals(endWord))
                break;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (wordSet.contains(newWord)) {
                        queue.offer(newWord);
                        wordSet.remove(newWord);
                        depthMap.put(newWord, steps + 1);
                    }
                }
                arr[i] = original;
            }
        }

        // DFS to build all shortest sequences
        if (depthMap.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, beginWord, seq, depthMap, ans);
        }

        return ans;
    }

    private void dfs(String word,
                     String beginWord,
                     List<String> seq,
                     Map<String, Integer> depthMap,
                     List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> path = new ArrayList<>(seq);
            Collections.reverse(path);
            ans.add(path);
            return;
        }

        int steps = depthMap.get(word);
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String newWord = new String(arr);

                if (depthMap.containsKey(newWord)
                        && depthMap.get(newWord) + 1 == steps) {

                    seq.add(newWord);
                    dfs(newWord, beginWord, seq, depthMap, ans);
                    seq.remove(seq.size() - 1);
                }
            }
            arr[i] = original;
        }
    }
}
