import java.util.*;

        class Pair {
        String word;
        int step;

        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
        }
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair current = q.poll();
            String word = current.word;
            int step = current.step;

            if (word.equals(endWord)) {
                return step;
            }

            char[] chars = word.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = new String(chars);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, step + 1));
                    }
                }

                chars[i] = original;
            }
        }

        return 0;
    }
    }